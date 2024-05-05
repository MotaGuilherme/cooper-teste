package br.com.jj.coop.cooptest.cucumber.stepdefs;

import br.com.jj.coop.cooptest.controller.ClienteController;
import br.com.jj.coop.cooptest.model.enuns.Perfil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ClienteStepDefs extends StepDefs {

    @Autowired
    private ClienteController clienteController;

    private MockMvc clienteMockMvc;

    @Before
    public void setup() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(Perfil.ADMINISTRADOR.name()));
        User principal = new User("username", "", true, true, true, true, grantedAuthorities);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            principal,
            principal.getPassword(),
            principal.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        this.clienteMockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }



    @When("Realizar uma busca pelo cliente com ID {string}")
    public void buscandoCliente(String cliente) throws Throwable {
        actions = clienteMockMvc.perform(get("/api/v1/clientes/" + cliente).accept(MediaType.APPLICATION_JSON));
    }

    @Then("O cliente é encontrado")
    public void clienteEncontrato() throws Throwable {
        actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Then("E o seu nome é {string}")
    public void seuNome(String noCliente) throws Throwable {
        actions.andExpect(jsonPath("$.noCliente").value(noCliente));
    }
}
