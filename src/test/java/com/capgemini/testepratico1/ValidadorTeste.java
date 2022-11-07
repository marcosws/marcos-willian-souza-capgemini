package com.capgemini.testepratico1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;

import static com.capgemini.testepratico1.Validador.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class ValidadorTeste {
	
	@Test
	public void testarValidarNomeValido() {
		assertTrue(validarNome("Marcelo Augusto Silva"));
	}
	
	@Test
	public void testarValidarNomeVazio() {
		assertFalse(validarNome(""));
	}
	
	@Test
	public void testarValidarNomeNulo() {
		assertFalse(validarNome(null));
	}
	
	@Test
	public void testarValidarCepFormatoValidoComTraco() {
		assertTrue(validarCEP("01001-000"));
	}
	
	@Test
	public void testarValidarCepFormatoValidoSemTraco() {
		assertTrue(validarCEP("01001000"));
	}
	
	@Test
	public void testarValidarCepFormatoInvalido() {
		assertFalse(validarCEP("1101001000"));
	}
	
	@Test
	public void testarValidarCepVazio() {
		assertFalse(validarCEP(""));
	}
	
	@Test
	public void testarValidarCepNulo() {
		assertFalse(validarCEP(null));
	}
	
	@Test
	public void testarValidarCpfValidoComMascara() {
		assertTrue(validarCPF("670.473.589-51"));
	}
	
	@Test
	public void testarValidarCpfValidoSemMascara() {
		assertTrue(validarCPF("67047358951"));
	}
	
	@Test
	public void testarValidarCpfInvalido() {
		assertFalse(validarCPF("67047358952"));
	}
	
	@Test
	public void testarValidarCpfVazio() {
		assertFalse(validarCPF(""));
	}
	
	@Test
	public void testarValidarCpfNulo() {
		assertFalse(validarCPF(null));
	}
	
	@Test
	public void testarValidarCelularFormatoValidoComMascara() {
		assertTrue(validarCelular("(11)98202-7072"));
	}
	
	@Test
	public void testarValidarCelularFormatoValidoSemMascara() {
		assertTrue(validarCelular("11982027072"));
	}
	
	@Test
	public void testarValidarCelularFormatoInvalido() {
		assertFalse(validarCelular("11882027072"));
	}
	
	@Test
	public void testarValidarCelularVazio() {
		assertFalse(validarCelular(""));
	}
	
	@Test
	public void testarValidarCelularNulo() {
		assertFalse(validarCelular(null));
	}
	
	@Test
	public void testarValidarEmailValido() {
		assertTrue(validarEmail("marcos@capgemini.com"));
	}
	
	@Test
	public void testarValidarEmailInvalido() {
		assertFalse(validarEmail("@capgemini.com"));
	}
	
	@Test
	public void testarValidarEmailVazio() {
		assertFalse(validarEmail(""));
	}
	
	@Test
	public void testarValidarEmailNulo() {
		assertFalse(validarEmail(null));
	}
	
	@Test
	public void testarValidarModeloCapacidadeValido() {
		assertTrue(validarModeloCapacidade("IPhone 13 Pro"));
	}
	
	@Test
	public void testarValidarModeloCapacidadeVazio() {
		assertFalse(validarModeloCapacidade(""));
	}
	
	@Test
	public void testarValidarModeloCapacidadeNulo() {
		assertFalse(validarModeloCapacidade(null));
	}

}
