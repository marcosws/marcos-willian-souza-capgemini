package com.capgemini.testepratico3.suporte;

import java.util.concurrent.TimeUnit;

import com.capgemini.automacao.core.Drivers;
import com.capgemini.automacao.core.Drivers.Browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.capgemini.testepratico3.suporte.Constantes.*;


public class Hooks {
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		Drivers.setDriver(Browser.CHROME); // <= Opções de browser EDGE, CHROME, FIREFOX;
		Drivers.getDriver().manage().window().maximize();
		Drivers.getDriver().get(ADVANTAGE_ONLINE_SHOPPING);
		Drivers.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		Drivers.fecharDriver();
		
	}

}
