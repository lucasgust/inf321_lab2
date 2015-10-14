package br.unicamp.exemplo;

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.to.EnderecoTO;

public class CompreFacil {
	
	public CorreiosDAO correiosDAO;
	
	public CompreFacil(CorreiosDAO correiosDAO) {
		this.correiosDAO = correiosDAO;
	}
	
	public EnderecoTO buscarEndereco(String cep) {
		return correiosDAO.buscarEndereco(cep);
	}

}
