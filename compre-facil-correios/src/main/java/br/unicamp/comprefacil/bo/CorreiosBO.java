package br.unicamp.comprefacil.bo;

import com.google.gson.Gson;

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

public class CorreiosBO {
	
	private CorreiosDAO dao = new CorreiosDAO();
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

			response = dao.buscarValorEPrazo(dadosParaEntrega);

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

	public EnderecoTO validarCEP(String cep) {
		EnderecoTO toEndereco = null;
		
		try {
			// validar se CEP foi informado
			if (cep == null || cep.trim().equals("")) {
				throw new Exception("O campo CEP n�o foi informado.");
			}
			
			// validar se CEP � um n�mero inteiro
			Integer.parseInt(cep);
			
			toEndereco = gson.fromJson(dao.validarCep(cep), EnderecoTO.class);
			
			// validar se CEP foi encontrado
			if (toEndereco.getCep() == null) {
				toEndereco = null;
				throw new Exception("O CEP informado n�o foi encontrado.");
			}
		} catch (Throwable e) {
			if (e instanceof NumberFormatException) {
				e = new Exception("O CEP informado � inv�lido. O formato correto � compsoto por {8} d�gitos.");
			}
			e.printStackTrace();
		}
		
		return toEndereco;
	}
}
