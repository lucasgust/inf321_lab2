package br.unicamp.comprefacil.steps;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.http.NoHttpResponseException;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.mockito.Mockito;

import br.unicamp.comprefacil.dao.ConfiguracaoDAO;
import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.dao.DadosDeEntregaDAO;
import br.unicamp.comprefacil.service.CorreiosService;
import br.unicamp.comprefacil.service.impl.CorreiosServiceImpl;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompreFacilSteps {

	private CorreiosService correiosService;
	private EnderecoTO toEndereco;
	private EntregaTO entrega;
	private DadosEntregaCorreiosTO dadosEntrega;

	private ConfiguracaoDAO configuracaoDAO;
	private CorreiosDAO correiosDAOMock;
	private DadosDeEntregaDAO dadosDeEntregaMock;

	private String cep;
	private Throwable throwable;

	private String url;

	private Boolean erroGrave;

	@Before
	public void setUp() {
		configuracaoDAO = Mockito.mock(ConfiguracaoDAO.class);
		correiosDAOMock = Mockito.mock(CorreiosDAO.class);
		dadosDeEntregaMock = Mockito.mock(DadosDeEntregaDAO.class);

		correiosService = new CorreiosServiceImpl();
		correiosService.setConfiguracaoDAO(configuracaoDAO);
		correiosService.setCorreiosDAO(correiosDAOMock);
		correiosService.setDadosDeEntregaDAO(dadosDeEntregaMock);

		throwable = null;
		entrega = new EntregaTO();

		Mockito.when(configuracaoDAO.buscaPorGrupoEChave("CORREIOS", "DOMINIO")).thenReturn("http://localhost:8089");
		Mockito.when(configuracaoDAO.buscaPorGrupoEChave("VIACEP", "DOMINIO")).thenReturn("http://localhost:8089");
	}

	@Given("^All items from sales order are settled$")
	public void all_items_from_sales_order_are_settled() throws Throwable {
		Assert.assertTrue(true);
	}

	@Given("^User types \"([^\"]*)\"$")
	public void user_types(String sCepDestino) throws Throwable {
		entrega.setsCepDestino(sCepDestino);
	}

	@When("^User press button to calculate freight$")
	public void user_press_button_to_calculate_freight() throws Throwable {
		Assert.assertTrue(true);
	}

	@When("^system connects to Correios API$")
	public void system_connects_to_Correios_API() throws Throwable {
		assertNotNull(correiosService);
	}

	@When("^system sends the file with all mandatory tags \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void system_sends_the_file_with_all_mandatory_tags(String nCdEmpresa, String sDsSenha, String nCdServico,
			String sCepOrigem, String sCepDestino, String nVlPeso, String nCdFormato, String nVlComprimento, String nVlAltura,
			String nVlLargura, String nVlDiametro, String sCdMaoPropria, String nVlValorDeclarado,
			String sCdAvisoRecebimento) throws Throwable {
		this.entrega.setnCdEmpresa(nCdEmpresa);
		this.entrega.setsDsSenha(sDsSenha);
		this.entrega.setnCdServico(nCdServico);
		this.entrega.setsCepOrigem(sCepOrigem);
		this.entrega.setsCepDestino(sCepDestino);
		this.entrega.setnVlPeso(Integer.valueOf(nVlPeso));
		this.entrega.setnCdFormato(Integer.valueOf(nCdFormato));
		this.entrega.setnVlComprimento(Integer.valueOf(nVlComprimento));
		this.entrega.setnVlAltura(Integer.valueOf(nVlAltura));
		this.entrega.setnVlLargura(Integer.valueOf(nVlLargura));
		this.entrega.setnVlDiametro(Integer.valueOf(nVlDiametro));
		this.entrega.setsCdMaoPropria(sCdMaoPropria);
		this.entrega.setnVlValorDeclarado(Integer.valueOf(nVlValorDeclarado));
		this.entrega.setsCdAvisoRecebimento(sCdAvisoRecebimento);
		url = "/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazo";
		
		//Sucesso
		if (this.entrega.getnCdEmpresa().equals("") && this.entrega.getsDsSenha().equals("")
				&& this.entrega.getnCdServico().equals("40010") && this.entrega.getsCepOrigem().equals("13495000")
				&& this.entrega.getsCepDestino().equals("13417780") && this.entrega.getnVlPeso() == 10
				&& this.entrega.getnCdFormato() == 1 && this.entrega.getnVlComprimento() == 20
				&& this.entrega.getnVlAltura() == 5 && this.entrega.getnVlLargura() == 12
				&& this.entrega.getnVlDiametro() == 8 && this.entrega.getsCdMaoPropria().equals("N")
				&& this.entrega.getnVlValorDeclarado() == 0 && this.entrega.getsCdAvisoRecebimento().equals("N")) {
			stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/xml").withBody(
							"<?xml version=\"1.0\" encoding=\"utf-8\"?><cResultado xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://tempuri.org/\"><Servicos><cServico><Codigo>40010</Codigo><Valor>31,30</Valor><PrazoEntrega>2</PrazoEntrega><ValorMaoPropria>0,00</ValorMaoPropria><ValorAvisoRecebimento>0,00</ValorAvisoRecebimento><ValorValorDeclarado>0,00</ValorValorDeclarado><EntregaDomiciliar>S</EntregaDomiciliar><EntregaSabado>S</EntregaSabado><Erro>0</Erro><MsgErro /><ValorSemAdicionais>31,30</ValorSemAdicionais><obsFim /></cServico></Servicos></cResultado>")));
		//Sucesso
		} else if (this.entrega.getnCdEmpresa().equals("") && this.entrega.getsDsSenha().equals("")
				&& this.entrega.getnCdServico().equals("40010") && this.entrega.getsCepOrigem().equals("13084971")
				&& this.entrega.getsCepDestino().equals("13083872") && this.entrega.getnVlPeso() == 15
				&& this.entrega.getnCdFormato() == 2 && this.entrega.getnVlComprimento() == 30
				&& this.entrega.getnVlAltura() == 5 && this.entrega.getnVlLargura() == 13
				&& this.entrega.getnVlDiametro() == 8 && this.entrega.getsCdMaoPropria().equals("N")
				&& this.entrega.getnVlValorDeclarado() == 0 && this.entrega.getsCdAvisoRecebimento().equals("N")) {
			stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/xml").withBody(
							"<?xml version=\"1.0\" encoding=\"utf-8\"?><cResultado xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://tempuri.org/\"><Servicos><cServico><Codigo>40010</Codigo><Valor>46,30</Valor><PrazoEntrega>1</PrazoEntrega><ValorMaoPropria>0,00</ValorMaoPropria><ValorAvisoRecebimento>0,00</ValorAvisoRecebimento><ValorValorDeclarado>0,00</ValorValorDeclarado><EntregaDomiciliar>S</EntregaDomiciliar><EntregaSabado>S</EntregaSabado><Erro>0</Erro><MsgErro /><ValorSemAdicionais>46,30</ValorSemAdicionais><obsFim /></cServico></Servicos></cResultado>")));
		
		//Erro de cálculo de tarifa (problema de prazo e/ou valor)
		} else if (this.entrega.getnCdEmpresa().equals("") && this.entrega.getsDsSenha().equals("")
				&& this.entrega.getnCdServico().equals("40010") && this.entrega.getsCepDestino().equals("13417780")
				&& this.entrega.getsCepOrigem().equals("") && this.entrega.getnVlPeso() == 10
				&& this.entrega.getnCdFormato() == 1 && this.entrega.getnVlComprimento() == 20
				&& this.entrega.getnVlAltura() == 5 && this.entrega.getnVlLargura() == 12
				&& this.entrega.getnVlDiametro() == 8 && this.entrega.getsCdMaoPropria().equals("N")
				&& this.entrega.getnVlValorDeclarado() == 0 && this.entrega.getsCdAvisoRecebimento().equals("N")) {
			stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/xml").withBody(
							"<?xml version=\"1.0\" encoding=\"utf-8\"?><cResultado xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://tempuri.org/\"><Servicos><cServico><Codigo>40010</Codigo><Valor>0</Valor><PrazoEntrega>0</PrazoEntrega><ValorMaoPropria>0</ValorMaoPropria><ValorAvisoRecebimento>0</ValorAvisoRecebimento><ValorValorDeclarado>0</ValorValorDeclarado><EntregaDomiciliar></EntregaDomiciliar><EntregaSabado></EntregaSabado><Erro>-888</Erro><MsgErro>Erro ao calcular tarifa</MsgErro><ValorSemAdicionais></ValorSemAdicionais><obsFim /></cServico></Servicos></cResultado>")));

		//Erro de serviço indisponível	
		}else if (this.entrega.getnCdEmpresa().equals("") && this.entrega.getsDsSenha().equals("")
				&& this.entrega.getnCdServico().equals("40010") && this.entrega.getsCepOrigem().equals("13084971")
				&& this.entrega.getsCepDestino().equals("13083872") && this.entrega.getnVlPeso() == 15
				&& this.entrega.getnCdFormato() == 2 && this.entrega.getnVlComprimento() == 30
				&& this.entrega.getnVlAltura() == 5 && this.entrega.getnVlLargura() == 13
				&& this.entrega.getnVlDiametro() == 8 && this.entrega.getsCdMaoPropria().equals("S")
				&& this.entrega.getnVlValorDeclarado() == 0 && this.entrega.getsCdAvisoRecebimento().equals("S")) {
			stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/xml").withBody(
							"<cResultado xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://tempuri.org/\"><Servicos><cServico><Codigo>40010</Codigo><Valor>0</Valor><PrazoEntrega>0</PrazoEntrega><ValorMaoPropria>0</ValorMaoPropria><ValorAvisoRecebimento>0</ValorAvisoRecebimento><ValorValorDeclarado>0</ValorValorDeclarado><EntregaDomiciliar></EntregaDomiciliar><EntregaSabado></EntregaSabado><Erro>7</Erro><MsgErro>Servico indisponivel, tente mais tarde</MsgErro><ValorSemAdicionais>0</ValorSemAdicionais><obsFim /></cServico></Servicos></cResultado>")));
		
		//Cep de origem inválido
		} else if (this.entrega.getnCdEmpresa().equals("") && this.entrega.getsDsSenha().equals("")
				&& this.entrega.getnCdServico().equals("40010") && this.entrega.getsCepOrigem().equals("130c497a")
				&& this.entrega.getsCepDestino().equals("13083872") && this.entrega.getnVlPeso() == 15
				&& this.entrega.getnCdFormato() == 2 && this.entrega.getnVlComprimento() == 30
				&& this.entrega.getnVlAltura() == 5 && this.entrega.getnVlLargura() == 13
				&& this.entrega.getnVlDiametro() == 8 && this.entrega.getsCdMaoPropria().equals("S")
				&& this.entrega.getnVlValorDeclarado() == 0 && this.entrega.getsCdAvisoRecebimento().equals("S")) {
			stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/xml").withBody(
							"<cResultado xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://tempuri.org/\"><Servicos><cServico><Codigo>40010</Codigo><Valor>0</Valor><PrazoEntrega>0</PrazoEntrega><ValorMaoPropria>0</ValorMaoPropria><ValorAvisoRecebimento>0</ValorAvisoRecebimento><ValorValorDeclarado>0</ValorValorDeclarado><EntregaDomiciliar></EntregaDomiciliar><EntregaSabado></EntregaSabado><Erro>-2</Erro><MsgErro>CEP de origem invalido</MsgErro><ValorSemAdicionais>0</ValorSemAdicionais><obsFim /></cServico></Servicos></cResultado>")));
		
		//Cep de destino inválido
		} else if (this.entrega.getnCdEmpresa().equals("") && this.entrega.getsDsSenha().equals("")
				&& this.entrega.getnCdServico().equals("40010") && this.entrega.getsCepOrigem().equals("13084971")
				&& this.entrega.getsCepDestino().equals("130c497a") && this.entrega.getnVlPeso() == 15
				&& this.entrega.getnCdFormato() == 2 && this.entrega.getnVlComprimento() == 30
				&& this.entrega.getnVlAltura() == 5 && this.entrega.getnVlLargura() == 13
				&& this.entrega.getnVlDiametro() == 8 && this.entrega.getsCdMaoPropria().equals("S")
				&& this.entrega.getnVlValorDeclarado() == 0 && this.entrega.getsCdAvisoRecebimento().equals("S")) {
			stubFor(get(urlEqualTo(url))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/xml").withBody(
							"<cResultado xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://tempuri.org/\"><Servicos><cServico><Codigo>40010</Codigo><Valor>0</Valor><PrazoEntrega>0</PrazoEntrega><ValorMaoPropria>0</ValorMaoPropria><ValorAvisoRecebimento>0</ValorAvisoRecebimento><ValorValorDeclarado>0</ValorValorDeclarado><EntregaDomiciliar></EntregaDomiciliar><EntregaSabado></EntregaSabado><Erro>-3</Erro><MsgErro>CEP de destino invalido</MsgErro><ValorSemAdicionais>0</ValorSemAdicionais><obsFim /></cServico></Servicos></cResultado>")));
		}
		


		dadosEntrega = this.correiosService.buscaValorEPrazo(entrega);
		Mockito.verify(configuracaoDAO, Mockito.times(1)).buscaPorGrupoEChave("CORREIOS", "DOMINIO");

	}

	@Then("^correios API returns \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void correios_API_returns(String valor, String prazoEntrega, String cErro, String msgErro) throws Throwable {	
			assertEquals(dadosEntrega.getValor(), valor);
			assertEquals(dadosEntrega.getPrazo(), prazoEntrega);
			assertEquals(dadosEntrega.getErro(), cErro);
			assertEquals(dadosEntrega.getMsg(), msgErro);		
	}

	/**
	 * 
	 * @param sPrazoEntrega
	 * @param sValor
	 * @throws Throwable
	 * 
	 *             Adicionei este step para realizar o Mock de salvar os dados
	 *             creio que talvez seja necessário add algum assertThat
	 */
	@Then("^save data in database \"([^\"]*)\" \"([^\"]*)\"$")
	public void save_data_in_database(String prazoEntrega, String valor) throws Throwable {
		DadosEntregaCorreiosTO dadosEntregaTO = new DadosEntregaCorreiosTO();
		dadosEntregaTO.setPrazo(prazoEntrega);
		dadosEntregaTO.setValor(valor);
		Mockito.verify(this.dadosDeEntregaMock, Mockito.times(1)).salvaDadosDeEntrega(dadosEntregaTO);
	}

	@Given("^at least one field is not valid$")
	public void at_least_one_field_is_not_valid() throws Throwable {
		Assert.assertTrue(true);
	}

	@Given("^I have a valid and registered zip code \"([^\"]*)\"$")
	public void i_have_a_valid_and_registered_zip_code(String cep) throws Throwable {
		try {
			Integer.parseInt(cep);
			this.cep = cep;
		} catch (NumberFormatException e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("^I press button to search$")
	public void i_press_button_to_search() throws Throwable {
		this.erroGrave = false;
		this.url = null;
		try {
			if (this.cep == null) {
				this.cep = "";
			}
			url = "/viacep/ws/" + this.cep + "/json/";
			Integer.parseInt(this.cep);
			if (this.cep.trim().equals("") || this.cep.trim().length() != 8) {
				stubFor(get(urlEqualTo(url)).willReturn(aResponse().withStatus(400)));
			} else if (this.cep.equals("88888888") || this.cep.equals("99999999")) {
				stubFor(get(urlEqualTo(url)).willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "application/json").withBody("{\"erro\": true}")));
			} else if (this.cep.equals("01001000")) {
				stubFor(get(urlEqualTo(url))
						.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(
								"{\"cep\": \"01001-000\", \"logradouro\": \"Praca da Se\", \"complemento\": \"lado impar\", \"bairro\": \"Se\", \"localidade\": \"Sao Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\", \"gia\": \"1004\"}")));
			} else if (this.cep.equals("01311300")) {
				stubFor(get(urlEqualTo(url))
						.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(
								"{\"cep\": \"01311-300\", \"logradouro\": \"Avenida Paulista\", \"complemento\": \"de 1867 ao fim - lado impar\", \"bairro\": \"Bela Vista\", \"localidade\": \"Sao Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\", \"gia\": \"1004\"}")));
			} else if (this.cep.equals("01010000")) {
				stubFor(get(urlEqualTo(url)).willReturn(aResponse().withStatus(200)
						.withHeader("Content-Type", "application/json").withFault(Fault.EMPTY_RESPONSE)));
			}
		} catch (NumberFormatException e) {
			stubFor(get(urlEqualTo(url)).willReturn(aResponse().withStatus(400)));
		}
	}

	@When("^system sends the file with the mandatory tag \"([^\"]*)\"$")
	public void system_sends_the_file_with_the_mandatory_tag(String cep) {
		try {
			toEndereco = this.correiosService.buscaEndereco(cep);
			Mockito.verify(configuracaoDAO, Mockito.times(1)).buscaPorGrupoEChave("VIACEP", "DOMINIO");
		} catch (Exception e) {
			erroGrave = e instanceof NoHttpResponseException;
			throwable = e;
		}
	}

	@Then("^ViaCEP API returns \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void viacep_API_returns(String cep, String logradouro, String complemento, String bairro, String localidade,
			String uf, String ibge, String gia) throws Throwable {
		Mockito.verify(this.correiosDAOMock, Mockito.times(1)).salvaEndereco(toEndereco);
		WireMock.verify(1, WireMock.getRequestedFor(urlEqualTo(url)));
		assertEquals(toEndereco.getCep().replace("-", ""), cep);
		assertEquals(toEndereco.getLogradouro(), logradouro);
		assertEquals(toEndereco.getComplemento(), complemento);
		assertEquals(toEndereco.getBairro(), bairro);
		assertEquals(toEndereco.getLocalidade(), localidade);
		assertEquals(toEndereco.getUf(), uf);
		assertEquals(toEndereco.getIbge(), ibge);
		assertEquals(toEndereco.getGia(), gia);
	}

	@Then("^should show an error with a message: \"([^\"]*)\"$")
	public void should_show_an_error_with_a_message(String message) throws Throwable {
		if (erroGrave) {
			Assertions.assertThat(throwable).isNotNull().hasMessage(message);
		} else {
			Assertions.assertThat(throwable.getCause()).isNotNull().hasMessage(message);
		}
	}

	@Given("^I have an invalid zip code \"([^\"]*)\"$")
	public void i_have_an_invalid_zip_code(String cep) throws Throwable {
		this.cep = cep;
		boolean error = false;
		error = cep == null || cep.trim().equals("");
		try {
			Integer.parseInt(cep);
		} catch (NumberFormatException e) {
			error = true;
		}
		assert (error);
	}

	@Given("^I have a valid but not registered zip code \"([^\"]*)\"$")
	public void i_have_a_valid_but_not_registered_zip_code(String cep) throws Throwable {
		this.cep = cep;
		Assertions.assertThat(cep).isIn("88888888", "99999999");
	}

	@When("^system returns an empty address object$")
	public void system_returns_an_empty_address_object() throws Throwable {
		if (!erroGrave) {
			WireMock.verify(1, WireMock.getRequestedFor(urlEqualTo(url)));
		}
		Assertions.assertThat(toEndereco).isNull();
	}

	@When("^Correios API is unavailable$")
	public void Correios_API_is_unavailable() throws Throwable {
		assert (true);
	}

	public static void main(String[] args) {
		
	}

	/*
	 * @Then("exemplo") public void the_post_office_API_should_return(String
	 * result) throws Throwable {
	 * stubFor(get(urlMatching("/correio/exemploendpoint/exemploendpoint"))
	 * .withQueryParam("p", equalTo("100")) .willReturn( aResponse()
	 * .withStatus(200) .withHeader("Content-Type", "application/xml")
	 * .withBody(XmlHelper.getErrorBody(100010, "x", "mensagem")))); // o 1 Ã© a
	 * quantidade de acesso nesse endpoint WireMock.verify(1,
	 * getRequestedFor(urlMatching("/correio/exemploendpoint/exemploendpoint"))
	 * .withQueryParam("p", equalTo("100"))); }
	 */

	/**
	* @MethodName: system_sends_the_file_with_all_mandatory_tags
	* @Description: TODO
	* @author: TODO
	* @date: 2015-10-16 16:26:25 PM
	* 
	*/


}