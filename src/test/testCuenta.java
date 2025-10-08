package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class testCuenta {

	private static Cuenta cuenta;

	private static Cuenta cuenta12345;

	private static Cuenta cuenta67890;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cuenta = new Cuenta(0.0);
		cuenta12345 = new Cuenta(50.0);
		cuenta67890 = new Cuenta(0.0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta.setSaldo(0.0);
		cuenta12345.setSaldo(0.0);
		cuenta67890.setSaldo(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		cuenta.ingresar(200.0);
		assertEquals(200, cuenta.getSaldo());
	}

	@Test
	void testRetirar() {
		cuenta.retirar(200.0);
		assertEquals(-200, cuenta.getSaldo());
	}

	@Test
	void test0014() {
		// 1- Reintegro de 200€ de la cuenta 12345
		cuenta12345.retirar(200.0);
		assertFalse(cuenta12345.getSaldo() < -500, "Saldo insuficiente en cuenta 12345");

		// 2- Reintegro de 350€ de la cuenta 67890
		cuenta67890.retirar(350.0);
		assertFalse(cuenta67890.getSaldo() < -500, "Saldo insuficiente en cuenta 67890");

		// 3- Ingreso de 100€ de la cuenta 12345
		cuenta12345.ingresar(100.0);
		assertFalse(cuenta12345.getSaldo() < -500, "Saldo insuficiente en cuenta 12345");

		// 4- Reintegro de 200€ de la cuenta 67890
		cuenta67890.retirar(200.0);
		assertFalse(cuenta67890.getSaldo() < -500, "Saldo insuficiente en cuenta 67890");

		// 5- Reintegro de 150€ de la cuenta 67890
		cuenta67890.retirar(150.0);
		assertFalse(cuenta67890.getSaldo() < -500, "Saldo insuficiente en cuenta 67890");

		// 6- Reintegro de 200€ de la cuenta 12345
		cuenta12345.retirar(200.0);
		assertFalse(cuenta12345.getSaldo() < -500, "Saldo insuficiente en cuenta 12345");
		
		// 7- Ingreso de 50€ en la cuenta 67890
		cuenta67890.ingresar(50.0);
		assertFalse(cuenta67890.getSaldo() < -500, "Saldo insuficiente en cuenta 67890");
		
		// 8- Reintegro de 100€ de la cuenta 67890
		cuenta67890.retirar(100.0);
		assertFalse(cuenta67890.getSaldo() < -500, "Saldo insuficiente en cuenta 67890");
	}

}
