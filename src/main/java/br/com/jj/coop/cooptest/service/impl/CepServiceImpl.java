package br.com.jj.coop.cooptest.service.impl;

import br.com.jj.coop.cooptest.model.dto.saida.EnderecoDTO;
import br.com.jj.coop.cooptest.service.BrasilApiService;
import br.com.jj.coop.cooptest.service.CepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static br.com.jj.coop.cooptest.message.BusinessMessageProperty.CEP_ERRO_CONSULTA;
import static  br.com.jj.coop.cooptest.message.BusinessMessageProperty.CEP_NAO_LOCALIZADO;

@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

    private final BrasilApiService brasilApiService;

    private final ObjectMapper objectMapper;

    @Override
    @Cacheable("ceps")
    public EnderecoDTO consulta(String nuCep) {
        try {

            Object response = this.brasilApiService.consultaCep(nuCep);
            return objectMapper.convertValue(response, EnderecoDTO.class);

        } catch (FeignException e) {
            if(e.status() == HttpStatus.NOT_FOUND.value()) {
               throw CEP_NAO_LOCALIZADO.resourceNotFoundException();
            }
            throw CEP_ERRO_CONSULTA.infraException();
        }
    }
}
