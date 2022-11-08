package com.capgemini.testepratico3.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.automacao.core.Drivers;
import com.capgemini.automacao.core.PaginaBase;

public class ValidarOfertaEspecialPagina extends PaginaBase {
	
	
	public ValidarOfertaEspecialPagina() {
		PageFactory.initElements(Drivers.getDriver(), this);
	}
	
	@FindBy(tagName = "svg")
	private WebElement imagemCarregando;
	
	@FindBy(linkText = "SPECIAL OFFER")
	private WebElement botaoMenuSpecialOffer;
	
	@FindBy(id = "see_offer_btn")
	private WebElement botaoSeeOffer;
	
	
	public void clicarBotaoSpecialOffer() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElemento(botaoMenuSpecialOffer);
	}
	
	public void clicarBotaoSeeOffer() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElemento(botaoSeeOffer);
	}
	
	
	

}
