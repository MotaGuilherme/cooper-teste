package br.com.jj.coop.cooptest.controller;


import br.com.jj.coop.cooptest.model.dto.saida.EnderecoDTO;
import br.com.jj.coop.cooptest.service.CepService;
import com.sun.mail.iap.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ceps")
@RequiredArgsConstructor
@Tag(name = "CEP", description = "Consulta Código de Endereço Postal(CEP)")
public class CepController {

    private final CepService cepService;

    @GetMapping(value = "/{nuCep}")
    public ResponseEntity<EnderecoDTO> consulta(@PathVariable String nuCep){
        return ResponseEntity.ok(cepService.consulta(nuCep));
    }
}
