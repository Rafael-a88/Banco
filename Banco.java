package miBanco;

import java.util.Scanner;

public class Banco implements IBanco{

	public String descripcion;
	public double comision;
	public String fInicio;
	public String fFinal;
	public int clave;
	public boolean acceso;
	
	
	public Banco(String descripcion,double comision, String fInicio, String fFinal,int clave) {
	
		this.descripcion = descripcion;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		this.comision= comision;
		this.clave=clave;
		this.acceso=false;
	}

	
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}


	public String getFInicio() {
		return fInicio;
	}


	public void setFInicio(String fInicio) {
		this.fInicio = fInicio;
	}


	public String getFFinal() {
		return fFinal;
	}


	public void setFFinal(String fFinal) {
		this.fFinal = fFinal;
	}


	public int getClave() {
		return clave;
	}


	public void setClave(int clave) {
		this.clave = clave;
	}


	@Override
	public String toString() {
		return "Banco [Descripcion=" + descripcion + ", Clave=" + clave + "]";
	}

	public boolean Acceso(int codigo) {
		acceso=false;
		if(codigo==this.getClave() && String.valueOf(codigo).length()==4) {
			acceso=true;
		}else {
			System.out.println("El codigo no contiene 4 cifras");
		}
		return acceso;
	}
	
	

}

