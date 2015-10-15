package br.unicamp.comprefacil.integration;

import org.junit.Before;
import org.junit.Test;

import br.unicamp.comprefacil.exception.CorreiosException;
import br.unicamp.comprefacil.service.CorreiosService;
import br.unicamp.comprefacil.service.impl.CorreiosServiceImpl;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

public class CorreiosIntegrationTest {
	
	private CorreiosService correiosService;
	
	@Before
	public void setUp() {
		correiosService = new CorreiosServiceImpl();
	}

	@Test
	public void testarBuscarValorEPrazo() throws CorreiosException {
		System.out.println("Testando: buscarValorEPrazo\n");
		EntregaTO entrega = new EntregaTO();
		DadosEntregaCorreiosTO retorno = new DadosEntregaCorreiosTO();
		
		entrega.setnCdFormato(3);
		entrega.setnCdServico("40215");
		entrega.setnVlAltura(1);
		entrega.setnVlComprimento(16);
		entrega.setnVlDiametro(1);
		entrega.setnVlLargura(11);
		entrega.setnVlPeso(1);
		entrega.setnVlValorDeclarado(0);
		entrega.setsCdAvisoRecebimento("S");
		entrega.setsCdMaoPropria("S");
		entrega.setsCepDestino("09520650");
		entrega.setsCepOrigem("09520650");
	
		retorno = correiosService.buscaValorEPrazo(entrega);
		
		System.out.println("Prazo: " + retorno.getPrazo());
		System.out.println("Valor: " + retorno.getValor());
	}
	
	@Test
	public void testarValidarCEP() throws Exception {
		System.out.println("\n\nTestando: validarCEP\n");
		
		EnderecoTO toEndereco = correiosService.buscaEndereco("01001000"); // praça da sé
		
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
