package com.alexjr.example.consumer;

import com.alexjr.example.model.Pessoa;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PessoaConsumer {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receber(Pessoa pessoa) {

        System.out.println("=== Nova Mensagem Recebida ===");
        System.out.println("Nome:  " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("------------------------------");
    }
}