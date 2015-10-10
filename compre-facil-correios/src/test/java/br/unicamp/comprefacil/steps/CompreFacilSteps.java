package br.unicamp.comprefacil.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import br.unicamp.comprefacil.bo.CorreiosBO;
import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EnderecoTO;
import br.unicamp.comprefacil.to.EntregaTO;
import cucumber.api.PendingException;
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
    
    // TODO: seguir esses caras
    
    @Given("^Items <Wheight> <Width> <Height> <Length>$")
    public void items_Wheight_Width_Height_Length() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User press button to calculate$")
    public void user_press_button_to_calculate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system connects to Correios API$")
    public void system_connects_to_Correios_API() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system sends the file with all mandatory tags   (\\d+) (\\d+)-(\\d+)$")
    public void system_sends_the_file_with_all_mandatory_tags(int arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^(\\d+)-(\\d+) (\\d+) (\\d+) (\\d+)$")
    public void (int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^(\\d+) (\\d+) (\\d+) N (\\d+) N$")
    public void n_N(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^system connects to Correios API$")
    public void system_connects_to_Correios_API() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^correios API returns (\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+)$")
    public void correios_API_returns(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^User types the (\\d+)$")
    public void user_types_the(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^System provides (\\d+)$")
    public void system_provides(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^System connects to Correios API$")
    public void system_connects_to_Correios_API() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Correios API returns (\\d+) (\\d+) S S$")
    public void correios_API_returns_S_S(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system sends the file with all mandatory tags  $")
    public void system_sends_the_file_with_all_mandatory_tags() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^(\\d+) (\\d+)-(\\d+) (\\d+)-(\\d+) (\\d+) (\\d+) (\\d+)$")
    public void (int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Correios API returns (\\d+),(\\d+) and (\\d+)$")
    public void correios_API_returns_and(int arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have a valid and registered zip code (\\d+)$")
    public void i_have_a_valid_and_registered_zip_code(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system sends the file with the mandatory tag (\\d+)$")
    public void system_sends_the_file_with_the_mandatory_tag(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Correios API returns (\\d+) Pra�a da S� lado �mpar S� S�o Paulo SP (\\d+) (\\d+)$")
    public void correios_API_returns_Pra_a_da_S_lado_mpar_S_S_o_Paulo_SP(int arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Correios API returns (\\d+) Avenida Paulista de (\\d+) ao fim - lado �mpar Bela Vista S�o Paulo SP (\\d+) (\\d+)$")
    public void correios_API_returns_Avenida_Paulista_de_ao_fim_lado_mpar_Bela_Vista_S_o_Paulo_SP(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Correios API returns (\\d+) Rua Anita Garibaldi  Copacabana Rio de Janeiro RJ (\\d+) $")
    public void correios_API_returns_Rua_Anita_Garibaldi_Copacabana_Rio_de_Janeiro_RJ(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I do not have a zip code <cep>$")
    public void i_do_not_have_a_zip_code_cep() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^should show an error with a message:$")
    public void should_show_an_error_with_a_message(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have an invalid zip code <cep>$")
    public void i_have_an_invalid_zip_code_cep() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have a valid but not registered zip code <cep>$")
    public void i_have_a_valid_but_not_registered_zip_code_cep() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system sends the file with the mandatory tag <cep>$")
    public void system_sends_the_file_with_the_mandatory_tag_cep() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^system returns an empty address object$")
    public void system_returns_an_empty_address_object() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    

}
