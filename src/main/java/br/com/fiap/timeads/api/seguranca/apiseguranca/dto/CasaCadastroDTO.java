package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CasaCadastroDTO (
        Long casaId,

        @NotBlank(message = "Endereço é obrigatório!")
        @Size(min = 10, max = 100, message = "Endereço inválido! Valor não corresponde ao tamanho necessário!")
        String endereco,

        @NotBlank(message = "CEP é obrigatório!")
        @Size(min = 8, max = 9, message = "CEP inválido! Valor não corresponde ao tamanho necessário!")
        String cep
){}
