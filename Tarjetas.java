package miBanco;

public class Tarjetas extends Banco implements ITarjetas{


	protected Cuentas cuentaAsociada;
	private String numeroTarjeta;
	private int clavePIN;
	private int claveSeguridad;
	private double saldoDiario;
	private String fechaCaducidad;
	private Cliente clienteAsociado;




	public Tarjetas(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			Cuentas cuentaAsociada, String numeroTarjeta,
			int clavePIN, int claveSeguridad, double saldoDiario, String fechaCaducidad) {

		super(descripcion,comision, fInicio, fFinal,clave);

		this.cuentaAsociada = cuentaAsociada;
		this.numeroTarjeta = numeroTarjeta;
		this.clavePIN = clavePIN;
		this.claveSeguridad = claveSeguridad;
		this.saldoDiario = saldoDiario;
		this.fechaCaducidad = fechaCaducidad;
		this.clienteAsociado= clienteAsociado;
	}



	public Cuentas getCuentaAsociada() {
		return cuentaAsociada;
	}


	public void setCuentaAsociada(Cuentas cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
	}


	public Cliente getClienteAsociado() {
		return clienteAsociado;
	}



	public void setClienteAsociado(Cliente clienteAsociado) {
		this.clienteAsociado = clienteAsociado;
	}



	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public int getClavePIN() {
		return clavePIN;
	}


	public void setClavePIN(int clavePIN) {
		this.clavePIN = clavePIN;
	}


	public int getClaveSeguridad() {
		return claveSeguridad;
	}


	public void setClaveSeguridad(int claveSeguridad) {
		this.claveSeguridad = claveSeguridad;
	}


	public double getSaldoDiario() {
		return saldoDiario;
	}


	public void setSaldoDiario(double saldoDiario) {
		this.saldoDiario = saldoDiario;
	}


	public String getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	
	@Override
	public String toString() {
		return "Tarjetas [cuentaAsociada=" + cuentaAsociada + ", numeroTarjeta=" + numeroTarjeta + ", clavePIN="
				+ clavePIN + ", claveSeguridad=" + claveSeguridad + ", saldoDiario=" + saldoDiario + ", fechaCaducidad="
				+ fechaCaducidad + ", clienteAsociado=" + clienteAsociado + ", descripcion=" + descripcion
				+ ", comision=" + comision + ", fInicio=" + fInicio + ", fFinal=" + fFinal + ", clave=" + clave
				+ "]";
	}



	@Override
	public boolean Acceso(int codigo) {
		if (codigo == this.clavePIN) {
			acceso = true;
		} else {
			acceso = false;
		}
		return acceso;
	}
	public void sacaDinero(double cantidad) {
		if(acceso) {
			if (this instanceof Debito) {
				//MODIFICA CLIENTE
				Debito debito = (Debito) this;
				debito.sacaDebito(cantidad);
			}
			if (this instanceof Credito) {
				//MODIFICA EMPLEADO
				Credito credito = (Credito) this;
				credito.sacaCredito(cantidad);
			}
			if (this instanceof Monedero) {
				//MODIFICA EMPLEADO
				Monedero monedero = (Monedero) this;
				monedero.sacaMonedero(cantidad);
			}	
		}else {
			System.out.println("Pin incorrecto");
		}

	}
	
	public double cargarMonedero(double cantidad) {
	    double resultado = 0;
	    double saldoAntes= 0;
	    if (acceso) {
	        if (this instanceof Monedero) {
	            Monedero monedero = (Monedero) this;
	            	saldoAntes= monedero.getSaldoMonedero();
	            	System.out.println("Saldo del monedero: " + saldoAntes);
	                resultado = monedero.cargaSaldo(cantidad);
	                System.out.println("Saldo después de la carga: " + resultado);
	            } else {
	                System.out.println("La cuenta no tiene saldo suficiente para cargar el monedero");
	            }
	        
	    } else {
	        System.out.println("Pin incorrecto");
	    }
	    return resultado;
	}

	public String saldoDisponible() {
		String respuesta="";
		if(acceso) {
			if (this instanceof Debito) {
				Debito debito = (Debito) this;
				respuesta="Su cuenta dispone de :"+debito.getCuentaAsociada().getSaldo() + "€";
			}
			if (this instanceof Credito) {
				Credito credito = (Credito) this;
				respuesta="Este mes aún dispone de :"+credito.getSaldoDiario()+ "€";
			}
			if (this instanceof Monedero) {
				Monedero monedero = (Monedero) this;
				respuesta="El saldo en la tarjeta es de :"+monedero.getSaldoMonedero() + "€";
			}	
		}else {
			System.out.println("Pin incorrecto");
		}
		return respuesta;
	}
	public String datosTarjeta() {
		String respuesta="";
		if(acceso) {
			if (this instanceof Debito) {
				Debito debito = (Debito) this;
				respuesta=debito.toString();
			}
			if (this instanceof Credito) {
				Credito credito = (Credito) this;
				respuesta=credito.toString();
			}
			if (this instanceof Monedero) {
				Monedero monedero = (Monedero) this;
				respuesta=monedero.toString();
			}	
		}else {
			System.out.println("Pin incorrecto");
		}
		return respuesta;
	}
	

}
