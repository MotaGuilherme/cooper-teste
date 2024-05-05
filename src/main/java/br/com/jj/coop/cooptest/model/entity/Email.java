package br.com.jj.coop.cooptest.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_email")
@Getter
@Setter
public class Email extends BaseEntity<Long>{

    @Id
    @Column(name = "co_seq_email")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_email")
    private String dsEmail;

    @ManyToOne
    @JoinColumn(name = "co_cliente", referencedColumnName = "co_seq_cliente", nullable = false)
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Email)) {
            return false;
        }
        return id != null && id.equals(((Email) o).id);
    }
}
