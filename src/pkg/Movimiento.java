package pkg;

public class Movimiento {
	enum Signo {
		D, H
	};

	public Double importe;
	public Signo signo;
	public String detalle;

	public Movimiento(Double saldo,Double imp, boolean signo, String det) {
		importe = imp;
		detalle = det;
		if (signo) {
			this.signo = Signo.D;
		} else {
			this.signo = Signo.H;
			System.out.println("Error en el movimiento, saldo en la cuenta: "+saldo+"\n"
					+ "importe a reintregar: "+imp+"\ndetalles: "+det);
		}
			
	}
	
	
}
