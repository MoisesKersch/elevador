package elevador;

public class Sensor
{
	private int serialNumber;
	private int andarCorrente;
	private double pesoCorrente;
	private int numeroPessoas;
	
	public int getSerialNumber()
	{
		return serialNumber;
	}
	
	public void setSerialNumber(int serialNumber)
	{
		this.serialNumber = serialNumber;
	}
	
	public int getAndarCorrente()
	{
		return andarCorrente;
	}
	
	public void setAndarCorrente(int andarCorrente)
	{
		this.andarCorrente = andarCorrente;
	}
	public double getPesoCorrente()
	{
		return pesoCorrente;
	}
	
	public void setPesoCorrente(double pesoCorrente)
	{
		this.pesoCorrente = pesoCorrente;
	}
	
	public int getNumeroPessoas()
	{
		return numeroPessoas;
	}
	
	public void setNumeroPessoas(int numeroPessoas)
	{
		this.numeroPessoas = numeroPessoas;
	}
}
