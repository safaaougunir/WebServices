package com.test.demo.MqttClient;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class MqttPublisher {


    public static void publish(String topic, String content) {
        int qos = 2;
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
            me.printStackTrace();
        }

     }

    public static void main(String[] args) {
        publish("topoic","from java part");

    }


    }


