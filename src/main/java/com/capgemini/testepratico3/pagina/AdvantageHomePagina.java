package com.capgemini.testepratico3.pagina;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.automacao.core.Drivers;

public class AdvantageHomePagina {
	
	public boolean aguardarCarregamentoDaPagina() {
		WebDriver driver = Drivers.getDriver();
		return new WebDriverWait(driver, 30).until(input ->{
			boolean resultado = false;
			String status = "";
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				status = js.executeScript("return document.readyState;").toString();
				resultado = status.equals("complete");
			}
			catch(Exception ignore) {}
			return resultado;
		});
	}

}
