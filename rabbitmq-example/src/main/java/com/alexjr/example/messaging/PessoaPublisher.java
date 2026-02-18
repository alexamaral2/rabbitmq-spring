package com.alexjr.example.messaging;

import com.alexjr.example.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    public void enviar(Pessoa pessoa) {
        rabbitTemplate.convertAndSend(exchange, routingKey, pessoa);
    }

    public void enviarComDelay(Pessoa pessoa, int delayMs) {
        rabbitTemplate.convertAndSend(exchange, routingKey, pessoa, msg -> {
            msg.getMessageProperties().setHeader("x-delay", delayMs);
            return msg;
        });
    }
}