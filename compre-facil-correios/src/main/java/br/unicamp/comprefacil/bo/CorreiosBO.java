package br.unicamp.comprefacil.bo;

import com.google.gson.Gson;

import br.unicamp.comprefacil.dao.CorreiosImpl;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

public class CorreiosBO {
	
	private CorreiosImpl impl = new CorreiosImpl();
	private Gson gson = new Gson();

	public DadosEntregaCorreiosTO buscarValorEPrazo(EntregaTO dadosParaEntrega) {

		String response = null;
		String valor = null;
		String prazo = null;
		int indexValInicial = 0;
		int indexValFinal = 0;
		int indexPrazoInicial = 0;
		int indexPrazoFinal = 0;

		DadosEntregaCorreiosTO retornoCorreios = new DadosEntregaCorreiosTO();

		try {

			response = impl.buscarValorEPrazo(dadosParaEntrega);

			indexValInicial = response.indexOf("<Valor>");
			indexValFinal = response.indexOf("</Valor>");
			indexPrazoInicial = response.indexOf("<PrazoEntrega>");
			indexPrazoFinal = response.indexOf("</PrazoEntrega>");

			valor = response.substring(indexValInicial, indexValFinal);
			valor = valor.replace("<Valor>", "").trim();
			prazo = response.substring(indexPrazoInicial, indexPrazoFinal);
			prazo = prazo.replace("<PrazoEntrega>", "").trim();

			retornoCorreios.setValor(valor);
			retornoCorreios.setPrazo(prazo);

		} catch (Exception e) {

		}

		return retornoCorreios;
	}

	public EnderecoTO validarCEP(String cep) throws Exception {
		EnderecoTO toEndereco = null;
		
		try {
			// validar se CEP foi informado
			if (cep == null || cep.trim().equals("")) {
				throw new Exception("O campo CEP não foi informado.");
			}
			
			// validar se CEP é um número inteiro
			Integer.parseInt(cep);
			
			toEndereco = gson.fromJson(impl.validarCep(cep), EnderecoTO.class);
			
			// validar se CEP foi encontrado
			if (toEndereco.getCep() == null) {
				toEndereco = null;
				throw new Exception("O CEP informado nao foi encontrado.");
			}
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				e = new Exception("O CEP informado eh invalido. O formato correto é composto por 8 digitos.");
			}
			throw e;
		}
		
		return toEndereco;
	}
}
