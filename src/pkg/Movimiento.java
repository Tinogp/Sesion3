package pkg;

public class Movimiento {
	enum Signo {
		D, H
	};

	public Double importe;
	public Signo signo;
	public String detalle;

	public Movimiento(Double imp, boolean signo, String det) {
		importe = imp;
		if (signo) {
			this.signo = Signo.D;
		} else
			this.signo = Signo.H;
		detalle = det;
	}
}
