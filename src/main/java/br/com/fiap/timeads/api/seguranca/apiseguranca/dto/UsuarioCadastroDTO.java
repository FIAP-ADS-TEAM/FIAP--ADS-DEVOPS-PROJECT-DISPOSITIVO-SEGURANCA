package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDTO (
        Long usuarioId,

        @NotBlank(message = "Nome é obrigatório!")
        @Size(min = 5, max = 30, message = "Nome inválido! Valor não corresponde ao tamanho necessário!")
        String nome,

        @NotBlank(message = "CEP é obrigatório!")
        @Email(message = "Email inválido!")
        String email,

        @NotBlank(message = "Senha é obrigatória!")
        @Size(min = 5, max = 100, message = "Senha inválida! Valor não corresponde ao tamanho necessário!")
        String senha
){}
