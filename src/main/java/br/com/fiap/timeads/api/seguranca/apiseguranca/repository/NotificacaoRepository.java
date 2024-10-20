package br.com.fiap.timeads.api.seguranca.apiseguranca.repository;

import br.com.fiap.timeads.api.seguranca.apiseguranca.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao,Long> {
}
