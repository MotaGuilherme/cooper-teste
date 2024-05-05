package br.com.jj.coop.cooptest.service;

import br.com.jj.coop.cooptest.model.dto.saida.EnderecoDTO;

public interface CepService {

    EnderecoDTO consulta(String nuCep);
}
