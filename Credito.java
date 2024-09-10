package miBanco;

public class Credito extends Tarjetas{

	private double saldoMaximo;
	private double saldoFactura;
	private String fechaFacturacion;
	private double recargoTarjeta;
	


	public Credito(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			Cuentas cuentaAsociada, String numeroTarjeta, int clavePIN,
			int claveSeguridad, double saldoDiario, String fechaCaducidad, double saldoMaximo, double saldoFactura,
			String fechaFacturacion, double recargoTarjeta) {
		
		super(descripcion, comision, fInicio, fFinal, clienteAsociado,clave, cuentaAsociada, numeroTarjeta,
				clavePIN, claveSeguridad, saldoDiario, fechaCaducidad);
		this.saldoMaximo = saldoMaximo;
		this.saldoFactura = saldoFactura;
		this.fechaFacturacion = fechaFacturacion;
		this.recargoTarjeta = recargoTarjeta;
	}



	
	public double getSaldoMaximo() {
		return saldoMaximo;
	}


	public void setSaldoMaximo(double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}


	public double getSaldoFactura() {
		return saldoFactura;
	}


	public void setSaldoFactura(double saldoFactura) {
		this.saldoFactura = saldoFactura;
	}


	public String getFechaFacturacion() {
		return fechaFacturacion;
	}


	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}


	public double getRecargoTarjeta() {
		return recargoTarjeta;
	}


	public void setRecargoTarjeta(double recargoTarjeta) {
		this.recargoTarjeta = recargoTarjeta;
	}

	
	@Override
	public String toString() {
		return "Credito [saldoMaximo=" + saldoMaximo + ", saldoFactura=" + saldoFactura + ", fechaFacturacion="
				+ fechaFacturacion + ", recargoTarjeta=" + recargoTarjeta + ", cuentaAsociada=" + cuentaAsociada
				+ ", descripcion=" + descripcion + ", comision=" + comision + ", fInicio=" + fInicio + ", fFinal="
				+ fFinal + ", clave=" + clave +  "]";
	}


	public Double sacaCredito(double cantidad) {
		if (acceso) {
    if (cantidad <= saldoMaximo) {
        setSaldoMaximo(getSaldoMaximo() - cantidad);
        setSaldoFactura(getSaldoFactura() + cantidad);
        System.out.println("Dinero retirado (" + cantidad + ")");
    } else {
        System.out.println("Saldo insuficiente");
    }
}

acceso = false;
return getSaldoMaximo();
	}
	public void findemes() {
		setSaldoMaximo(recargoTarjeta);
		getCuentaAsociada().setSaldo(getCuentaAsociada().getSaldo()-getSaldoFactura());
		setSaldoFactura(0.0);
	}
	
}
