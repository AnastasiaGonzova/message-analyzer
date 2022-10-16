package core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.configuration.RabbitMQConfiguration;
import core.domain.RequestMessageDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitSenderServiceImpl implements RabbitSenderService{

    @NonNull
    private final AmqpTemplate amqpTemplate;

    @NonNull
    private final ObjectMapper objectMapper;

    @Override
    public void sendMessage(RequestMessageDto messageDto, String queue) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(messageDto);
        amqpTemplate.convertAndSend(queue,  message);
        System.out.println("Отправлено сообщение " + message + " в очередь " + RabbitMQConfiguration.COMMON_MONITORING_QUEUE_NAME);
    }
}
