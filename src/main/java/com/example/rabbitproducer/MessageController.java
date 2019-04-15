package com.example.rabbitproducer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(Source.class)
public class MessageController {

    private MessageChannel output;

    MessageController(MessageChannel output){
        this.output=output;
    }

    @PostMapping("/")
    public Student add(@RequestBody Student msg) {
        output.send(new GenericMessage(msg.toString()) {
        });
        return  msg;
    }
}


