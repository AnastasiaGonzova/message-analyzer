package core.domain;

import api.RequestMessageDto;
import lombok.Data;

@Data
public class RequestMessageDtoImpl implements RequestMessageDto {

    private MessageType messageType;

    private String messageText;
}
