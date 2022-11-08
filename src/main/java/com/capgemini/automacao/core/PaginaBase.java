package com.capgemini.automacao.core;

import org.openqa.selenium.WebElement;

public class PaginaBase {
	
	
	protected void clicarElemento(WebElement elemento) {
		elemento.click();
	}
	
	protected boolean aguardarElementoApresentar(WebElement elemento, int tempoSegundos) {
		
		int segundos = 0;
		boolean visivel = false;
		do {
			segundos++;
			System.out.println("[" + segundos + " Segundo(s)] Aguardando elemento apresentar ...");
			espera(1);
			if(segundos > tempoSegundos) break;
			visivel = elemento.isDisplayed();
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
			System.out.println("[" + segundos + " Segundo(s)] Aguardando elemento ocultar ...");
			espera(1);
			if(segundos > tempoSegundos) break;
			visivel = elemento.isDisplayed();
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

}
