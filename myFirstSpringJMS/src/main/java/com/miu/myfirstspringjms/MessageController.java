package com.miu.myfirstspringjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private Sender sender;

    @GetMapping(path = "/api/{message}")
    public void sendMessage(@PathVariable String message){
        //sender.sendByConverting(message);
        Student student = new Student("Jack",30);
        sender.sendWithoutConverting(student.toString());
    }
}
