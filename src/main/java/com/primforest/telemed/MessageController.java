package com.primforest.telemed;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/")
public class MessageController {
    @Autowired
     MessageService messageService;
    @Autowired
    MessageRepository messageRepository;
    @PostMapping("/newMessage")
    public  RestResponseNewMessage newMessage(@RequestBody RestRequestNewMessage restRequestNewMessage){
  return
messageService.createNew(restRequestNewMessage);}

     @GetMapping(value = "/allMessages")
     List<MessageEntity> getAllMessages(){
      return  messageRepository.findAll();
        }
    }

