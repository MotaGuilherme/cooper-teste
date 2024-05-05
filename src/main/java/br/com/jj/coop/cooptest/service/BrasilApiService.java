package br.com.jj.coop.cooptest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "brasilapi",
        url = "https://brasilapi.com.br/api"
)
public interface BrasilApiService {

    @RequestMapping(value="/cep/v1/{nuCep}", method = RequestMethod.GET, consumes = "application/json")
    Object consultaCep(@PathVariable(value = "nuCep") String nuCep);
}