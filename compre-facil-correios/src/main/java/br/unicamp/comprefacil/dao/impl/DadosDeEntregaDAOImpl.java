package br.unicamp.comprefacil.dao.impl;

import br.unicamp.comprefacil.dao.DadosDeEntregaDAO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;

public class DadosDeEntregaDAOImpl implements DadosDeEntregaDAO {

	public void salvaDadosDeEntrega(DadosEntregaCorreiosTO dadosEntregaTO) {
		System.out.println("Salvando dados de entrega: " + dadosEntregaTO);
	}
}
