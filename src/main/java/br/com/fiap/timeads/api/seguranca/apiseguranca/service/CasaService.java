package br.com.fiap.timeads.api.seguranca.apiseguranca.service;


import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.CasaCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.CasaExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.exception.CasaException;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Casa;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.CasaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {

    @Autowired
    private CasaRepository casaRepository;

    public List<CasaExibicaoDTO> listarTodas(){
        return casaRepository
                .findAll()
                .stream()
                .map(CasaExibicaoDTO::new)
                .toList();
    }

    public CasaExibicaoDTO cadastrar(CasaCadastroDTO casaCadDTO){
        Casa casa = new Casa();
        BeanUtils.copyProperties(casaCadDTO,casa);
        return new CasaExibicaoDTO(casaRepository.save(casa));
    }

    public CasaExibicaoDTO buscarPorId(Long id){
        Optional<Casa> optCasa = casaRepository.findById(id);
        if(optCasa.isPresent()){
            return new CasaExibicaoDTO(optCasa.get());
        }else{
            throw new CasaException("Casa não encontrada!");
        }
    }

    public Casa atualizar(Casa casa){
        Optional<Casa> optCasa = casaRepository.findById(casa.getId());
        if(optCasa.isPresent()){
            return casaRepository.save(casa);
        }else{
            throw new RuntimeException("Casa não encontrada!");
        }
    }

    public void deletarPorId(Long id){
        Optional<Casa> optCasa = casaRepository.findById(id);
        if(optCasa.isPresent()){
            casaRepository.deleteById(id);
        }else{
            throw new RuntimeException("Casa não encontrada!");
        }
    }


}
