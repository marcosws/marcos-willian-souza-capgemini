package com.capgemini.massa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	
	public Connection getConexao() {
		
		String nomeBancoDeDados = "banco_teste_automacao";
		String usuarioBancoDeDados = "root";
		String senhaBancoDeDados = "adm64msql";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeBancoDeDados, usuarioBancoDeDados, senhaBancoDeDados);
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		
	}

}
