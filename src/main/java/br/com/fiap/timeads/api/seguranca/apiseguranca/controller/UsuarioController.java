package br.com.fiap.timeads.api.seguranca.apiseguranca.controller;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.UsuarioCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.UsuarioExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(usuarioService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioService.listarTodos();
    }


}
