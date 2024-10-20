package br.com.fiap.timeads.api.seguranca.apiseguranca.config.security;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.jwt.key}")
    private String SECURITY_JWT_KEY;

    public String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECURITY_JWT_KEY);
            return JWT.create()
                    .withIssuer("apiseguranca")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataTokenExpiracao())
                    .sign(algorithm);

        }catch(JWTCreationException err){
            throw new RuntimeException("Não foi possivel gerar o token!");
        }
    }

    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECURITY_JWT_KEY);
            return JWT.require(algorithm)
                    .withIssuer("apiseguranca")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException err){
            return "";
        }
    }

    public Instant dataTokenExpiracao(){
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
