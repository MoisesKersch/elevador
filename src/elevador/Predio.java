package elevador;

import java.util.List;

public class Predio
{
	private String nome;
	private String endereco;
	private String responsavel;
	// predios podem ter mais elevadores.
	private List<Elevador> elevadores;
	private List<Andar> andares;
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public String getResponsavel()
	{
		return responsavel;
	}
	
	public void setResponsavel(String responsavel)
	{
		this.responsavel = responsavel;
	}
	
	public List<Elevador> getElevadores()
	{
		return elevadores;
	}
	
	public void setElevadores(List<Elevador> elevadores)
	{
		this.elevadores = elevadores;
	}
	
	public List<Andar> getAndares()
	{
		return andares;
	}
	
	public void setAndares(List<Andar> andares)
	{
		this.andares = andares;
	}
}
