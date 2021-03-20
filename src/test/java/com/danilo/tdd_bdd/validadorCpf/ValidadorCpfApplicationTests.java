package com.danilo.tdd_bdd.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danilo.tdd_bdd.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	@DisplayName("Dado que eu faça um teste com CPF válido")
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
	void fazendoTesteDeCpfInvalidoComCaractereEspecial() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419,926.870-73");
		assertEquals(false, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfValidoComEspaco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926.870-72 ");
		assertEquals(true, cliente.validarCPF());		
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspaco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926.870-73 ");
		assertEquals(false, cliente.validarCPF());		
	}
			
	@Test
	void fazendoTesteDeCpfInvalidoComLetra() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("419.926.i70-72");
		assertEquals(false, cliente.validarCPF());		
	}

	@Test
	void fazendoTesteComCpfMalucoQuePassou() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());		
	}

	@Test
	void fazendoTesteSemPassarCpf() {
		Cliente cliente = new Cliente();
		cliente.setNome("Natalia");		
		assertEquals(false, cliente.validarCPF());		
	}
	
}
