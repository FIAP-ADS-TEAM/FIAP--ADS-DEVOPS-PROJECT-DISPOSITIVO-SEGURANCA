package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email
) {
    public UsuarioExibicaoDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(),usuario.getEmail());
    }
}
