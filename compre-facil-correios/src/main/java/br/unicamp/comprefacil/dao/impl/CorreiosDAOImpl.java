package br.unicamp.comprefacil.dao.impl;

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.to.EnderecoTO;

public class CorreiosDAOImpl implements CorreiosDAO {

	public void salvaEndereco(EnderecoTO endereco) {
		System.out.println("Salvando endereço: " + endereco);
	}
}