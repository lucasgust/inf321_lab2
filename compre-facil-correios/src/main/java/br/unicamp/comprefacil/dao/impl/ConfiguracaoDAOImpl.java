package br.unicamp.comprefacil.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.comprefacil.dao.ConfiguracaoDAO;
import br.unicamp.comprefacil.to.ConfiguracaoTO;

public class ConfiguracaoDAOImpl implements ConfiguracaoDAO {
	
	private List<ConfiguracaoTO> configuracoes;
	
	public ConfiguracaoDAOImpl() {
		configuracoes = new ArrayList<ConfiguracaoTO>();
		configuracoes.add(new ConfiguracaoTO("CORREIOS", "DOMINIO", "http://ws.correios.com.br/"));
		configuracoes.add(new ConfiguracaoTO("VIACEP", "DOMINIO", "https://viacep.com.br/"));
//		configuracoes.add(new ConfiguracaoTO("CORREIOS", "DOMINIO", "http://localhost:8089"));
//		configuracoes.add(new ConfiguracaoTO("VIACEP", "DOMINIO", "http://localhost:8089"));
	}

	public String buscaPorGrupoEChave(String grupo, String chave) {
		ConfiguracaoTO exemplo = new ConfiguracaoTO(grupo, chave, "");
		int indice = this.configuracoes.indexOf(exemplo);
		return indice >= 0 ? this.configuracoes.get(indice).getValor() : null;
	}
}
