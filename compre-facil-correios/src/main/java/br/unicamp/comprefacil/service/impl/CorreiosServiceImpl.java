package br.unicamp.comprefacil.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import br.unicamp.comprefacil.dao.ConfiguracaoDAO;
import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.dao.DadosDeEntregaDAO;
import br.unicamp.comprefacil.dao.impl.ConfiguracaoDAOImpl;
import br.unicamp.comprefacil.dao.impl.CorreiosDAOImpl;
import br.unicamp.comprefacil.dao.impl.DadosDeEntregaDAOImpl;
import br.unicamp.comprefacil.exception.CorreiosException;
import br.unicamp.comprefacil.service.CorreiosService;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

import com.google.gson.Gson;

public class CorreiosServiceImpl implements CorreiosService {

	private Gson gson = new Gson();
	private CorreiosDAO correiosDAO;
	private ConfiguracaoDAO configuracaoDAO;
	private DadosDeEntregaDAO dadosDeEntregaDAO;

	public static final String RESOURCE_PRECO_PRAZO = "/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazo";
	public static final String RESOURCE_VALIDA_CEP = "/viacep/ws/{0}/json/";

	public CorreiosServiceImpl() {
		setConfiguracaoDAO(new ConfiguracaoDAOImpl());
		setCorreiosDAO(new CorreiosDAOImpl());
		setDadosDeEntregaDAO(new DadosDeEntregaDAOImpl());
	}

	private HttpClient getHttpClient() {
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		RequestConfig.Builder reqBuilder = RequestConfig.custom();
		reqBuilder.setConnectTimeout(50000);
		reqBuilder.setConnectionRequestTimeout(50000);
		reqBuilder.setSocketTimeout(500000);

		clientBuilder.setDefaultRequestConfig(reqBuilder.build());

		return clientBuilder.build();
	}

	public DadosEntregaCorreiosTO buscaValorEPrazo(EntregaTO dadosParaEntrega) throws CorreiosException {
		DadosEntregaCorreiosTO dadosEntrega = null;

		try {
			String dominio = this.configuracaoDAO.buscaPorGrupoEChave("CORREIOS", "DOMINIO");

			HttpClient httpClient = getHttpClient();

			HttpGet httpget = new HttpGet(dominio + RESOURCE_PRECO_PRAZO);

			HttpResponse response = httpClient.execute(httpget);

			String responseXML = EntityUtils.toString(response.getEntity());

			System.out.println(responseXML);

			int indexValInicial = responseXML.indexOf("<Valor>");
			int indexValFinal = responseXML.indexOf("</Valor>");
			int indexPrazoInicial = responseXML.indexOf("<PrazoEntrega>");
			int indexPrazoFinal = responseXML.indexOf("</PrazoEntrega>");
			int indexErroInicial = responseXML.indexOf("<Erro>");
			int indexErroFinal = responseXML.indexOf("</Erro>");
			

			String valor = responseXML.substring(indexValInicial, indexValFinal);
			valor = valor.replace("<Valor>", "").trim();
			
			String prazo = responseXML.substring(indexPrazoInicial, indexPrazoFinal);
			prazo = prazo.replace("<PrazoEntrega>", "").trim();
					
			String erro = responseXML.substring(indexErroInicial, indexErroFinal);
			erro = erro.replace("<Erro>", "").trim();
			
			String msg = "";
			
			if(!erro.equals("0")){
				int indexMsgInicial = responseXML.indexOf("<MsgErro>");
				int indexMsgFinal = responseXML.indexOf("</MsgErro>");
				msg = responseXML.substring(indexMsgInicial, indexMsgFinal);
				msg = msg.replace("<MsgErro>", "").trim();
			}
		
			dadosEntrega = new DadosEntregaCorreiosTO();

			dadosEntrega.setValor(valor);
			dadosEntrega.setPrazo(prazo);
			dadosEntrega.setErro(erro);
			dadosEntrega.setMsg(msg);

		} catch (Exception e) {
			throw new CorreiosException(e);
		}

		return dadosEntrega;
	}

	public String validaCep(String cep) throws CorreiosException, NoHttpResponseException {
		try {
			String dominio = this.configuracaoDAO.buscaPorGrupoEChave("VIACEP", "DOMINIO");
			HttpClient httpClient = getHttpClient();
			Object[] params = { cep };
			HttpGet httpget = new HttpGet(MessageFormat.format(dominio + RESOURCE_VALIDA_CEP, params));
			HttpResponse response = httpClient.execute(httpget);

			if (response.getStatusLine().getStatusCode() == 400) {
				throw new CorreiosException(
						"O CEP nao foi informado ou eh invalido. O formato correto eh composto por 8 digitos.");
			}

			String responseText = EntityUtils.toString(response.getEntity());

			if (responseText.equals("{\"erro\": true}")) {
				throw new CorreiosException("O CEP informado nao foi encontrado.");
			}

			return responseText;
		} catch (NoHttpResponseException e) {
			throw new NoHttpResponseException("Servico indisponivel. Por favor, tente mais tarde.");
		} catch (Exception e) {
			throw new CorreiosException(e);
		}
	}

	public EnderecoTO buscaEndereco(String cep) throws CorreiosException, NoHttpResponseException {
		String json = this.validaCep(cep);
		EnderecoTO endereco = gson.fromJson(json, EnderecoTO.class);
		correiosDAO.salvaEndereco(endereco);
		return endereco;
	}

	public void setConfiguracaoDAO(ConfiguracaoDAO configuracaoDAO) {
		this.configuracaoDAO = configuracaoDAO;
	}

	public void setCorreiosDAO(CorreiosDAO dao) {
		this.correiosDAO = dao;
	}

	public void setDadosDeEntregaDAO(DadosDeEntregaDAO dao) {
		this.dadosDeEntregaDAO = dao;
	}
}
