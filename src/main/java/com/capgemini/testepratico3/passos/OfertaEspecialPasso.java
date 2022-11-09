package com.capgemini.testepratico3.passos;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.capgemini.massa.Produto;
import com.capgemini.massa.ProdutoDao;
import com.capgemini.testepratico3.pagina.*;

public class OfertaEspecialPasso {
	
	
	private OfertaEspecialPagina ofertaEspecialPagina = new OfertaEspecialPagina();
	private String cor = "";
	
	@Dado("que tenho acesso ao advantageonlineshopping")
	public void que_tenho_acesso_ao_advantageonlineshopping() {
		ofertaEspecialPagina.aguardarCarregamentoDaPagina();
	}

	@Quando("no menu eu clicar em Special offer")
	public void no_menu_eu_clicar_em_special_offer() throws InterruptedException {
		ofertaEspecialPagina.clicarBotaoSpecialOffer();
	}

	@Quando("clicar no botão See offer")
	public void clicar_no_botão_see_offer() throws InterruptedException {
		ofertaEspecialPagina.clicarBotaoSeeOffer();
		
	}

	@Então("valido as especificações do produto")
	public void valido_as_especificações_do_produto() throws InterruptedException {

		ProdutoDao produtoDao = new ProdutoDao();
		Map<String, String> lista = produtoDao.consultarEspecificacaoProduto();
		assertTrue(lista.equals(ofertaEspecialPagina.recuperarListaProductSpecifications()));
		
	}

	@Quando("alterar a cor do produto")
	public void alterar_a_cor_do_produto() {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultarProduto();
		cor = produto.getColor();
		
		switch(cor) {
			case "BLUE":
				ofertaEspecialPagina.selecionarCorAzul();
				break;
			case "BLACK":
				ofertaEspecialPagina.selecionarCorPreto();
				break;
			case "GRAY":
				ofertaEspecialPagina.selecionarCorCinza();
				break;
			case "PURPLE":
				ofertaEspecialPagina.selecionarCorRoxo();
				break;
			case "RED":
				ofertaEspecialPagina.selecionarCorVermelho();
				break;
			case "YELLOW":
				ofertaEspecialPagina.selecionarCorAmarelo();
				break;
			default:
				break;
		}
	}

	@Quando("clicar no botão Add to cart")
	public void clicar_no_botão_add_to_cart() {
		ofertaEspecialPagina.clicarBotaoAddToCart();
	}

	@Então("valido que o produto foi adicionado ao carrinho com a cor selecionada")
	public void valido_que_o_produto_foi_adicionado_ao_carrinho_com_a_cor_selecionada() {
		assertEquals(cor, ofertaEspecialPagina.recuperarCorNoCardDoCarrinho());
	}

	@Quando("clicar no carrinho de compras")
	public void clicar_no_carrinho_de_compras() {
		ofertaEspecialPagina.clicarNoCarrinho();
	}

	@Quando("remover produto do carrinho de compras")
	public void remover_produto_do_carrinho_de_compras() {
		ofertaEspecialPagina.clicarRemoverItemDoCarrinho();
	}

	@Então("valido que o carrinho de compras está vazio")
	public void valido_que_o_carrinho_de_compras_está_vazio() {
		assertEquals("Your shopping cart is empty", ofertaEspecialPagina.recuperarTextoLabelCarrinhoVazio());
	}

}
