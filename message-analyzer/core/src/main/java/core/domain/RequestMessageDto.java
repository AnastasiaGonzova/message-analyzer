package core.domain;

import lombok.Data;

@Data
public class RequestMessageDto {

    private MessageType messageType;

    private String messageText;
}
