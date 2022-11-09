#language: pt
#Author: marcosws@ymail.com - Marcos Willian de Souza

@global
Funcionalidade: Validar oferta especial
 
  Contexto: Acessar a oferta especial atravez do botão See offer
    Dado que tenho acesso ao advantageonlineshopping
    Quando no menu eu clicar em Special offer
    E clicar no botão See offer
    

	@Cenario01
	Esquema do Cenário: Validar especificações do produto
		Então valido as especificações do produto
		
		
	@Cenario02
	Esquema do Cenário: Validar alteração de cor do produto no carrinho
	  E alterar a cor do produto
	  E clicar no botão Add to cart
		Então valido que o produto foi adicionado ao carrinho com a cor selecionada
		
	@Cenario04
	Esquema do Cenário: Remover produto do carrinho de compras
		E clicar no botão Add to cart
		E clicar no carrinho de compras
		E remover produto do carrinho de compras
		Então valido que o carrinho de compras está vazio