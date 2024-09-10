package miBanco;

public class CreditosPersonales extends Banco implements IBanco {

	private double saldoSolicitado;
	private int devolucion;
	private double intMensual;
	private double intAnuales;
	private String fechaRevision;
	private String fechaSolicitud;
	private String fechaFinal;
	private Cliente clienteAsociado;
	
	public CreditosPersonales (String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			double saldoSolicitado, int devolucion, double intMensual, double intAnuales,
			String fechaRevision, String fechaSolicitud, String fechaFinal) {
		
		super(descripcion,comision, fInicio, fFinal,clave);
		
		this.saldoSolicitado = saldoSolicitado;
		this.devolucion = devolucion;
		this.intMensual = intMensual;
		this.intAnuales = intAnuales;
		this.fechaRevision = fechaRevision;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaFinal = fechaFinal;
		this.clienteAsociado= clienteAsociado;
	}

	
	public Cliente getClienteAsociado() {
		return clienteAsociado;
	}


	public void setClienteAsociado(Cliente clienteAsociado) {
		this.clienteAsociado = clienteAsociado;
	}


	public double getSaldoSolicitado() {
		return saldoSolicitado;
	}

	public void setSaldoSolicitado(double saldoSolicitado) {
		this.saldoSolicitado = saldoSolicitado;
	}

	public int getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(int devolucion) {
		this.devolucion = devolucion;
	}

	public double getIntMensual() {
		return intMensual;
	}

	public void setIntMensual(double intMensual) {
		this.intMensual = intMensual;
	}

	public double getIntAnuales() {
		return intAnuales;
	}

	public void setIntAnuales(double intAnuales) {
		this.intAnuales = intAnuales;
	}

	public String getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public String toString() {
		return "CreditosPersonales [saldoSolicitado=" + saldoSolicitado + ", devolucion=" + devolucion + ", intMensual="
				+ intMensual + ", intAnuales=" + intAnuales + ", fechaRevision=" + fechaRevision + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaFinal=" + fechaFinal + ", descripcion=" + descripcion + ", comision="
				+ comision + ", fInicio=" + fInicio + ", fFinal=" + fFinal + ", clave=" + clave + "]";
	}

	
	
}


