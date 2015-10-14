package br.unicamp.comprefacil.dao;

import br.unicamp.comprefacil.to.EnderecoTO;

public interface CorreiosDAO {
	
	public EnderecoTO buscarEndereco(String cep);

}
