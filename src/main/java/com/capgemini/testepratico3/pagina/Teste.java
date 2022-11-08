package com.capgemini.testepratico3.pagina;

import static com.capgemini.testepratico3.suporte.Constantes.ADVANTAGE_ONLINE_SHOPPING;

import java.util.concurrent.TimeUnit;

import com.capgemini.automacao.core.Drivers;
import com.capgemini.automacao.core.Drivers.Browser;

public class Teste {

	public static void main(String[] args) throws InterruptedException {


		Drivers.setDriver(Browser.CHROME); // <= Opções de browser EDGE, CHROME, FIREFOX;
		Drivers.getDriver().manage().window().maximize();
		Drivers.getDriver().get(ADVANTAGE_ONLINE_SHOPPING);
		Drivers.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		Thread.sleep(15000);
		Drivers.fecharDriver();

	}

}
