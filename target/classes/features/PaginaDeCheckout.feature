#language: pt
#Author: marcosws@ymail.com - Marcos Willian de Souza

@global
Funcionalidade: Validar pagina de checkout

	@Cenario03
	Cenário: Validar pagina de checkout alterando a cor do produto
		Dado que tenho acesso ao advantageonlineshopping
		Quando clicar no icone lupa
		E digitar o produto no campo 
		E selecionar produto pesquisado
		E recuperar preço unitario do produto
		E Alterar cor do produto
		E Alterar a quantidade de produto
		E clicar no botão Add to cart
		E acessar pagina de checkout
		Então valido que a soma dos preços corresponde ao total apresentado na pagina de checkout
		E atualizar banco de dados com a cor selecionada



