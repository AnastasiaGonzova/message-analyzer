package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.domain.RequestMessageDto;

public interface RabbitSenderService {

    void sendMessage(RequestMessageDto messageDto, String queue) throws JsonProcessingException;
}
