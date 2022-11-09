package com.capgemini.testepratico3.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.automacao.core.Drivers;
import com.capgemini.automacao.core.PaginaBase;

public class PaginaDeCheckoutPagina extends PaginaBase {

	public PaginaDeCheckoutPagina() {
		PageFactory.initElements(Drivers.getDriver(), this);
	}
	
	@FindBy(tagName = "svg")
	private WebElement imagemCarregando;
	
	@FindBy(id="menuSearch")
	private WebElement botaoMenuSearch;
	
	@FindBy(id="autoComplete")
	private WebElement campoMenuSearch;
	
	@FindBy(css="p[class='roboto-regular ng-binding']")
	private WebElement labelProdutoPesquisado;
	
	@FindBy(css="div[class='plus'")
	private WebElement botaoAddQuantity;
	
	@FindBy(css="label[class='ng-binding']")
	private WebElement campoQuantity;
	
	@FindBy(css="h2[class='roboto-thin screen768 ng-binding']")
	private WebElement labelPriceProduct;
	
	@FindBy(css="button[name='check_out_btn']")
	private WebElement botaoCheckoutPopup;
	
	@FindBy(css="span[class='roboto-medium totalValue ng-binding']")
	private WebElement labelTotalValue;
	
	public void clicarMenuPesquizarLupa() {
		this.aguardarElementoApresentar(botaoMenuSearch, 5);
		this.clicarElemento(botaoMenuSearch);
	}
	
	public void clicarProdutoPesquisado() {
		this.espera(5);
		this.clicarElemento(labelProdutoPesquisado);
	}
	
	public void clicarCheckoutCardDoCarrinho() {
		this.aguardarElementoApresentar(botaoCheckoutPopup, 5);
		this.clicarElemento(botaoCheckoutPopup);
		this.espera(15);
	}
	
	public void digitarProdutoBarraDePesquisa(String produto) {
		this.espera(4);
		this.editarElemento(campoMenuSearch, produto);
	}
	
	public void clicarAdicionarQuantidade() {
		this.clicarElemento(botaoAddQuantity);
	}
	
	public String recuperarQuantidadeProduto() {
		return this.recuperarTextoDoElemento(campoQuantity);
	}
	
	public String recuperarPrecoDoProduto() {
		return this.recuperarTextoDoElemento(labelPriceProduct);
	}
	
	public String recuperarValorTotal() {
		return this.recuperarTextoDoElemento(labelTotalValue);
	}
	
	
}
