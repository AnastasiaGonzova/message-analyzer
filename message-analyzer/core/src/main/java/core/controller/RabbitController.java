package core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.configuration.RabbitMQConfiguration;
import core.domain.RequestMessageDto;
import core.service.RabbitSenderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitMQ")
@RequiredArgsConstructor
public class RabbitController {

    @NonNull
    private final RabbitSenderService rabbitSenderService;


    @PostMapping("/send")
    public void sendMessage(@RequestBody RequestMessageDto messageDto) throws JsonProcessingException {
        rabbitSenderService.sendMessage(messageDto, RabbitMQConfiguration.COMMON_MONITORING_QUEUE_NAME);
    }

}
