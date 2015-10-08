package br.unicamp.comprefacil.to;

public class EnderecoTO {
	
	protected String cep;
	protected String logradouro;
	protected String complemento;
	protected String bairro;
	protected String localidade;
	protected String uf;
	protected long ibge;
	protected int gia;
	
	public EnderecoTO(String cep, String logradouro, String complemento,
			String bairro, String localidade, String uf, long ibge, int gia) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public long getIbge() {
		return ibge;
	}

	public int getGia() {
		return gia;
	}

}
