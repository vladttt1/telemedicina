package com.primforest.telemed;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@Accessors(fluent=true,chain=true)
@Document
public class MessageEntity {

    @Id

    private  int id;
    private String message;
    private LocalDateTime saveTime;

    @Override
    public String toString() {
        return "MessageEntity{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", savetime=" + saveTime +
            '}';
    }
}
