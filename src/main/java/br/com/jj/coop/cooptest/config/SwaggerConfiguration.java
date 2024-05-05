package br.com.jj.coop.cooptest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Info info() {
        return new Info()
                .version("1.0.0")
                .title("COOP - Processo Seletivo")
                .description("Backend - Teste Cooper")
                .contact(new Contact().name("guilherme").email("guilhermemotaff@gmail.com"))
                .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                .termsOfService("www.google.com");
    }

    @Bean
    @ConditionalOnMissingBean
    public Scopes scopes() {
        return new Scopes();
    }

    @Bean
    @ConditionalOnMissingBean
    public Components components() {
        return new Components();
    }

    @Bean
    @ConditionalOnMissingBean
    public OpenAPI customOpenAPI(@Autowired Info info, @Autowired Components components) {
        return new OpenAPI()
                .components(components)
                .addSecurityItem(new SecurityRequirement().addList("JWT Token"))
                .components(new Components().addSecuritySchemes("JWT Token",
                        new SecurityScheme().name("JWT Token").type(SecurityScheme.Type.HTTP).scheme("bearer")))
                .info(info);
    }

}