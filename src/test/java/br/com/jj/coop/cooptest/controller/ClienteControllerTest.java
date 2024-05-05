package br.com.jj.coop.cooptest.controller;

import br.com.jj.coop.cooptest.util.IntegrationTest;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroClienteDTO;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroEmailDTO;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroEnderecoDTO;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroTelefoneDTO;
import br.com.jj.coop.cooptest.model.dto.saida.ClienteDTO;
import br.com.jj.coop.cooptest.model.entity.Cliente;
import br.com.jj.coop.cooptest.model.enuns.Perfil;
import br.com.jj.coop.cooptest.model.enuns.TipoTelefone;
import br.com.jj.coop.cooptest.model.mapper.ClienteMapper;
import br.com.jj.coop.cooptest.repository.ClienteRepository;
import br.com.jj.coop.cooptest.util.CoopTestUtil;
import io.cucumber.java.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser(username="admin",roles={"COMUM","ADMINISTRADOR"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteControllerTest {

    private static final Long DEFAULT_CO_SEQ_CLIENTE = 1L;
    private static final Long UPDATED_CO_SEQ_CLIENTE = 2L;

    private static final String DEFAULT_NO_CLIENTE = "TESTE COOPERFORTE INSERT";
    private static final String UPDATED_NO_CLIENTE = "TESTE COOPERFORTE UPDATE";

    private static final String DEFAULT_NU_CPF = "07900442006";
    private static final String UPDATED_NU_CPF = "05756525009";

    private static final String URL_CLIENTES = "/api/v1/clientes";
    private static final String URL_CLIENTES_ID = URL_CLIENTES + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restClienteMockMvc;

    private CadastroClienteDTO cadastroClienteDTO;

    @Before
    public void setup() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(Perfil.ADMINISTRADOR.name()));
        User principal = new User("admin", "123456", true, true, true, true, grantedAuthorities);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                principal.getPassword(),
                principal.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
    }

    public static CadastroClienteDTO criaClienteParaCadastrar(EntityManager em) {
        CadastroClienteDTO cliente = new CadastroClienteDTO();
        cliente.setId(DEFAULT_CO_SEQ_CLIENTE);
        cliente.setNoCliente(DEFAULT_NO_CLIENTE);
        cliente.setNuCpf(DEFAULT_NU_CPF);
        cliente.setTelefones(criaListaTelefones());
        cliente.setEmails(criaListaEmail());
        cliente.setEndereco(criaEndereco());
        return cliente;
    }

    public static Cliente criaClienteParaAtualizar(EntityManager em) {
        Cliente cliente = new Cliente();
        cliente.setId(UPDATED_CO_SEQ_CLIENTE);
        cliente.setNoCliente(UPDATED_NO_CLIENTE);
        cliente.setNuCpf(UPDATED_NU_CPF);
        return cliente;
    }

    public static Set<CadastroEmailDTO> criaListaEmail(){
        var email = new CadastroEmailDTO();
        email.setDsEmail("test@gmail.com");

        var lista = new HashSet<CadastroEmailDTO>();
        lista.add(email);
        return lista;
    }

    public static CadastroEnderecoDTO criaEndereco() {
        var endereco = new CadastroEnderecoDTO();
        endereco.setCoUf("AL");
        endereco.setDsLogradouro("Quadra 2 Conjunto 2Z");
        endereco.setNoBairro("Teste");
        endereco.setNoCidade("Teste");
        endereco.setNuCep(73340200);
        return endereco;
    }

    public static Set<CadastroTelefoneDTO> criaListaTelefones(){
        var telefone = new CadastroTelefoneDTO();
        telefone.setNuTelefone("95933645303");
        telefone.setCoTipoTelefone(TipoTelefone.CELULAR);

        var lista = new HashSet<CadastroTelefoneDTO>();
        lista.add(telefone);
        return lista;
    }

    @BeforeEach
    public void initTest() {
        cadastroClienteDTO = criaClienteParaCadastrar(em);
    }

    @Test
    @Order(1)
    @Transactional
    void cadastrarCliente() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();

        restClienteMockMvc
            .perform(post(URL_CLIENTES).contentType(MediaType.APPLICATION_JSON).content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO)))
            .andExpect(status().isCreated());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco + 1);
        Cliente testCliente = clienteList.get(clienteList.size() - 1);
        assertThat(testCliente.getId()).isEqualTo(DEFAULT_CO_SEQ_CLIENTE);
        assertThat(testCliente.getNoCliente()).isEqualTo(DEFAULT_NO_CLIENTE);
        assertThat(testCliente.getNuCpf()).isEqualTo(DEFAULT_NU_CPF);
    }


    @Test
    @Order(2)
    @Transactional
    void verificaPreenchimentoCampoNoCliente() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();

        cadastroClienteDTO.setNoCliente(null);

        restClienteMockMvc
            .perform(post(URL_CLIENTES).contentType(MediaType.APPLICATION_JSON).content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
    }

    @Test
    @Order(3)
    @Transactional
    void verificaPreenchimentoCampoNuCpf() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();
        cadastroClienteDTO.setNuCpf(null);

        restClienteMockMvc
                .perform(post(URL_CLIENTES).contentType(MediaType.APPLICATION_JSON).content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO)))
                .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
    }

    @Test
    @Order(4)
    @Transactional
    void verificaPreenchimentoCampoNuCpfValido() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();
        cadastroClienteDTO.setNuCpf("XXX");

        MvcResult result = restClienteMockMvc
                .perform(post(URL_CLIENTES).contentType(MediaType.APPLICATION_JSON).content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO)))
                .andExpect(status().isBadRequest()).andReturn();

        assertThat(result.getResponse().getContentAsString().contains("Número do registro de contribuinte individual brasileiro (CPF) inválido"));

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
    }

    @Test
    @Order(5)
    @Transactional
    void verificaPreenchimentoCampoDsEmailValido() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();
        Set<CadastroEmailDTO> emails = criaListaEmail();
        emails.forEach(e -> {
            e.setDsEmail("email_invalido.com.br");
        });
        cadastroClienteDTO.setEmails(emails);

        MvcResult result = restClienteMockMvc
                .perform(post(URL_CLIENTES).contentType(MediaType.APPLICATION_JSON).content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO)))
                .andExpect(status().isBadRequest()).andReturn();

        assertThat(result.getResponse().getContentAsString().contains("O endereço de e-mail fornecido é inválido"));

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
    }


    @Test
    @Order(6)
    @Transactional
    void recuperarTodosClientes() throws Exception {
        
        restClienteMockMvc
            .perform(get(URL_CLIENTES + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(DEFAULT_CO_SEQ_CLIENTE.intValue())))
            .andExpect(jsonPath("$.[*].noCliente").value(hasItem(DEFAULT_NO_CLIENTE)))
            .andExpect(jsonPath("$.[*].nuCpf").value(hasItem(DEFAULT_NU_CPF)));
    }

    @Test
    @Order(7)
    @Transactional
    void recuperarCliente() throws Exception {

        restClienteMockMvc
            .perform(get(URL_CLIENTES_ID, DEFAULT_CO_SEQ_CLIENTE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(DEFAULT_CO_SEQ_CLIENTE))
            .andExpect(jsonPath("$.noCliente").value(DEFAULT_NO_CLIENTE))
            .andExpect(jsonPath("$.nuCpf").value(DEFAULT_NU_CPF));
    }

    @Test
    @Order(8)
    @Transactional
    void recuperarClienteNaoCadastrado() throws Exception {
        restClienteMockMvc.perform(get(URL_CLIENTES_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Order(9)
    @Transactional
    void atualizarCliente() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();

        Cliente cliente = clienteRepository.findById(DEFAULT_CO_SEQ_CLIENTE).get();
        em.detach(cliente);
        cliente.setNoCliente(UPDATED_NO_CLIENTE);
        cliente.setNuCpf(UPDATED_NU_CPF);

        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc
            .perform(
                put(URL_CLIENTES_ID, clienteDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(CoopTestUtil.convertObjectToJsonBytes(clienteDTO))
            )
            .andExpect(status().isOk());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
        Cliente testCliente = clienteList.get(clienteList.size() - 1);
        assertThat(testCliente.getNoCliente()).isEqualTo(UPDATED_NO_CLIENTE);
        assertThat(testCliente.getNuCpf()).isEqualTo(UPDATED_NU_CPF);
    }

    @Test
    @Order(10)
    @Transactional
    void atualizarClienteNaoCadastrado() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();
        cadastroClienteDTO.setId(count.incrementAndGet());

        restClienteMockMvc
            .perform(
                put(URL_CLIENTES_ID, cadastroClienteDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO))
            )
            .andExpect(status().isNotFound());
        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
    }

    @Test
    @Order(11)
    @Transactional
    void corrigirCadastroCliente() throws Exception {
        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();

        CadastroClienteDTO cadastroClienteDTO = new CadastroClienteDTO();
        cadastroClienteDTO.setId(DEFAULT_CO_SEQ_CLIENTE);
        cadastroClienteDTO.setNuCpf("38596302026");

        restClienteMockMvc
            .perform(
                patch(URL_CLIENTES_ID, cadastroClienteDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(CoopTestUtil.convertObjectToJsonBytes(cadastroClienteDTO))
            )
            .andExpect(status().isOk());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco);
        Cliente testCliente = clienteList.get(clienteList.size() - 1);
        assertThat(testCliente.getId()).isEqualTo(DEFAULT_CO_SEQ_CLIENTE);
        assertThat(testCliente.getNoCliente()).isEqualTo(UPDATED_NO_CLIENTE);
        assertThat(testCliente.getNuCpf()).isEqualTo(UPDATED_NU_CPF);
    }

    @Test
    @Order(12)
    @Transactional
    void excluirCliente() throws Exception {

        int totalDeClientesSalvosNoBanco = clienteRepository.findAll().size();

        restClienteMockMvc
            .perform(delete(URL_CLIENTES_ID, DEFAULT_CO_SEQ_CLIENTE).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(totalDeClientesSalvosNoBanco - 1);
    }
}
