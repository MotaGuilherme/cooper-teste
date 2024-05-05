package br.com.jj.coop.cooptest.repository;

import br.com.jj.coop.cooptest.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNuCpf(String nuCpf);
}
