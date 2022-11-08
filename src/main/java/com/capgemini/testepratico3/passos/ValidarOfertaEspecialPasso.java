package com.capgemini.testepratico3.passos;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import com.capgemini.testepratico3.pagina.*;

public class ValidarOfertaEspecialPasso {
	
	AdvantageHomePagina advantageHomePagina = new AdvantageHomePagina();
	ValidarOfertaEspecialPagina validarOfertaEspecialPagina = new ValidarOfertaEspecialPagina();
	
	@Dado("que tenho acesso ao advantageonlineshopping")
	public void que_tenho_acesso_ao_advantageonlineshopping() {
		advantageHomePagina.aguardarCarregamentoDaPagina();
	}

	@Quando("no menu eu clicar em Special offer")
	public void no_menu_eu_clicar_em_special_offer() throws InterruptedException {
		validarOfertaEspecialPagina.clicarBotaoSpecialOffer();
	}

	@Quando("clicar no botão See offer")
	public void clicar_no_botão_see_offer() throws InterruptedException {
		validarOfertaEspecialPagina.clicarBotaoSeeOffer();
		Thread.sleep(7000);
	}

	@Então("valido as especificações do produto")
	public void valido_as_especificações_do_produto() {

	}

	@Quando("alterar a cor do produto")
	public void alterar_a_cor_do_produto() {

	}

	@Quando("clicar no botão Add to cart")
	public void clicar_no_botão_add_to_cart() {

	}

	@Então("valido que o produto foi adicionado ao carrinho com a cor selecionada")
	public void valido_que_o_produto_foi_adicionado_ao_carrinho_com_a_cor_selecionada() {

	}

	@Quando("clicar no carrinho de compras")
	public void clicar_no_carrinho_de_compras() {

	}

	@Quando("remover produto do carrinho de compras")
	public void remover_produto_do_carrinho_de_compras() {

	}

	@Então("valido que o carrinho de compras está vazio")
	public void valido_que_o_carrinho_de_compras_está_vazio() {

	}

}
