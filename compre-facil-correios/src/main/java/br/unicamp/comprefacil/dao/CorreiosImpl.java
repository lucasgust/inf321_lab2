package br.unicamp.comprefacil.dao;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import br.unicamp.comprefacil.to.EntregaTO;

public class CorreiosImpl {

	public static final String URL_CALC_PRECO_PRAZO = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazo";
	public static final String URL_VALIDA_CEP = "http://viacep.com.br/ws/{0}/json/";
	
	private HttpClient getHttpClient() {
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		RequestConfig.Builder reqBuilder = RequestConfig.custom();
		reqBuilder.setConnectTimeout(50000);
		reqBuilder.setConnectionRequestTimeout(50000);
		reqBuilder.setSocketTimeout(500000);

		clientBuilder.setDefaultRequestConfig(reqBuilder.build());

		return clientBuilder.build();
	}

	public String buscarValorEPrazo(EntregaTO dadosParaEntrega) {

		String retornoCorreios = null;

		try {
			
			HttpClient httpClient = getHttpClient();

			HttpPost httpost = new HttpPost(URL_CALC_PRECO_PRAZO);

			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

			param.add(new BasicNameValuePair("nCdEmpresa", dadosParaEntrega.getnCdEmpresa()));
			param.add(new BasicNameValuePair("sDsSenha", dadosParaEntrega.getsDsSenha()));
			param.add(new BasicNameValuePair("nCdServico", dadosParaEntrega.getnCdServico()));
			param.add(new BasicNameValuePair("sCepOrigem", dadosParaEntrega.getsCepOrigem()));
			param.add(new BasicNameValuePair("sCepDestino", dadosParaEntrega.getsCepDestino()));
			param.add(new BasicNameValuePair("nVlPeso", dadosParaEntrega.getnVlPeso()+""));
			param.add(new BasicNameValuePair("nCdFormato", dadosParaEntrega.getnCdFormato()+""));
			param.add(new BasicNameValuePair("nVlComprimento", dadosParaEntrega.getnVlComprimento()+""));
			param.add(new BasicNameValuePair("nVlAltura", dadosParaEntrega.getnVlAltura()+""));
			param.add(new BasicNameValuePair("nVlLargura", dadosParaEntrega.getnVlLargura()+""));
			param.add(new BasicNameValuePair("nVlDiametro", dadosParaEntrega.getnVlDiametro()+""));
			param.add(new BasicNameValuePair("sCdMaoPropria", dadosParaEntrega.getsCdMaoPropria()));
			param.add(new BasicNameValuePair("nVlValorDeclarado", dadosParaEntrega.getnVlValorDeclarado()+""));
			param.add(new BasicNameValuePair("sCdAvisoRecebimento", dadosParaEntrega.getsCdAvisoRecebimento()));

			httpost.setEntity(new UrlEncodedFormEntity(param));

			HttpResponse response = httpClient.execute(httpost);

			retornoCorreios = EntityUtils.toString(response.getEntity());

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Código de retorno diferente de Http OK");
			}

		} catch (Exception e) {

		}

		return retornoCorreios;
	}
	
	public String validarCep(String cep) {

		try {
			HttpClient httpClient = getHttpClient();
			
			Object[] params = {cep};

			HttpGet httpget = new HttpGet(MessageFormat.format(URL_VALIDA_CEP, params));

			HttpResponse response = httpClient.execute(httpget);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Código de retorno diferente de Http OK");
			} else {
				return EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
