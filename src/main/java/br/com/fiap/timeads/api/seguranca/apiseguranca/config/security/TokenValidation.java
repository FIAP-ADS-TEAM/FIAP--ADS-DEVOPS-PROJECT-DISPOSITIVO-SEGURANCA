package br.com.fiap.timeads.api.seguranca.apiseguranca.config.security;

import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenValidation extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authoHeader = request.getHeader("Authorization");
        String token = "";

        if (authoHeader == null) {
            token = null;
        } else {
            token = authoHeader.replace("Bearer", "").trim();
            String login = tokenService.validarToken(token);
            UserDetails usuario = usuarioRepository.findByEmail(login);

            try{
                UsernamePasswordAuthenticationToken userAuth =
                        new UsernamePasswordAuthenticationToken(
                                usuario, null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(userAuth);

            }catch (Exception err){
                throw new RuntimeException("Erro ao validar usuario!");
            }
        }

        filterChain.doFilter(request,response);
    }

}
