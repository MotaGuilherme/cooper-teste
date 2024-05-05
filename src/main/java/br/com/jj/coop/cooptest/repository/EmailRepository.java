package br.com.jj.coop.cooptest.repository;

import br.com.jj.coop.cooptest.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    boolean existsByDsEmail(String email);
}
