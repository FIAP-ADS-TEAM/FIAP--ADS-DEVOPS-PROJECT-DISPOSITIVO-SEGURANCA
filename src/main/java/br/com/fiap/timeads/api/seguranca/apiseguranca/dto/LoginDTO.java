package br.com.fiap.timeads.api.seguranca.apiseguranca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank(message = "Email é obrigatório!")
        @Email(message = "Email incorreto!")
        String email,

        @NotBlank(message = "Senha é obrigatório!")
        String senha
) {}
