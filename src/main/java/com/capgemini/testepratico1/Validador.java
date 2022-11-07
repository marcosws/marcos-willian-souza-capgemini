package com.capgemini.testepratico1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class Validador {
	
	
	/**
	 * Validar CEP
	 * @author Marcos
	 * @param cep
	 * @return
	 */
	public static boolean validarCEP(String cep) {
		Logger logger = LoggerFactory.getLogger(Validador.class);
		if(Strings.isNullOrEmpty(cep)) {
			logger.error("CEP não pode ser nulo ou vazio!");
			return false;
		}
		else if(!cep.replace("-", "").matches("[0-9]{8}")) {
			logger.error("Formato do CEP é inválido!");
			return false;
		}
		else {
			logger.info("Validou o CEP: " + cep);
			return true;
		}
		
	}
	
	/**
	 * Validar CPF
	 * @param cpf
	 * @return
	 */
	public static boolean validarCPF(String cpf) {
		Logger logger = LoggerFactory.getLogger(Validador.class);
		if(Strings.isNullOrEmpty(cpf)) {
			logger.error("CPF Inválido!");
			return false;
		}
		else {	
			cpf = cpf.replaceAll("[^0-9]", "");
			if((cpf.length() != 11)) {
				logger.error("CPF Inválido!");
				return false;
			}
		}
		int[] pesoMultiplicador1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		int[] pesoMultiplicador2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		int somaTotal = 0;
		int resto = 0;
		String cpfParc = cpf.substring(0, 9);
		
		for(int i = 0; i < 9; i++)
			somaTotal += Integer.parseInt(String.valueOf(cpfParc.charAt(i))) * pesoMultiplicador1[i];
			
		do {
			resto = somaTotal % 11;
			if(resto < 2)
				cpfParc += "0";
			else
				cpfParc += String.valueOf((11 - resto));
			somaTotal = 0;
			if(cpfParc.length() >= 11) break;
			for(int i = 0; i < 10; i++)
				somaTotal += Integer.parseInt(String.valueOf(cpfParc.charAt(i))) * pesoMultiplicador2[i];
		}
		while(true);
		
		if(cpfParc.substring(9).equals(cpf.substring(9))) {
			logger.info("Validou o CPF: " + cpf);
			return true;
		}
		else{
			logger.error("CPF Inválido!");
			return false; 
		}
	}
	
	public static boolean validarNome(String nome) {
		Logger logger = LoggerFactory.getLogger(Validador.class);
		if(Strings.isNullOrEmpty(nome)) {
			logger.error("Nome não pode ser nulo ou vazio!");
			return false;
		}
		else {
			logger.info("Validor o Nome: " + nome);
			return true;
		}
		
	}
	
	/**
	 * Validar Celular
	 * @param celular
	 * @return
	 */
	public static boolean validarCelular(String celular) {
		Logger logger = LoggerFactory.getLogger(Validador.class);
		if(Strings.isNullOrEmpty(celular)) {
			logger.error("Número do Celular não pode ser nulo ou vazio!");
			return false;
		}
		else if(!celular.replace("-", "").replace("(", "").replace(")", "").matches("[0-9]{2}9[0-9]{8}")) {
			logger.error("Formato do Celular é inválido!");
			return false;
		}
		else {
			logger.info("Validou o Celular: " + celular);
			return true;
		}
		
	}
	
	/**
	 * Validar E-mail
	 * @param email
	 * @return
	 */
	public static boolean validarEmail(String email) {
		Logger logger = LoggerFactory.getLogger(Validador.class);
		if(Strings.isNullOrEmpty(email)) {
			logger.error("E-mail não pode ser nulo ou vazio!");
			return false;
		}
		else if(!email.matches("([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})")) {
			logger.error("Formato do E-mail é inválido!");
			return false;
		}
		else {
			logger.info("Validou o E-mail: " + email);
			return true;
		}
	}
	
	/**
	 * Validar Modelo ou Capacidade
	 * @param modeloCapacidade
	 * @return
	 */
	public static boolean validarModeloCapacidade(String modeloCapacidade) {
		Logger logger = LoggerFactory.getLogger(Validador.class);
		if(Strings.isNullOrEmpty(modeloCapacidade)) {
			logger.error("Modelo ou Capacidade não pode ser nulo ou vazio!");
			return false;
		}
		else {
			logger.info("Validou o Nodelo ou Capacidade: " + modeloCapacidade);
			return true;
		}
	}

}
