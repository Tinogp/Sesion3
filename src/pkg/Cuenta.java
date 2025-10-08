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
		mMovimientos.add(new Movimiento(saldo, i, true, "Detalles..."));
	}

	public void retirar(Double i) {
		if (saldo - i < -500) {
			mMovimientos.add(new Movimiento(saldo, -i, false, "Error, no hay suficiente saldo..."));
		} else {
			saldo -= i;
			mMovimientos.add(new Movimiento(saldo, -i, true, "Detalles..."));
		}
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
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
