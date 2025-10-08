package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	String numero;
	String titular;
	Double saldo;
	List<Movimiento> mMovimientos;

	public Cuenta(Double i) {
		saldo = i;
		mMovimientos = new ArrayList<>();
	}

	public void ingresar(Double i) {
		saldo += i;
		mMovimientos.add(new Movimiento(i, true, "Detalles..."));
	}

	public void retirar(Double i) {
		saldo -= i;
		mMovimientos.add(new Movimiento(-i, false, "Detalles..."));
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		if(saldo<-500)
			return -500.0;
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
