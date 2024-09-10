package miBanco;

public interface ICuentas {

	public double getCmantenimiento();
	public int getIban();
	public double getSaldo();
	public double SacarDinero(double cantidad);
	public double IngresarDinero(double cantidad);
	public String VisualizarCuenta();
	public String DatosCuenta();
	public TiposCuenta TipoCuenta();
	public double DevolverIntereses();
	
}
