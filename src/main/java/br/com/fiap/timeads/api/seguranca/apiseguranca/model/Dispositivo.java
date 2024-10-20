package br.com.fiap.timeads.api.seguranca.apiseguranca.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_DISPOSITIVOS_SEGURANCA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Dispositivo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_DISPOSITIVO_GEN"
    )
    @SequenceGenerator(
            name = "SEQ_DISPOSITIVO_GEN",
            sequenceName = "SEQ_DISPOSITIVO",
            allocationSize = 1
    )
    private Long id;

    private String tipo;
    private String status;

    @Column(name="local_instalacao")
    private String local;

    private Long id_casa;

}
