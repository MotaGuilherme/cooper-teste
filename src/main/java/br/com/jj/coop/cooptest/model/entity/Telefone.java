package br.com.jj.coop.cooptest.model.entity;

import br.com.jj.coop.cooptest.model.enuns.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_telefone")
public class Telefone extends BaseEntity<Long>{
    @Id
    @Column(name = "co_seq_telefone")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nu_telefone")
    private String nuTelefone;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "co_tipo_telefone")
    private TipoTelefone coTipoTelefone;

    @ManyToOne
    @JoinColumn(name = "co_cliente", referencedColumnName = "co_seq_cliente", nullable = false)
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Telefone)) {
            return false;
        }
        return id != null && id.equals(((Telefone) o).id);
    }

}
