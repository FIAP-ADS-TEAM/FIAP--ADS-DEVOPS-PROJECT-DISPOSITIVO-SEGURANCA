package br.com.fiap.timeads.api.seguranca.apiseguranca.controller;


import br.com.fiap.timeads.api.seguranca.apiseguranca.config.security.TokenService;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.LoginDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.TokenDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.UsuarioExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Usuario;
import br.com.fiap.timeads.api.seguranca.apiseguranca.service.UsuarioService;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.UsuarioCadastroDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO){

        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(loginDTO.email(),loginDTO.senha());

        Authentication auth = authenticationManager.authenticate(userNamePassword);

        String token = tokenService.gerarToken((Usuario)auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registrar")
    public UsuarioExibicaoDTO registrarUsuario(
            @RequestBody @Valid UsuarioCadastroDTO usuCadDTO){
        return usuarioService.cadastrar(usuCadDTO);
    }
}
