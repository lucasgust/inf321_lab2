package br.unicamp.comprefacil.teste;

import br.unicamp.comprefacil.bo.CorreiosBO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EntregaTO;

public class Teste {

	public static void main(String[] args) {
		
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
	
		
		CorreiosBO correio = new CorreiosBO();
		retorno = correio.buscarValorEPrazo(entrega);
		
		
		System.out.println("Prazo: " + retorno.getPrazo());
		System.out.println("Valor: " + retorno.getValor());
		

	}

}
