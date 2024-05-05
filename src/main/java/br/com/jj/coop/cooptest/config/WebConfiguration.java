package br.com.jj.coop.cooptest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        List<String> conf = new ArrayList<>();
        conf.add("*");

        config.setAllowedOrigins(conf);
        config.setAllowedMethods(conf);
        config.setAllowedHeaders(conf);

        List<String> exposedHeaders = Arrays.asList("X-Total-Count","Authorization", "Link");
        config.setExposedHeaders(exposedHeaders);

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

}

