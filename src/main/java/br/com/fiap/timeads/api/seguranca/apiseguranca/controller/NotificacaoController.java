package br.com.fiap.timeads.api.seguranca.apiseguranca.controller;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.NotificacaoCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.NotificacaoExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.service.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notif")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacaoExibicaoDTO cadastrar(@RequestBody @Valid NotificacaoCadastroDTO notDTO){
        return notificacaoService.cadastrar(notDTO);
    }

    @GetMapping("/todas")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificacaoExibicaoDTO> listarTodas(){
        return notificacaoService.listarTodas();
    }

}
