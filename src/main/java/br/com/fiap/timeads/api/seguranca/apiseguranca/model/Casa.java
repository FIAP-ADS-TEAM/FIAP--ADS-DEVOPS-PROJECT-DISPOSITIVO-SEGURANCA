package br.com.fiap.timeads.api.seguranca.apiseguranca.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_CASAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Casa {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CASA_GEN"
    )
    @SequenceGenerator(
            name = "SEQ_CASA_GEN",
            sequenceName = "SEQ_CASA",
            allocationSize = 1
    )
    private Long Id;
    private String Endereco;
    private String Cep;

}
