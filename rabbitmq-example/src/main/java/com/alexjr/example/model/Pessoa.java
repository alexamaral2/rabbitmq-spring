package com.alexjr.example.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @NotBlank
    private String nome;

    @NotNull
    @Min(value = 0)
    private Integer idade;
}