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

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.dao.DadosDeEntregaDAO;
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
	private DadosDeEntregaDAO dadosDeEntregaDAO;

	public static final String URL_CALC_PRECO_PRAZO = "http://localhost:8089/correios/ws/CalcPrecoPrazo.asmx/CalcPrecoPrazo";
	public static final String URL_VALIDA_CEP = "http://localhost:8089/viacep/ws/{0}/json/";

	public CorreiosServiceImpl() {
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
			HttpClient httpClient = getHttpClient();
			HttpPost httpost = new HttpPost(URL_CALC_PRECO_PRAZO);

			List<NameValuePair> param = new ArrayList<NameValuePair>();

			param.add(new BasicNameValuePair("nCdEmpresa", dadosParaEntrega
					.getnCdEmpresa()));
			param.add(new BasicNameValuePair("sDsSenha", dadosParaEntrega
					.getsDsSenha()));
			param.add(new BasicNameValuePair("nCdServico", dadosParaEntrega
					.getnCdServico()));
			param.add(new BasicNameValuePair("sCepOrigem", dadosParaEntrega
					.getsCepOrigem()));
			param.add(new BasicNameValuePair("sCepDestino", dadosParaEntrega
					.getsCepDestino()));
			param.add(new BasicNameValuePair("nVlPeso", dadosParaEntrega
					.getnVlPeso() + ""));
			param.add(new BasicNameValuePair("nCdFormato", dadosParaEntrega
					.getnCdFormato() + ""));
			param.add(new BasicNameValuePair("nVlComprimento", dadosParaEntrega
					.getnVlComprimento() + ""));
			param.add(new BasicNameValuePair("nVlAltura", dadosParaEntrega
					.getnVlAltura() + ""));
			param.add(new BasicNameValuePair("nVlLargura", dadosParaEntrega
					.getnVlLargura() + ""));
			param.add(new BasicNameValuePair("nVlDiametro", dadosParaEntrega
					.getnVlDiametro() + ""));
			param.add(new BasicNameValuePair("sCdMaoPropria", dadosParaEntrega
					.getsCdMaoPropria()));
			param.add(new BasicNameValuePair("nVlValorDeclarado",
					dadosParaEntrega.getnVlValorDeclarado() + ""));
			param.add(new BasicNameValuePair("sCdAvisoRecebimento",
					dadosParaEntrega.getsCdAvisoRecebimento()));

			httpost.setEntity(new UrlEncodedFormEntity(param));

			HttpResponse response = httpClient.execute(httpost);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new CorreiosException(
						"C�digo de retorno diferente de Http OK");
			}

			String responseXML = EntityUtils.toString(response.getEntity());

			int indexValInicial = responseXML.indexOf("<Valor>");
			int indexValFinal = responseXML.indexOf("</Valor>");
			int indexPrazoInicial = responseXML.indexOf("<PrazoEntrega>");
			int indexPrazoFinal = responseXML.indexOf("</PrazoEntrega>");

			String valor = responseXML.substring(indexValInicial, indexValFinal);
			valor = valor.replace("<Valor>", "").trim();
			String prazo = responseXML.substring(indexPrazoInicial, indexPrazoFinal);
			prazo = prazo.replace("<PrazoEntrega>", "").trim();

			dadosEntrega = new DadosEntregaCorreiosTO();

			dadosEntrega.setValor(Double.valueOf(valor.replace(",", ".")));
			dadosEntrega.setPrazo(Integer.valueOf(prazo));

			dadosDeEntregaDAO.salvaDadosDeEntrega(dadosEntrega);

		} catch (Exception e) {
			throw new CorreiosException(e);
		}

		return dadosEntrega;
	}

	public String validaCep(String cep) throws CorreiosException, NoHttpResponseException {
		try {
			HttpClient httpClient = getHttpClient();
			Object[] params = { cep };
			HttpGet httpget = new HttpGet(MessageFormat.format(URL_VALIDA_CEP, params));
			HttpResponse response = httpClient.execute(httpget);
			
			if (response.getStatusLine().getStatusCode() == 400) {
				throw new CorreiosException("O CEP nao foi informado ou eh invalido. O formato correto eh composto por 8 digitos.");
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

	public void setCorreiosDAO(CorreiosDAO dao) {
		this.correiosDAO = dao;
	}

	public void setDadosDeEntregaDAO(DadosDeEntregaDAO dao) {
		this.dadosDeEntregaDAO = dao;
	}
}
