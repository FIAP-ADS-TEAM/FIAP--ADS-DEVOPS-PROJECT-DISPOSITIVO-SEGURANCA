package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Notificacao;

import java.time.LocalDate;

public record NotificacaoExibicaoDTO(
        Long id,
        Long id_dispositivo,
        Long id_usuario,
        LocalDate data,
        String tipo,
        String decricao,
        String status
){
    public NotificacaoExibicaoDTO(Notificacao notificacao){
        this(notificacao.getId(),notificacao.getId_dispositivo(),notificacao.getId_usuario(),notificacao.getData(),notificacao.getTipo(),
                notificacao.getDescricao(),notificacao.getStatus());
    }
}
