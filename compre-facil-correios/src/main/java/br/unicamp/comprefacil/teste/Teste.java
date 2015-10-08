package br.unicamp.comprefacil.teste;

import br.unicamp.comprefacil.bo.CorreiosBO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

public class Teste {
	
	private CorreiosBO correio = new CorreiosBO();

	public static void main(String[] args) {
		Teste teste = new Teste();
//		teste.testarBuscarValorEPrazo();
		teste.testarValidarCEP();
	}
	
	private void testarBuscarValorEPrazo() {
		System.out.println("Testando: buscarValorEPrazo\n");
		EntregaTO entrega = new EntregaTO();
		DadosEntregaCorreiosTO retorno = new DadosEntregaCorreiosTO();
		
		entrega.setnCdFormato("3");
		entrega.setnCdServico("40215");
		entrega.setnVlAltura("1");
		entrega.setnVlComprimento("16");
		entrega.setnVlDiametro("1");
		entrega.setnVlLargura("11");
		entrega.setnVlPeso("1");
		entrega.setnVlValorDeclarado("0");
		entrega.setsCdAvisoRecebimento("S");
		entrega.setsCdMaoPropria("S");
		entrega.setsCepDestino("09520650");
		entrega.setsCepOrigem("09520650");
	
		retorno = correio.buscarValorEPrazo(entrega);
		
		System.out.println("Prazo: " + retorno.getPrazo());
		System.out.println("Valor: " + retorno.getValor());
	}
	
	private void testarValidarCEP() {
		System.out.println("\n\nTestando: validarCEP\n");
		
		EnderecoTO toEndereco = correio.validarCEP("01001000"); // pra�a da s�
		
		if (toEndereco != null) {
			System.out.println(
				"CEP........: " + toEndereco.getCep() + "\n" +
				"Logradouro.: " + toEndereco.getLogradouro() + "\n" +
				"Complemento: " + toEndereco.getComplemento() + "\n" +
				"Bairro.....: " + toEndereco.getBairro() + "\n" +
				"Localidade.: " + toEndereco.getLocalidade() + "\n" +
				"UF.........: " + toEndereco.getUf() + "\n" +
				"IBGE.......: " + toEndereco.getIbge() + "\n" +
				"Gia........: " + toEndereco.getGia()
			);
		}
	}

}
