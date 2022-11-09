package com.capgemini.automacao.core;

import static org.junit.Assert.fail;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBase {
	
	
	protected void clicarElemento(WebElement elemento) {
		try {
			elemento.click();
		}
		catch(NoSuchElementException e) {
			System.err.println("Elemento não encontrado");
			e.printStackTrace();
			fail();
		}
		catch(ElementNotInteractableException e) {
			System.err.println("Elemento não é clicavel (Verifique se o elemento não está oculto)");
			e.printStackTrace();
			fail();
		}
		catch(Exception e) {
			System.err.println("Não foi possivel clicar no elemento");
			e.printStackTrace();
			fail();
		}
	}
	
	protected void clicarElementoViaJS(WebElement elemento) {
		this.executarJavaScript("arguments[0].click();", elemento);
	}
	
	protected String recuperarTextoDoElemento(WebElement elemento) {
		try {
			return elemento.getText();
		}
		catch(NoSuchElementException e) {
			System.err.println("Elemento não encontrado");
			e.printStackTrace();
			fail();
		}
		catch(Exception e) {
			System.err.println("Não foi possivel recuperar o texto no elemento");
			e.printStackTrace();
			fail();
		}
		return "";
	}
	
	protected void editarElemento(WebElement elemento, String texto) {
		try {
			elemento.sendKeys(texto);
		}		
		catch(NoSuchElementException e) {
			System.err.println("Elemento não encontrado");
			e.printStackTrace();
			fail();
		}
		catch(ElementNotInteractableException e) {
			System.err.println("Elemento não é editavel (Verifique se o elemento não está oculto)");
			e.printStackTrace();
			fail();
		}
		catch(Exception e) {
			System.err.println("Não foi possivel editar/digitar texto no elemento");
			e.printStackTrace();
			fail();
		}
	}
	
	protected boolean aguardarElementoApresentar(WebElement elemento, int tempoSegundos) {
		
		int segundos = 0;
		boolean visivel = false;
		do {
			segundos++;
			espera(1);
			if(segundos > tempoSegundos) break;
			try {
				visivel = elemento.isDisplayed();
			}
			catch(StaleElementReferenceException e) {}
		}
		while(!visivel);
		return visivel;
		
	}
	protected boolean aguardarElementoOcultar(WebElement elemento, int tempoSegundos) {
		
		int segundos = 0;
		boolean visivel = false;
		aguardarElementoApresentar(elemento, 5);
		do {
			segundos++;
			espera(1);
			if(segundos > tempoSegundos) break;
			try {
				visivel = elemento.isDisplayed();
			}
			catch(StaleElementReferenceException e) {}
		}
		while(visivel);
		return !visivel;
		
	}
	
	protected void espera(int segundos) {
		
		for(int i = 0; i < segundos; i++) {
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {}
		}
		
	}
	
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
	
	protected void executarJavaScript(String script, WebElement webElement) {
		
		WebDriver driver = Drivers.getDriver();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript(script, webElement);
		
	}

}
