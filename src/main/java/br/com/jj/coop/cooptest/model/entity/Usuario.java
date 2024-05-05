package br.com.jj.coop.cooptest.model.entity;

import br.com.jj.coop.cooptest.model.enuns.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "tb_usuario")
@Entity
public class Usuario extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_seq_usuario", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nm_usuario", nullable = false, length = 100)
    private String nmUsuario;

    @Column(name = "ds_login", nullable = false, length = 45)
    private String dsLogin;

    @Column(name = "ds_senha", nullable = false, length = 255)
    private String password;

    @Column(name = "ds_email", nullable = false, length = 45)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "co_perfil", nullable = false)
    private Perfil perfil;

    @Column(name="st_ativo", nullable = false)
    private Boolean  stAtivo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return id != null && id.equals(((Usuario) o).id);
    }

}