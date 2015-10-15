package br.unicamp.comprefacil.to;

public class DadosEntregaCorreiosTO {
	
	private Double valor;
	private Integer prazo;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getPrazo() {
		return prazo;
	}
	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}
	@Override
	public String toString() {
		return "[valor=" + valor + ", prazo=" + prazo + "]";
	}
}
