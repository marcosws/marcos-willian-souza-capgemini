package com.capgemini.testepratico3.pagina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.automacao.core.Drivers;
import com.capgemini.automacao.core.PaginaBase;

public class OfertaEspecialPagina extends PaginaBase {
	
	
	public OfertaEspecialPagina() {
		PageFactory.initElements(Drivers.getDriver(), this);
	}
	
	@FindBy(tagName = "svg")
	private WebElement imagemCarregando;
	
	@FindBy(linkText = "SPECIAL OFFER")
	private WebElement botaoMenuSpecialOffer;
	
	@FindBy(id = "see_offer_btn")
	private WebElement botaoSeeOffer;
	
	@FindBy(name = "save_to_cart")
	private WebElement botaoAddToCart;
	
	@FindBy(css="label[class='attr ng-binding']")
	private List<WebElement> labelsProductSpecificationsAttr;
	
	@FindBy(css="label[class='attr ng-binding'] + Label")
	private List<WebElement> labelsProductSpecificationsValue;
	
	@FindBy(css="span[title='BLUE']")
	private WebElement seletorCorBlue;
	
	@FindBy(css="span[title='BLACK']")
	private WebElement seletorCorBlack;
	
	@FindBy(css="span[title='GRAY']")
	private WebElement seletorCorGray;
	
	@FindBy(css="span[title='PURPLE']")
	private WebElement seletorCorPurple;
	
	@FindBy(css="span[title='RED']")
	private WebElement seletorCorRed;
	
	@FindBy(css="span[title='YELLOW']")
	private WebElement seletorCorYellow;
	
	@FindBy(css="h3[class='ng-binding']")
	private WebElement labelCartProductName;
	
	@FindBy(css="label[class='ng-binding']")
	private WebElement labelCartQty;
	
	@FindBy(css="span[class='ng-binding']")
	private WebElement labelCartColor;  
	
	@FindBy(id="menuCart")
	private WebElement botaoMenuCart;
	
	@FindBy(linkText="REMOVE")
	private WebElement botaoRemove;
	
	@FindBy(css="label[class='roboto-bold ng-scope']")
	private WebElement labelYourShoppingCartIsEmpty;
	
	public void verificarCarregamentoDaPagina() {
		this.aguardarCarregamentoDaPagina();
	}
	
	public void clicarBotaoSpecialOffer() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElemento(botaoMenuSpecialOffer);
	}
	
	public void clicarBotaoSeeOffer() {
		this.aguardarElementoApresentar(botaoSeeOffer, 10);
		this.clicarElemento(botaoSeeOffer);
	}
	
	public void clicarBotaoAddToCart() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElemento(botaoAddToCart);
	}
	
	public Map<String, String> recuperarListaProductSpecifications() {
		
		this.aguardarElementoOcultar(imagemCarregando, 10);
		
		Map<String, String> lista = new HashMap<String, String>();
		
		for(int i = 0; i < labelsProductSpecificationsAttr.size(); i++) {
			lista.put(labelsProductSpecificationsAttr.get(i).getText(), labelsProductSpecificationsValue.get(i).getText());
			System.out.printf("		- Recuperando a Lista Product Specifications Atributo: [%s], Valor: [%s]\n",labelsProductSpecificationsAttr.get(i).getText(), labelsProductSpecificationsValue.get(i).getText());
		}
		return lista;
	}
	
	public void selecionarCorAzul() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElementoViaJS(seletorCorBlue);
	}
	
	public void selecionarCorPreto() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElementoViaJS(seletorCorBlack);
	}
	
	public void selecionarCorCinza() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElementoViaJS(seletorCorGray);
	}
	
	public void selecionarCorRoxo() {
		this.aguardarElementoOcultar(imagemCarregando, 15);
		this.clicarElementoViaJS(seletorCorPurple);
	}
	
	public void selecionarCorVermelho() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElementoViaJS(seletorCorRed);
	}
	
	public void selecionarCorAmarelo() {
		this.aguardarElementoOcultar(imagemCarregando, 10);
		this.clicarElementoViaJS(seletorCorYellow);
	}
	
	public String recuperarNomeDoProdutoNoCardDoCarrinho() {
		this.aguardarElementoApresentar(labelCartProductName, 3);
		return this.recuperarTextoDoElemento(labelCartProductName);
	}
	
	public String recuperarQuantidadeNoCardDoCarrinho() {
		this.aguardarElementoApresentar(labelCartQty, 3);
		return this.recuperarTextoDoElemento(labelCartQty);
	}
	
	public String recuperarCorNoCardDoCarrinho() {
		this.aguardarElementoApresentar(labelCartColor, 3);
		return this.recuperarTextoDoElemento(labelCartColor);
	}
	
	public void clicarNoCarrinho() {
		this.aguardarElementoOcultar(labelCartProductName, 10);
		this.clicarElemento(botaoMenuCart);
	}
	
	public void clicarRemoverItemDoCarrinho() {
		this.aguardarElementoOcultar(labelCartProductName, 10);
		this.clicarElemento(botaoRemove);
	}
	
	public String recuperarTextoLabelCarrinhoVazio() {
		this.aguardarElementoApresentar(labelYourShoppingCartIsEmpty, 5);
		return this.recuperarTextoDoElemento(labelYourShoppingCartIsEmpty);
	}
	
	
	

}
