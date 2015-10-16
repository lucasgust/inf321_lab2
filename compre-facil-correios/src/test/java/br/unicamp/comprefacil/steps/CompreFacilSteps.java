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

import com.github.tomakehurst.wiremock.admin.GetRequestCountTask;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;

import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.dao.DadosDeEntregaDAO;
import br.unicamp.comprefacil.service.CorreiosService;
import br.unicamp.comprefacil.service.impl.CorreiosServiceImpl;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompreFacilSteps {
	
	private CorreiosService correiosService;
	private EnderecoTO toEndereco;
	private EntregaTO entrega;
	
	private CorreiosDAO correiosDAOMock;
	private DadosDeEntregaDAO dadosDeEntregaMock;
	
	private String cep;
	private Throwable throwable;
	
	private String url;
	
	private Boolean todosItensDefinidos;
	private Boolean prontoParaBusca;
	private Boolean temCampoInvalido;
	private Boolean erroGrave;
	
//	@Rule
//	public WireMockRule wireMockRule = new WireMockRule();
	
    @Before
    public void setUp() {
    	correiosDAOMock = Mockito.mock(CorreiosDAO.class);
    	dadosDeEntregaMock = Mockito.mock(DadosDeEntregaDAO.class);
    	
    	correiosService = new CorreiosServiceImpl();
    	correiosService.setCorreiosDAO(correiosDAOMock);
    	correiosService.setDadosDeEntregaDAO(dadosDeEntregaMock);
    	
    	throwable = null;
    	todosItensDefinidos = prontoParaBusca = temCampoInvalido = false;
    	entrega = new EntregaTO();
    }

    @Given("^All items from sales order are settled$")
    public void all_items_from_sales_order_are_settled() throws Throwable {
    	todosItensDefinidos = true;
    }

    @Given("^User types \"([^\"]*)\"$")
    public void user_types(String sCepDestino) throws Throwable {
    	entrega.setsCepDestino(sCepDestino);
    }

    @When("^User press button to calculate freight$")
    public void user_press_button_to_calculate_freight() throws Throwable {
    	prontoParaBusca = true;
    }

    @When("^system connects to Correios API$")
    public void system_connects_to_Correios_API() throws Throwable {
        assertNotNull(correiosService);
    }

    @When("^system sends the file with all mandatory tags \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) \"([^\"]*)\" (\\d+) \"([^\"]*)\"$") 
    public void system_sends_the_file_with_all_mandatory_tags(String nCdEmpresa, String sDsSenha,
    		String nCdServico, String sCepOrigem, int nVlPeso, int nCdFormato, int nVlComprimento,
    		int nVlAltura, int nVlLargura, int nVlDiametro, String sCdMaoPropria,
    		int nVlValorDeclarado, String sCdAvisoRecebimento) throws Throwable {
    	this.entrega.setnCdEmpresa(nCdEmpresa);
    	this.entrega.setsDsSenha(sDsSenha);
    	this.entrega.setnCdServico(nCdServico);
    	this.entrega.setsCepOrigem(sCepOrigem);
    	this.entrega.setnVlPeso(nVlPeso);
    	this.entrega.setnCdFormato(nCdFormato);
    	this.entrega.setnVlComprimento(nVlComprimento);
    	this.entrega.setnVlAltura(nVlAltura);
    	this.entrega.setnVlLargura(nVlLargura);
    	this.entrega.setnVlDiametro(nVlDiametro);
    	this.entrega.setsCdMaoPropria(sCdMaoPropria);
    	this.entrega.setnVlValorDeclarado(nVlValorDeclarado);
    	this.entrega.setsCdAvisoRecebimento(sCdAvisoRecebimento);
    }

	@Then("^correios API returns \"([^\"]*)\" (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void correios_API_returns(String sCodigo, double sValor,
			int sPrazoEntrega, double sValorMaoPropria,
			double sValorAvisoRecebimento, double sValorDeclarado,
			String sEntregaDomiciliar, String sEntregaSabado, String sErro,
			String sMsgErro) throws Throwable {
		Assert.assertTrue(todosItensDefinidos);
		Assert.assertTrue(prontoParaBusca);
		Assert.assertNotNull(entrega);

		if (temCampoInvalido) {
			Assert.assertNotNull(sErro);
			Assert.assertNotNull(sMsgErro);

		} else {
			Assert.assertNull(sErro);
			Assert.assertNull(sMsgErro);
		}
	}
	
	/**
	 * 
	 * @param sPrazoEntrega
	 * @param sValor
	 * @throws Throwable
	 * 
	 * Adicionei este step para realizar o Mock de salvar os dados
	 * creio que talvez seja necessário add algum assertThat
	 */
	@Then("^save data in database (\\d+) (\\d+)$")
	public void save_data_in_database(int sPrazoEntrega, double sValor) throws Throwable {
		
		DadosEntregaCorreiosTO dadosEntregaTO = new DadosEntregaCorreiosTO();
		dadosEntregaTO.setPrazo(sPrazoEntrega);
		dadosEntregaTO.setValor(sValor);
		dadosDeEntregaMock.salvaDadosDeEntrega(dadosEntregaTO);
	}
	
    @Given("^at least one field is not valid$")
    public void at_least_one_field_is_not_valid() throws Throwable {
    	temCampoInvalido = true;
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
    			stubFor(get(urlEqualTo(url))
    					.willReturn(aResponse()
    							.withStatus(400)));
    		} else if (this.cep.equals("88888888") || this.cep.equals("99999999")) {
    			stubFor(get(urlEqualTo(url))
    					.willReturn(aResponse()
    							.withStatus(200)
        						.withHeader("Content-Type", "application/json")
        						.withBody("{\"erro\": true}")));
    		} else if (this.cep.equals("01001000")) {
    			stubFor(get(urlEqualTo(url))
    					.willReturn(aResponse()
    							.withStatus(200)
        						.withHeader("Content-Type", "application/json")
        						.withBody("{\"cep\": \"01001-000\", \"logradouro\": \"Praca da Se\", \"complemento\": \"lado impar\", \"bairro\": \"Se\", \"localidade\": \"Sao Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\", \"gia\": \"1004\"}")));
    		} else if (this.cep.equals("01311300")) {
    			stubFor(get(urlEqualTo(url))
    					.willReturn(aResponse()
    							.withStatus(200)
        						.withHeader("Content-Type", "application/json")
        						.withBody("{\"cep\": \"01311-300\", \"logradouro\": \"Avenida Paulista\", \"complemento\": \"de 1867 ao fim - lado impar\", \"bairro\": \"Bela Vista\", \"localidade\": \"Sao Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\", \"gia\": \"1004\"}")));
    		} else if (this.cep.equals("01010000")) {
    			stubFor(get(urlEqualTo(url))
    					.willReturn(aResponse()
    							.withStatus(200)
        						.withHeader("Content-Type", "application/json")
        						.withFault(Fault.EMPTY_RESPONSE)));
    		}
    	} catch (NumberFormatException e) {
    		stubFor(get(urlEqualTo(url))
					.willReturn(aResponse()
							.withStatus(400)));
    	}
    }

    @When("^system sends the file with the mandatory tag \"([^\"]*)\"$")
    public void system_sends_the_file_with_the_mandatory_tag(String cep) {
    	try {
        	toEndereco = this.correiosService.buscaEndereco(cep);
    	} catch (Exception e) {
    		erroGrave = e instanceof NoHttpResponseException;
    		throwable = e;
    	}
    }

    @Then("^ViaCEP API returns \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void viacep_API_returns(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge, String gia) throws Throwable {
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
    	assert(error);
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
    	assert(true);
    }

    /*
    @Then("exemplo")
    public void the_post_office_API_should_return(String result) throws Throwable {
    	stubFor(get(urlMatching("/correio/exemploendpoint/exemploendpoint"))
    			.withQueryParam("p", equalTo("100"))
    				.willReturn(
    					aResponse()
    					.withStatus(200)
    					.withHeader("Content-Type", "application/xml")
    					.withBody(XmlHelper.getErrorBody(100010, "x", "mensagem"))));
    	// o 1 Ã© a quantidade de acesso nesse endpoint
    	WireMock.verify(1, getRequestedFor(urlMatching("/correio/exemploendpoint/exemploendpoint"))
    			.withQueryParam("p", equalTo("100")));
    }
    */
    
}
