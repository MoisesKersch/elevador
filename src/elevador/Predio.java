package elevador;

import java.util.ArrayList;
import java.util.List;

public class Predio
{
	private String nome;
	private String endereco;
	private String responsavel;
	// predios podem ter mais elevadores.
	private List<Elevador> elevadores = new ArrayList<Elevador>();
	private List<Andar> andares;
	private Integer numeroAndares;
	
	public Integer getNumeroAndares() {
		return numeroAndares;
	}

	public void setNumeroAndares(int numeroAndares) {
		this.numeroAndares = numeroAndares;
	}

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

	public void setAndaresOneByOne()
	{
		if (this.numeroAndares != null)
		{	
			this.andares = new ArrayList<Andar>();
			for (int x = 0; x < this.numeroAndares; x++)
			{
				Andar andar = new Andar();
				andar.setNumero(x);
				this.getAndares().add(andar);
			}
		}
	}
}
