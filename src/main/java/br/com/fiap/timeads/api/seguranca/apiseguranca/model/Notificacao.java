package br.com.fiap.timeads.api.seguranca.apiseguranca.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_NOTIFICACOES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Notificacao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_NOTIFICACAO_GEN"
    )
    @SequenceGenerator(
            name = "SEQ_NOTIFICACAO_GEN",
            sequenceName = "SEQ_NOTIFICACAO",
            allocationSize = 1
    )
    private Long id;
    private Long id_dispositivo;
    private Long id_usuario;
    private LocalDate data;
    private String tipo;
    private String descricao;
    private String status;
}