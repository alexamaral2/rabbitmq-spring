package com.alexjr.example.service;

import com.alexjr.example.messaging.PessoaPublisher;
import com.alexjr.example.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaPublisher publisher;

    public void cadastrar(Pessoa pessoa) {
        publisher.enviar(pessoa);
    }

    public void cadastrarComDelay(Pessoa pessoa, int delayMs) {
        publisher.enviarComDelay(pessoa, delayMs);
    }
}