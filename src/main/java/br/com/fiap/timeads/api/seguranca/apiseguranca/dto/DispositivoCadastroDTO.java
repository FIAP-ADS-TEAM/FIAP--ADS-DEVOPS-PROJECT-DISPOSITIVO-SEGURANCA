package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DispositivoCadastroDTO(
        Long id,

        @NotBlank(message = "Tipo do dispositivo é obrigatório!")
        @Size(min = 5, max = 20, message = "Tamanho inválido para o tipo")
        String tipo,

        @NotBlank(message = "Status do dispositivo é obrigatório!")
        @Size(min = 5, max = 20, message = "Tamanho inválido para o status")
        String status,

        @NotBlank(message = "Local do dispositivo é obrigatório!")
        @Size(min = 5, max = 100, message = "Tamanho inválido para o local")
        String local,

        @NotNull(message = "Id da casa é obrigatório!")
        Long id_casa
){}
