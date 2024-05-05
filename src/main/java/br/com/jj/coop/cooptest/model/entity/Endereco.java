package br.com.jj.coop.cooptest.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class Endereco extends BaseEntity<Long>{

    @Id
    @Column(name = "co_seq_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nu_cep")
    private Integer nuCep;

    @Column(name = "ds_logradouro")
    private String dsLogradouro;

    @Column(name = "no_bairro")
    private String noBairro;

    @Column(name = "no_cidade")
    private String noCidade;

    @Column(name = "co_uf")
    private String coUf;

    @Column(name = "ds_complemento")
    private String dsComplemento;

    @ManyToOne
    @JoinColumn(name = "co_cliente", referencedColumnName = "co_seq_cliente", nullable = false)
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Endereco)) {
            return false;
        }
        return id != null && id.equals(((Endereco) o).id);
    }
}
