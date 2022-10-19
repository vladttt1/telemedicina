package Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors (fluent=true,chain=true)
public class RestResponseNewMessage {
    private int   id;
    private String message;
    private LocalDateTime saveTime;
    private  LocalDateTime responseDateTime;
    public  static RestResponseNewMessage fromEntity(MessageEntity entity){
        return RestResponseNewMessage.builder()
            .message(entity.message())
            .saveTime(entity.saveTime())
            .responseDateTime(LocalDateTime.now())
            .id(entity.id())
            .build();


    }
}
