package com.capgemini.massa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProdutoDao {
	
	
	private Connection conexao;
	
	
	public Map<String, String> consultarEspecificacaoProduto(){
		
		this.conexao = new ConexaoMySQL().getConexao();
		Map<String, String> listaEspecificacaoProduto = new HashMap<String, String>();
		
		String SQL = "SELECT CUSTOMIZATION, DISPLAY, DISPLAY_RESOLUTION, DISPLAY_SIZE, MEMORY, OPERATING_SYSTEM, PROCESSOR, TOUCHSCREEN, WEIGHT " + 
					  "FROM massas LIMIT 1";
		
		try {
			
			PreparedStatement ptmt = this.conexao.prepareStatement(SQL);
			ResultSet resultSet = ptmt.executeQuery();
			resultSet.next();
			
			listaEspecificacaoProduto.put("CUSTOMIZATION", resultSet.getString("CUSTOMIZATION"));
			listaEspecificacaoProduto.put("DISPLAY", resultSet.getString("DISPLAY"));
			listaEspecificacaoProduto.put("DISPLAY RESOLUTION", resultSet.getString("DISPLAY_RESOLUTION"));
			listaEspecificacaoProduto.put("DISPLAY SIZE", resultSet.getString("DISPLAY_SIZE"));
			listaEspecificacaoProduto.put("MEMORY", resultSet.getString("MEMORY"));
			listaEspecificacaoProduto.put("OPERATING SYSTEM", resultSet.getString("OPERATING_SYSTEM"));
			listaEspecificacaoProduto.put("PROCESSOR", resultSet.getString("PROCESSOR"));
			listaEspecificacaoProduto.put("TOUCHSCREEN", resultSet.getString("TOUCHSCREEN"));
			listaEspecificacaoProduto.put("WEIGHT", resultSet.getString("WEIGHT"));
			
            resultSet.close();
            this.conexao.close();
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEspecificacaoProduto;
		
	}
	
	public Produto consultarProduto(){
		
		this.conexao = new ConexaoMySQL().getConexao();
		Produto produto = new Produto();
		
		String SQL = "SELECT IDMASSAS, NAME_PRODUCT, CUSTOMIZATION, DISPLAY, DISPLAY_RESOLUTION, DISPLAY_SIZE, MEMORY, OPERATING_SYSTEM, PROCESSOR, TOUCHSCREEN, WEIGHT, COLOR " + 
					  "FROM massas LIMIT 1";
		
		try {
			
			PreparedStatement ptmt = this.conexao.prepareStatement(SQL);
			ResultSet resultSet = ptmt.executeQuery();
			resultSet.next();
			produto.setIdMassas(resultSet.getInt("IDMASSAS"));
			produto.setNameProduct(resultSet.getString("NAME_PRODUCT"));
			produto.setCustomization(resultSet.getString("CUSTOMIZATION"));
			produto.setDisplay(resultSet.getString("DISPLAY"));
			produto.setDisplayResolution(resultSet.getString("DISPLAY_RESOLUTION"));
			produto.setDisplaySize(resultSet.getString("DISPLAY_SIZE"));
			produto.setMemory(resultSet.getString("MEMORY"));
			produto.setOperatingSystem(resultSet.getString("OPERATING_SYSTEM"));
			produto.setProcessor(resultSet.getString("PROCESSOR"));
			produto.setTouchscreen(resultSet.getString("TOUCHSCREEN"));
			produto.setWeight(resultSet.getString("WEIGHT"));
			produto.setColor(resultSet.getString("COLOR"));
			
            resultSet.close();
            this.conexao.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
		
	}
	
	public void alterarCorDoProduto(Produto produto) {
		
		this.conexao = new ConexaoMySQL().getConexao();
		
		String SQL = "UPDATE massas SET COLOR=? WHERE IDMASSAS=?;";

		try {
			
			PreparedStatement stmt = conexao.prepareStatement(SQL);	
	        stmt.setString(1, produto.getColor());
	        stmt.setInt(2, produto.getIdMassas());
	        stmt.execute();
	        stmt.close();	
	        this.conexao.close();
	        
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
