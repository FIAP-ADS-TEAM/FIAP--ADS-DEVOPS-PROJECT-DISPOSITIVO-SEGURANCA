package br.com.fiap.timeads.api.seguranca.apiseguranca.service;

import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.DispositivoCadastroDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.dto.DispositivoExibicaoDTO;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Casa;
import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Dispositivo;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.CasaRepository;
import br.com.fiap.timeads.api.seguranca.apiseguranca.repository.DispositivoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private CasaRepository casaRepository;

    public List<DispositivoExibicaoDTO> listarTodos(){
        return dispositivoRepository
                .findAll()
                .stream()
                .map(DispositivoExibicaoDTO::new)
                .toList();
    }

    public DispositivoExibicaoDTO cadastrar(DispositivoCadastroDTO dispCadDTO){
        Optional<Casa> optCasa = casaRepository.findById(dispCadDTO.id_casa());
        if(optCasa.isPresent()){
            Dispositivo dispositivo = new Dispositivo();
            BeanUtils.copyProperties(dispCadDTO,dispositivo);
            return new DispositivoExibicaoDTO(dispositivoRepository.save(dispositivo));
        }else{
            throw new RuntimeException("Casa não existe para cadastro!");
        }
    }

    public void deletarPorId(Long id){
        Optional<Dispositivo> optDisp = dispositivoRepository.findById(id);
        if(optDisp.isPresent()){
            dispositivoRepository.deleteById(id);
        }else{
            throw new RuntimeException("Dispositivo não encontrado!");
        }
    }


}
