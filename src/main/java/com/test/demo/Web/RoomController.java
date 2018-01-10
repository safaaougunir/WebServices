package com.test.demo.Web;

import com.test.demo.DAO.LightDao;
import com.test.demo.DAO.*;
import com.test.demo.DAO.RoomDaoCustom;
import com.test.demo.Models.*;
import com.test.demo.Models.Light;
import com.test.demo.Models.Status;

import com.test.demo.DAO.RoomDao;
import com.test.demo.MqttClient.MqttPublisher;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Transactional
public class RoomController {

    @Autowired
    private MqttPublisher mqttpub;

    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;

    }

    @GetMapping(value = "/api/rooms")
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }


    @PostMapping(value = "/api/rooms/{id}/switch-light")
    public List<RoomDto> switchLight(@PathVariable Long id) {

        Light light = roomDao.getOne(id).getLight();
        light.switchlight();
        //Publish to Iot Part
        String topic = "room" + roomDao.getOne(id).getId().toString() + "/light";
        String mssg = light.getStatus() == Status.ON ? "OFF" : "ON";
        /*
        mqttpub.publish(topic,mssg );
        */
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());

    }

    @PostMapping(value = "/api/rooms/all/switch-light/{state}")
    public List<RoomDto> switchLight(@PathVariable String state) {
        List<Light> allLightswitched= roomDao.findAll().stream().filter(r -> r.getLight().getStatus()==((state.equals("ON")) ? Status.ON :Status.OFF)).map(r -> r.getLight().switchlight()).collect(Collectors.toList());
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/api/rooms/{id}/switch-noise")
    public List<RoomDto> switchNoise(@PathVariable Long id) {
        Noise noise = roomDao.getOne(id).getNoise();
        if (noise.getStatus() == Status.ON) {
            noise.setStatus(Status.OFF);
        } else {
            noise.setStatus(Status.ON);

        }
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/api/rooms/{id}")
    @ResponseBody
    public RoomDto getRoomByID(@PathVariable Long id) {
        return new RoomDto(roomDao.getOne(id));
    }


    @GetMapping(value = "/api/rooms/list_with_on_lights")
    public List<RoomDto> listWithOnLight() {
        return roomDao.findRoomsWithOnLight().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @Transactional(
            value = Transactional.TxType.REQUIRES_NEW
    )

    public void publish(String topic , String content) {
        int qos             = 2;
        String broker       = "tcp://m14.cloudmqtt.com:13086";
        String clientId     = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();

            connOpts.setCleanSession( true );
            connOpts.setUserName( "tojighyl" );
            connOpts.setPassword( "G0D6od2oUAKN".toCharArray() );

            // Attempt to connect
            sampleClient.connect(connOpts);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            sampleClient.disconnect();
            System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();}
        catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
    }

