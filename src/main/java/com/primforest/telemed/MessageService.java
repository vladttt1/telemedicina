package com.primforest.telemed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    public RestResponseNewMessage
    createNew(RestRequestNewMessage restRequestNewMessage){
        MessageEntity newEntity=MessageEntity
            .builder()
            .message(restRequestNewMessage.message())
            .saveTime(LocalDateTime.now())
            .build();
        MessageEntity save=messageRepository.save(newEntity);
        return  RestResponseNewMessage.fromEntity(save);
    }
}
