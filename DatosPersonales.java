package miBanco;

import java.util.Scanner;

public class DatosPersonales implements IDatosPersonales{

	public String Dni;
	public String Nombre;
	public String Apellido;
	public String Apellido2;
	public long Telefono;
	public String Correo;
	public String Direccion;
	public String Localidad;
	public int CPostal;
	public String Provincia;
	public String Fnacimiento;
	public String Observaciones;
	
	
	public DatosPersonales(String dni, String nombre, String apellido,String apellido2, long telefono, String correo, String direccion,
			String localidad, int cPostal, String provincia, String fnacimiento, String observaciones) {
		
		this.Dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Apellido2 = apellido2;
		this.Telefono = telefono;
		this.Correo = correo;
		this.Direccion = direccion;
		this.Localidad = localidad;
		this.CPostal = cPostal;
		this.Provincia = provincia;
		this.Fnacimiento = fnacimiento;
		this.Observaciones = observaciones;
	}


	public String getDni() {
		return Dni;
	}


	public void setDni(String dni) {
		this.Dni = dni;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	

	public String getApellido2() {
		return Apellido2;
	}


	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}


	public long getTelefono() {
		return Telefono;
	}


	public void setTelefono(Long telefono) {
		this.Telefono = telefono;
	}


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		this.Correo = correo;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}


	public String getLocalidad() {
		return Localidad;
	}


	public void setLocalidad(String localidad) {
		this.Localidad = localidad;
	}


	public int getCPostal() {
		return CPostal;
	}


	public void setCPostal(int cPostal) {
		this.CPostal = cPostal;
	}


	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		this.Provincia = provincia;
	}


	public String getFnacimiento() {
		return Fnacimiento;
	}


	public void setFnacimiento(String fnacimiento) {
		this.Fnacimiento = fnacimiento;
	}


	public String getObservaciones() {
		return Observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.Observaciones = observaciones;
	}


	
	
	public void ModificarDatos(DatosPersonales misDatos) {
		// TODO Auto-generated method stub
		Scanner miScan= new Scanner(System.in);
		String pregunta;
		
		System.out.println("¿Desea modificar los datos? (si/no)");
		pregunta=miScan.nextLine();
		
		if (pregunta.equalsIgnoreCase("si")) {
			
			if(misDatos instanceof Cliente) {
				Cliente cliente = (Cliente) misDatos;
				cliente.ModificarDatos(misDatos);
			}
			if (misDatos instanceof Empleados) {
				Empleados empleado= (Empleados) misDatos;
				empleado.ModificarDatos(misDatos);
				
			}
		}
	}


	
	
}
