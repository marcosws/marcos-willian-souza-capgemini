package com.capgemini.testepratico3.passos;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.capgemini.massa.Produto;
import com.capgemini.massa.ProdutoDao;
import com.capgemini.testepratico3.pagina.OfertaEspecialPagina;
import com.capgemini.testepratico3.pagina.PaginaDeCheckoutPagina;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PaginaDeCheckoutPasso {
	
	private PaginaDeCheckoutPagina paginaDeCheckoutPagina = new PaginaDeCheckoutPagina();
	private OfertaEspecialPagina ofertaEspecialPagina = new OfertaEspecialPagina();
	private String cor;
	private int quantidade = 2;
	float precoUnitario = 0;
	
	@Quando("clicar no icone lupa")
	public void clicar_no_icone_lupa() {
		paginaDeCheckoutPagina.clicarMenuPesquizarLupa();
	}

	@Quando("digitar o produto no campo")
	public void digitar_o_produto_no_campo() {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultarProduto();
		paginaDeCheckoutPagina.digitarProdutoBarraDePesquisa(produto.getNameProduct());

	}

	@Quando("selecionar produto pesquisado")
	public void selecionar_produto_pesquisado() {
		paginaDeCheckoutPagina.clicarProdutoPesquisado();
	}
	
	@Quando("recuperar preço unitario do produto")
	public void recuperar_preço_unitario_do_produto() {
		precoUnitario = Float.parseFloat(paginaDeCheckoutPagina.recuperarPrecoDoProduto().replaceAll("[^0-9\\.0-9]+", ""));
	}

	@Quando("Alterar cor do produto")
	public void alterar_cor_do_produto() {
		
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultarProduto();
		List<String> cores = new ArrayList<String>();
		cores.addAll(Arrays.asList("BLUE", "BLACK", "GRAY", "PURPLE", "RED", "YELLOW"));
		cores.remove(produto.getColor()); // Remove a cor da lista que está no banco de dados
		cor = cores.get(Integer.parseInt(String.valueOf(Math.round(Math.random() * (cores.size() - 1))))); // retorna uma cor aleatória da lista
		
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

	@Quando("Alterar a quantidade de produto")
	public void alterar_a_quantidade_de_produto() {
		for(int i = 0; i < quantidade; i++)
			paginaDeCheckoutPagina.clicarAdicionarQuantidade();
	}
	
	@Quando("acessar pagina de checkout")
	public void acessar_pagina_de_checkout() {
		paginaDeCheckoutPagina.clicarCheckoutCardDoCarrinho();
	}

	@Então("valido que a soma dos preços corresponde ao total apresentado na pagina de checkout")
	public void valido_que_a_soma_dos_preços_corresponde_ao_total_apresentado_na_pagina_de_checkout() {
		
		int qtdProduto = Integer.parseInt(paginaDeCheckoutPagina.recuperarQuantidadeProduto().replaceAll("[^0-9]+", ""));
		float precoTotal = Float.parseFloat(paginaDeCheckoutPagina.recuperarValorTotal().replaceAll("[^0-9\\.0-9]+", ""));
		Float resultado = qtdProduto * precoUnitario;
		assertTrue(resultado.equals(precoTotal));
		
	}
	
	@Então("atualizar banco de dados com a cor selecionada")
	public void atualizar_banco_de_dados_com_a_cor_selecionada() {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultarProduto();
		Produto produtoValidar = new Produto();
		
		produto.setColor(cor);
		produtoDao.alterarCorDoProduto(produto);
		produtoValidar = produtoDao.consultarProduto();
		
		assertTrue(produtoValidar.getColor().equals(cor));
	}

}
