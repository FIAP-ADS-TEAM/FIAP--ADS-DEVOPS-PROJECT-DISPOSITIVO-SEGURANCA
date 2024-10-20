package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Dispositivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DispositivoExibicaoDTO(
        Long id,
        String tipo,
        String status,
        String local,
        Long id_casa
){
    public DispositivoExibicaoDTO(Dispositivo dispositivpo){
        this(dispositivpo.getId(), dispositivpo.getTipo(), dispositivpo.getStatus(), dispositivpo.getLocal(), dispositivpo.getId_casa());
    }
}
