package br.unicamp.comprefacil.to;

public class DadosEntregaCorreiosTO {
	
	private String valor;
	private String prazo;
	private String erro;
	private String msg;
	
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	@Override
	public String toString() {
		return "[valor=" + valor + ", prazo=" + prazo + "]";
	}
}
