package miBanco;

public class Debito extends Tarjetas {

	private double maximoDiario;

	public Debito(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,
			int clave, Cuentas cuentaAsociada, String numeroTarjeta, int clavePIN, int claveSeguridad,
			double saldoDiario, String fechaCaducidad, double maximoDiario) {

		super(descripcion, comision, fInicio, fFinal, clienteAsociado, clave, cuentaAsociada, numeroTarjeta, clavePIN,
				claveSeguridad, saldoDiario, fechaCaducidad);

		this.maximoDiario = maximoDiario;
	}

	public double getMaximoDiario() {
		return maximoDiario;
	}

	public void setMaximoDiario(double maximoDiario) {
		this.maximoDiario = maximoDiario;
	}

	

	@Override
	public String toString() {
		return "Debito [maximoDiario=" + maximoDiario + ", cuentaAsociada=" + cuentaAsociada + ", descripcion="
				+ descripcion + ", comision=" + comision + ", fInicio=" + fInicio + ", fFinal=" + fFinal + ", clave="
				+ clave + "]";
	}

	public Double sacaDebito(double cantidad) {
		if (acceso) {
			System.out.println("Cantidad actual de la cuenta: " + cuentaAsociada.getSaldo());

			if (cantidad <= maximoDiario && cantidad <= cuentaAsociada.getSaldo()) {
				cuentaAsociada.setSaldo(cuentaAsociada.getSaldo() - cantidad);
				maximoDiario = maximoDiario - cantidad;
				System.out.println("Dinero retirado (" + cantidad + ")");
				System.out.println("Cantidad posterior a la operación: " + cuentaAsociada.getSaldo());
			} else {
				System.out.println("Esta cantidad supera el máximo diario permitido o la cuenta no tiene saldo suficiente");
			}
		}
		acceso = false;
		return cuentaAsociada.getSaldo();
	}

	public void finDia(double maximoDiario) {
		this.maximoDiario = maximoDiario;
	}

}
