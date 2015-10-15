package br.unicamp.comprefacil.service;

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.dao.DadosDeEntregaDAO;
import br.unicamp.comprefacil.exception.CorreiosException;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

public interface CorreiosService {
	
	public String validaCep(String cep) throws CorreiosException;
	public DadosEntregaCorreiosTO buscaValorEPrazo(EntregaTO dadosParaEntrega) throws CorreiosException;
	public EnderecoTO buscaEndereco(String cep) throws CorreiosException;
	public void setCorreiosDAO(CorreiosDAO dao);
	public void setDadosDeEntregaDAO(DadosDeEntregaDAO dao);
}