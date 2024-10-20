package br.com.fiap.timeads.api.seguranca.apiseguranca.controller;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.DispositivoCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.DispositivoExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.service.DispositivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disp")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<DispositivoExibicaoDTO> listarTodos(){
        return dispositivoService.listarTodos();
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public DispositivoExibicaoDTO cadastrar(@RequestBody @Valid DispositivoCadastroDTO dispDto){
        return dispositivoService.cadastrar(dispDto);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        dispositivoService.deletarPorId(id);
    }
}