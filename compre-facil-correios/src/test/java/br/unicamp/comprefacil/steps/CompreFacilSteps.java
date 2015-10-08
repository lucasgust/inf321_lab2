package br.unicamp.comprefacil.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import br.unicamp.comprefacil.bo.CorreiosBO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompreFacilSteps {
    private CorreiosBO boCorreios;
	private Throwable throwable;
    private EntregaTO entrega;
    private DadosEntregaCorreiosTO dadosEntrega;
    private boolean btCalcFrete;
    private String cep;
    private EnderecoTO toEndereco;

    @Before
    public void setUp() {
    	boCorreios = new CorreiosBO();
    	throwable = null;
    	entrega = new EntregaTO();
    	cep = null;
    	toEndereco = null;
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
    
    @Given ("^Given I have a valid and registered zip code <cep>$")
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    @When("^I press button to search$")
    public void i_press_button() throws Throwable {
		toEndereco = boCorreios.validarCEP(cep);
    }
    
    @Then("^Then Correios API returns (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+)$")
    public void the_result_should_be(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, long ibge, int gia) throws Throwable {
    	assertEquals(toEndereco.getCep(), cep);
    	assertEquals(toEndereco.getLogradouro(), logradouro);
    	assertEquals(toEndereco.getComplemento(), complemento);
    	assertEquals(toEndereco.getBairro(), bairro);
    	assertEquals(toEndereco.getLocalidade(), localidade);
    	assertEquals(toEndereco.getUf(), uf);
    	assertEquals(toEndereco.getIbge(), ibge);
    	assertEquals(toEndereco.getGia(), gia);
    }

}
