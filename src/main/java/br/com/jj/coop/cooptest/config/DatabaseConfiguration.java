package br.com.jj.coop.cooptest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "br.com.jj.coop.cooptest.repository" })
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareConfiguration();
    }
}
