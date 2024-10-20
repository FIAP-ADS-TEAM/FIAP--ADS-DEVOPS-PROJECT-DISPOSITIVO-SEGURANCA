package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Casa;

public record CasaExibicaoDTO(
        Long Id,
        String Endereco
) {

    public CasaExibicaoDTO(Casa casa){
        this(casa.getId(),casa.getEndereco());
    }
}
