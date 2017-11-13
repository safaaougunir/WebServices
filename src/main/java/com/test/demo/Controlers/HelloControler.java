package com.test.demo.Controlers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @RequestMapping("/Hello")
    public String Hello(){
        return "Hello Safaa" ;
    }
}
