package br.com.jj.coop.cooptest.controller;

import br.com.jj.coop.cooptest.util.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
public class CepControllerTest {

    @Autowired
    private MockMvc restClienteMockMvc;

    private static final String URL_CEPS = "/api/v1/ceps";
    private static final String URL_CEPS_ID = URL_CEPS + "/{nuCep}";

    private static final String NU_CEP_VALIDO = "73340200";
    private static final String NU_CEP_INVALIDO = "123";
    private static final String NU_CEP_INVALIDO_ERRO = "123123123123";


    @Test
    @Transactional
    void recuperarCepValido() throws Exception {

        restClienteMockMvc
                .perform(get(URL_CEPS_ID, NU_CEP_VALIDO ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.nuCep").value(NU_CEP_VALIDO));
    }

    @Test
    @Transactional
    void recuperarCepInvalido() throws Exception {

        restClienteMockMvc
                .perform(get(URL_CEPS_ID, NU_CEP_INVALIDO ))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    @Transactional
    void recuperarCepInvalidoErro() throws Exception {

        restClienteMockMvc
                .perform(get(URL_CEPS_ID, NU_CEP_INVALIDO_ERRO ))
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
