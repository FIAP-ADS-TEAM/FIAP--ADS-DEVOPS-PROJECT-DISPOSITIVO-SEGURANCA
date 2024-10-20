package br.com.fiap.timeads.api.seguranca.apiseguranca.controller;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.CasaCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.CasaExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Casa;
import br.com.fiap.timeads.api.seguranca.apiseguranca.service.CasaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaService casaService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CasaExibicaoDTO> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(casaService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todas")
    @ResponseStatus(HttpStatus.OK)
    public List<CasaExibicaoDTO> listarTodas(){
        return casaService.listarTodas();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CasaExibicaoDTO cadastrar(@RequestBody @Valid CasaCadastroDTO casaCadDTO){
        return casaService.cadastrar(casaCadDTO);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Casa> atualizar(@RequestBody Casa casa){
        try{
            return ResponseEntity.ok(casaService.atualizar(casa));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        casaService.deletarPorId(id);
    }

}
