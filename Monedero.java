package miBanco;

public class Monedero extends Tarjetas {

	private double saldoMonedero;

	public Monedero(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,
			int clave, Cuentas cuentaAsociada, String numeroTarjeta, int clavePIN, int claveSeguridad,
			double saldoDiario, String fechaCaducidad, double saldoMonedero) {

		super(descripcion, comision, fInicio, fFinal, clienteAsociado, clave, cuentaAsociada, numeroTarjeta, clavePIN,
				claveSeguridad, saldoDiario, fechaCaducidad);
		this.saldoMonedero = saldoMonedero;
	}

	public double getSaldoMonedero() {
		return saldoMonedero;
	}

	public void setSaldoMonedero(double saldoMonedero) {
		this.saldoMonedero = saldoMonedero;
	}


	@Override
	public String toString() {
		return "Monedero [saldoMonedero=" + saldoMonedero + ", cuentaAsociada=" + cuentaAsociada + ", descripcion="
				+ descripcion + ", comision=" + comision + ", fInicio=" + fInicio + ", fFinal=" + fFinal + ", clave="
				+ clave + "]";
	}

	public Double sacaMonedero(double cantidad) {
		if (acceso) {
			if (cantidad <= saldoMonedero) {
				setSaldoMonedero(getSaldoMonedero() - cantidad);
				System.out.println("Dinero retirado (" + cantidad + ")");
			} else {
				System.out.println("Saldo insuficiente en el monedero");
			}
		}

		acceso = false;
		return getSaldoMonedero();
	}

	public Double cargaSaldo(double cantidad) {
		if (acceso) {
			setSaldoMonedero(getSaldoMonedero() + cantidad);
			System.out.println("Dinero ingresado: " + cantidad);
		}

		acceso = false;
		return getSaldoMonedero();
	}
}