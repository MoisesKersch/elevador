package elevador;

public class Elevador
{
	private double capacidade;
	private Sensor sensor;
	
	public double getCapacidade()
	{
		return capacidade;
	}
	public void setCapacidade(double capacidade)
	{
		this.capacidade = capacidade;
	}
	public Sensor getSensor()
	{
		return sensor;
	}
	public void setSensor(Sensor sensor)
	{
		this.sensor = sensor;
	}
}
