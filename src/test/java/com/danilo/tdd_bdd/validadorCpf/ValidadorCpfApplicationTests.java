package com.danilo.tdd_bdd.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danilo.tdd_bdd.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("41992687072");
		assertEquals(true, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("41992687073");
		assertEquals(false, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("4199268707");
		assertEquals(false, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfComDigitoAMais() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419926870721");
		assertEquals(false, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926.870-72");
		assertEquals(true, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComPonto() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926.870-73");
		assertEquals(false, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419,926.870-73");
		assertEquals(false, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfValidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926.870-72 ");
		assertEquals(true, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfValidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf(" 419.926.870-72");
		assertEquals(true, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfValidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926. 870-72");
		assertEquals(true, cliente.validarCPF());		
	}

}
