package br.unicamp.comprefacil.dao;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import br.unicamp.comprefacil.to.EntregaTO;

public class CorreiosDAO {

	public static final String URL_CALC_PRECO_PRAZO = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazo";

	public String buscarValorEPrazo(EntregaTO dadosParaEntrega) {

		String retornoCorreios = null;

		try {

			HttpClientBuilder clientBuilder = HttpClientBuilder.create();
			RequestConfig.Builder reqBuilder = RequestConfig.custom();
			reqBuilder.setConnectTimeout(50000);
			reqBuilder.setConnectionRequestTimeout(50000);
			reqBuilder.setSocketTimeout(500000);

			clientBuilder.setDefaultRequestConfig(reqBuilder.build());

			HttpClient httpClient = clientBuilder.build();

			HttpPost httpost = new HttpPost(URL_CALC_PRECO_PRAZO);

			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

			param.add(new BasicNameValuePair("nCdEmpresa", dadosParaEntrega.getnCdEmpresa()));
			param.add(new BasicNameValuePair("sDsSenha", dadosParaEntrega.getsDsSenha()));
			param.add(new BasicNameValuePair("nCdServico", dadosParaEntrega.getnCdServico()));
			param.add(new BasicNameValuePair("sCepOrigem", dadosParaEntrega.getsCepOrigem()));
			param.add(new BasicNameValuePair("sCepDestino", dadosParaEntrega.getsCepDestino()));
			param.add(new BasicNameValuePair("nVlPeso", dadosParaEntrega.getnVlPeso()));
			param.add(new BasicNameValuePair("nCdFormato", dadosParaEntrega.getnCdFormato()));
			param.add(new BasicNameValuePair("nVlComprimento", dadosParaEntrega.getnVlComprimento()));
			param.add(new BasicNameValuePair("nVlAltura", dadosParaEntrega.getnVlAltura()));
			param.add(new BasicNameValuePair("nVlLargura", dadosParaEntrega.getnVlLargura()));
			param.add(new BasicNameValuePair("nVlDiametro", dadosParaEntrega.getnVlDiametro()));
			param.add(new BasicNameValuePair("sCdMaoPropria", dadosParaEntrega.getsCdMaoPropria()));
			param.add(new BasicNameValuePair("nVlValorDeclarado", dadosParaEntrega.getnVlValorDeclarado()));
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

}
