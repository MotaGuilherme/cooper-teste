package br.com.jj.coop.cooptest.config;


import br.com.jj.coop.cooptest.util.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareConfiguration implements AuditorAware<String> {

    @Override
    public  Optional<String> getCurrentAuditor() {
       return SecurityUtils.getCurrentUserLogin();
    }

}
