package br.unicamp.comprefacil.steps;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.assertj.core.api.Assertions;

import br.unicamp.comprefacil.bo.CorreiosBO;
import br.unicamp.comprefacil.dao.CorreiosDAO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.exemplo.CompreFacil;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompreFacilSteps {
	
	DadosEntregaCorreiosTO dadosEntrega;
	CorreiosBO boCorreios;
	String cep;
	
	private CompreFacil compreFacil;
	private Throwable throwable;
	private CorreiosDAO mock;
	private EnderecoTO toEndereco;
	
    @Before
    public void setUp() {
    	mock = mock(CorreiosDAO.class);
    	compreFacil = new CompreFacil(mock);
    	throwable = null;
    }
    
    @When("User press button to calculate freight cost and time")
    public void user_press_button_calculate_freight_time(boolean btCalcFrete) throws Throwable {
    	assertEquals(btCalcFrete == true, btCalcFrete);    	
    }
    
    @Then("Send XML for integrating with Correios API")
    public void send_XML_to_correios_api(int result) throws Throwable {
    	//System should send the required info for integrating with Correios API
    	//XML
    }
    
    @Then("Receive XML from Correios API")
    public void receive_XML_to_correios_api(int result) throws Throwable {
    	//System Should return correct date and price of deliver presented by the API
    	//XML
    	dadosEntrega = new DadosEntregaCorreiosTO();
    }
    
    @Then("Calculated Freight Cost (\\d+) and delivery time (\\d+)")
    public void print_freight_time(double price, int deadline ) throws Throwable {
    	assertNotNull(dadosEntrega);
    	System.out.println("Freight Cost % and lead time %");
    }
    
    @Given("^All items from sales order are settled$")
    public void all_items_from_sales_order_are_settled() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^User types \"([^\"]*)\"$")
    public void user_types(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User press button to calculate freight$")
    public void user_press_button_to_calculate_freight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system connects to Correios API$")
    public void system_connects_to_Correios_API() throws Throwable {
        assertNotNull(mock);
    }

    @When("^system sends the file with all mandatory tags \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) \"([^\"]*)\" (\\d+) \"([^\"]*)\"$")
    public void system_sends_the_file_with_all_mandatory_tags(String arg1, String arg2, String arg3, String arg4, String arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, String arg12, int arg13, String arg14) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^correios API returns \"([^\"]*)\" (\\d+),(\\d+) (\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void correios_API_returns(String arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, String arg11, String arg12, String arg13, String arg14) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^at least one field is not valid$")
    public void at_least_one_field_is_not_valid() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have a valid and registered zip code \"([^\"]*)\"$")
    public void i_have_a_valid_and_registered_zip_code(String arg1) throws Throwable {
    	boolean result = false;
    	try {
    		Integer.parseInt(arg1);
    		result = true;
    	} catch (NumberFormatException e) { }
    	assertEquals(true, result);
    }
    
    @When("^I press button to search$")
    public void i_press_button_to_search() throws Throwable {
    	try {
    		stubFor(get(urlEqualTo("/viacep/ws/01001000/json/"))
    				.willReturn(aResponse()
    						.withHeader("Content-Type", "text/plain")
    						.withBody("{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\", \"complemento\": \"lado ímpar\", \"bairro\": \"Sé\", \"localidade\": \"São Paulo\", \"uf\": \"SP\", \"ibge\": \"3550308\"}")));
    		assert(true);
    	} catch (Throwable e) {
    		throwable = e;
    	}
    }

    @When("^system sends the file with the mandatory tag \"([^\"]*)\"$")
    public void system_sends_the_file_with_the_mandatory_tag(String arg1) throws Throwable {
    	toEndereco = mock.buscarEndereco(arg1);
    	assert(true);
    }

    @Then("^ViaCEP API returns \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+)$")
    public void viacep_API_returns(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, int arg8) throws Throwable {
    	assertEquals(toEndereco.getCep(), arg1);
    	assertEquals(toEndereco.getLogradouro(), arg2);
    	assertEquals(toEndereco.getComplemento(), arg3);
    	assertEquals(toEndereco.getBairro(), arg4);
    	assertEquals(toEndereco.getLocalidade(), arg5);
    	assertEquals(toEndereco.getUf(), arg6);
    	assertEquals(toEndereco.getIbge(), arg7);
    	assertEquals(toEndereco.getGia(), arg8);
    }

    @Given("^I do not have a zip code$")
    public void i_do_not_have_a_zip_code(String arg1) throws Throwable {
    	Assertions.assertThat(arg1).isNullOrEmpty();
    }

    @Then("^should show an error with a message: \"([^\"]*)\"$")
    public void should_show_an_error_with_a_message(String arg1) throws Throwable {
    	Assertions.assertThat(throwable).isNotNull().hasMessage(arg1);
    }

    @Given("^I have an invalid zip code \"([^\"]*)\"$")
    public void i_have_an_invalid_zip_code(String arg1) throws Throwable {
    	boolean result = false;
    	try {
    		Integer.parseInt(arg1);
    		result = true;
    	} catch (NumberFormatException e) { }
    	assertEquals(false, result);
    }

    @Given("^I have a valid but not registered zip code \"([^\"]*)\"$")
    public void i_have_a_valid_but_not_registered_zip_code(String arg1) throws Throwable {
    	Assertions.assertThat(arg1).isIn("00000000", "99999999");
    }

    @When("^system returns an empty address object$")
    public void system_returns_an_empty_address_object() throws Throwable {
    	Assertions.assertThat(toEndereco).isNull();
    }
}
