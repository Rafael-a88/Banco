package miBanco;

public class Empleados extends DatosPersonales implements IEmpleados {

	private String fechaContratacion;
	private String puestoTrabajo;
	private double sueldo;
	private int aniosExperiencia;

	public Empleados(String dni, String nombre, String apellido, String apellido2, long telefono, String correo,
			String direccion, String localidad, int cPostal, String provincia, String fnacimiento, String observaciones,
			String fechaContratacion, String puestoTrabajo, double sueldo, int aniosExperiencia) {
		super(dni, nombre, apellido, apellido2, telefono, correo, direccion, localidad, cPostal, provincia, fnacimiento,
				observaciones);
		this.fechaContratacion = fechaContratacion;
		this.puestoTrabajo = puestoTrabajo;
		this.sueldo = sueldo;
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public String getPuestoTrabajo() {
		return puestoTrabajo;
	}

	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return "Empleados [ Dni=" + Dni + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Apellido2=" + Apellido2
				+ ", Telefono=" + Telefono + ", Correo=" + Correo + ", Direccion=" + Direccion + ", Localidad="
				+ Localidad + ", CPostal=" + CPostal + ", Provincia=" + Provincia + ", Fnacimiento=" + Fnacimiento
				+ ", Observaciones=" + Observaciones + " FechaContratacion=" + fechaContratacion + ", PuestoTrabajo="
				+ puestoTrabajo + ", Sueldo=" + sueldo + ", AñosExperiencia=" + aniosExperiencia + "]";
	}

	public void aumentoSalarial( double porcentaje) {
		
		double aumento = this.sueldo * (porcentaje / 100);
		double nuevoSueldo = this.sueldo + aumento;
		this.sueldo = nuevoSueldo;
		System.out.println("El nuevo sueldo del empleado es: " + nuevoSueldo);
	}

	public void ascenso( String nuevoPuesto, double nuevoSueldo) {
		this.puestoTrabajo= nuevoPuesto;
		this.sueldo= nuevoSueldo;
		System.out.println("El empleado " + this.Nombre + " " + this.Apellido + " " + this.Apellido2 + " obtendra el puesto de " + nuevoPuesto + " y un salario de " + nuevoSueldo +"€");
	}

}
