package core.service;

import api.RabbitSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.domain.RequestMessageDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitSenderServiceImpl implements RabbitSenderService {

    @NonNull
    private final AmqpTemplate amqpTemplate;

    @NonNull
    private final ObjectMapper objectMapper;

    @Override
    public void sendMessage(RequestMessageDto messageDto, String queue) throws JsonProcessingException {
        amqpTemplate.convertAndSend(queue, objectMapper.writeValueAsString(messageDto));
    }
}
