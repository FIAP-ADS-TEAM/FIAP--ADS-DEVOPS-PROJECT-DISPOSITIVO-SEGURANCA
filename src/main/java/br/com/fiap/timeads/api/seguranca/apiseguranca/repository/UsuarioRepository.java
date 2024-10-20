package br.com.fiap.timeads.api.seguranca.apiseguranca.repository;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByEmail(String email);
}
