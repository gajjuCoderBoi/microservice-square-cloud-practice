package com.example.service1;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private int port;

    @EventListener
    public void ready(WebServerInitializedEvent event){
        this.port = event.getWebServer().getPort();
    }

    @GetMapping("greetings/{message}")
    public String greetings(@PathVariable String message){
        return "Hello: " + message + " From: " + port + "!";
    }

}
