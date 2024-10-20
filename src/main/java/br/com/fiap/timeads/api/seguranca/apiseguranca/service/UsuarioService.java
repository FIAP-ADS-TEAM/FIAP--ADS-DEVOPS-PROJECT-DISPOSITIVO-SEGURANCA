package br.com.fiap.timeads.api.seguranca.apiseguranca.service;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.UsuarioCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.UsuarioExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.exception.CasaException;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Usuario;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

    public UsuarioExibicaoDTO cadastrar(UsuarioCadastroDTO usuarioCadDTO){
        String senhaCript = new BCryptPasswordEncoder().encode(usuarioCadDTO.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadDTO,usuario);
        usuario.setSenha(senhaCript);

        return new UsuarioExibicaoDTO(usuarioRepository.save(usuario));
    }


    public UsuarioExibicaoDTO buscarPorId(Long id){
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent()){
            return new UsuarioExibicaoDTO(optUsuario.get());
        }else{
            throw new CasaException("Usuario não encontrado!");
        }
    }

}
