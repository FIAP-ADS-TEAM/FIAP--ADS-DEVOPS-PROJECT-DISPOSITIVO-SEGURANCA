package br.com.fiap.timeads.api.seguranca.apiseguranca.repository;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
