package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Notificacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NotificacaoCadastroDTO(
        Long id,

        @NotNull(message = "Id do dispositivo é obrigatório!")
        Long id_dispositivo,

        @NotNull(message = "Id do usuario é obrigatório!")
        Long id_usuario,

        @NotNull(message = "Data é obrigatório!")
        LocalDate data,

        String tipo,

        String decricao,

        String status
){
}
