package miBanco;

public interface ITarjetas {

	public int getClavePIN();
	public int getClaveSeguridad();
	public Cliente getClienteAsociado();
	public Cuentas getCuentaAsociada();
	public String getFechaCaducidad();
	public String getNumeroTarjeta();
	public double getSaldoDiario();
}
