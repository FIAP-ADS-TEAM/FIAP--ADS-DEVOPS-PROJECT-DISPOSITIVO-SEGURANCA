package br.com.fiap.timeads.api.seguranca.apiseguranca.service;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.NotificacaoCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.NotificacaoExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Dispositivo;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Notificacao;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Usuario;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.DispositivoRepository;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.NotificacaoRepository;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public NotificacaoExibicaoDTO cadastrar(NotificacaoCadastroDTO notDTO){
        Optional<Dispositivo> optDisp = dispositivoRepository.findById(notDTO.id_dispositivo());
        Optional<Usuario> optUsuario = usuarioRepository.findById(notDTO.id_usuario());

        if(optDisp.isPresent() && optUsuario.isPresent()){
            Notificacao not = new Notificacao();
            BeanUtils.copyProperties(notDTO,not);
            return new NotificacaoExibicaoDTO(notificacaoRepository.save(not));
        }else{
            throw new RuntimeException("Usuário e/ou dispositivo não existem para cadastro!");
        }
    }

    public List<NotificacaoExibicaoDTO> listarTodas(){
        return notificacaoRepository
                .findAll()
                .stream()
                .map(NotificacaoExibicaoDTO::new)
                .toList();
    }
}
