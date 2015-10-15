package br.unicamp.comprefacil.runner;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.tomakehurst.wiremock.WireMockServer;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "br.unicamp.comprefacil.steps",
        features = "classpath:features/CompreFacil.feature"
)

public class RunCompreFacilTest {
	
	private static WireMockServer wireMockServer;
	
	@BeforeClass
	public static void runBeforeClass() {
		wireMockServer = new WireMockServer(wireMockConfig().port(8089));
		configureFor(8089);
		wireMockServer.start();
	}
	
	@AfterClass
	public static void runAfterClass() {
		wireMockServer.stop();
	}
}
