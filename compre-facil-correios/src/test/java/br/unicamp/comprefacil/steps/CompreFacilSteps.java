package br.unicamp.comprefacil.steps;

import br.unicamp.comprefacil.to.DadosEntregaCorreiosTO;
import br.unicamp.comprefacil.to.EntregaTO;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.assertj.core.api.Assertions;


import br.unicamp.exemplo.Calculadora;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompreFacilSteps {
	private Calculadora calculadora;
    private Throwable throwable;
    private EntregaTO entrega;
    private DadosEntregaCorreiosTO dadosEntrega;
    private boolean btCalcFrete;

    @Before
    public void setUp() {
    	entrega = new EntregaTO();
    	throwable = null;
    }
    
    @Given ("User types the CEP for the deliverable address")
    public void user_types_CEP() throws Throwable {
        assertNotNull(entrega.getsCepDestino());
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

}
