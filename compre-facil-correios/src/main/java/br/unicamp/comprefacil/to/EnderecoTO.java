package br.unicamp.comprefacil.to;

public class EnderecoTO {
	
	protected String cep;
	protected String logradouro;
	protected String complemento;
	protected String bairro;
	protected String localidade;
	protected String uf;
	protected String ibge;
	protected String gia;
	
	public EnderecoTO(String cep, String logradouro, String complemento,
			String bairro, String localidade, String uf, String ibge, String gia) {
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

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}
	
	@Override
	public String toString() {
		return "[cep=" + cep + ", logradouro=" + logradouro + "]";
	}
}