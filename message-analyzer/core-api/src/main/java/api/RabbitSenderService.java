package api;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RabbitSenderService {

    void sendMessage(RequestMessageDto messageDto, String queue) throws JsonProcessingException;
}
