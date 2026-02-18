package com.alexjr.example.controller;

import com.alexjr.example.model.Pessoa;
import com.alexjr.example.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<String> criar(@Valid @RequestBody Pessoa pessoa) {
        pessoaService.cadastrarComDelay(pessoa, 10000);

        String mensagem = "Cadastro de " + pessoa.getNome() + " recebido! Processamento em 10s.";

        return ResponseEntity.accepted().body(mensagem);
    }
}