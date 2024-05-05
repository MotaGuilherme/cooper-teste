package br.com.jj.coop.cooptest.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente extends BaseEntity<Long>{

    @Id
    @Column(name = "co_seq_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_cliente")
    private String noCliente;

    @Column(name = "nu_cpf")
    private String nuCpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Email> emails;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Telefone> telefones;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "co_seq_cliente", referencedColumnName = "co_cliente")
    private Endereco endereco;

    @Column(name = "dt_criado", updatable = false)
    @CreatedDate
    private LocalDateTime dtCriado;

    @Column(name = "dt_modificado")
    @LastModifiedDate
    private LocalDateTime dtModificado;

    @CreatedBy
    @Column(name = "no_responsavel_cadastro", updatable = false)
    private String noResponsavelCadastro;

    @LastModifiedBy
    @Column(name = "no_responsavel_alteracao")
    private String noResponsavelAlteracao;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return id != null && id.equals(((Cliente) o).id);
    }
}
