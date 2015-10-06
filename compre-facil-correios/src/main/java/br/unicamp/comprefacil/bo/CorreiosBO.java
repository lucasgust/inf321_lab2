package br.unicamp.comprefacil.bo;

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EntregaTO;

public class CorreiosBO {

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

			CorreiosDAO dao = new CorreiosDAO();
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

}
