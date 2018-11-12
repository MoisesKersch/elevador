package elevador;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Queen forever...
   
    Sistema de Controle de Elevador

	Fazer um sistema de controle de elevador de um prédio.
	Um prédio tem UM elevador e vários andares. O elevador tem uma
	capacidade de pessoas pelo seu peso. Não é possível colocar peso
	maior que a capacidade. Uma série de pessoas entram e saem do 
	elevador e param em um determinado andar. A cada execução o sistema
	deve mostrar o andar atual do elevador, bem como as pessoas que
	estão nos andares e no elevador.

	No final da execução, todas as pessoas que ainda estiverem no elevador
	devem descer no térreo.
	
	Tudo pode ser registrado, o predio, o sensor, e os andares.
 */


public class Main
{
	private Predio predio;
	private Sensor sensor;
	private Elevador elevador;
	private Scanner scanner;
	
	// criar um predio
	public void registrarPredio()
	{
		scanner = new Scanner(System.in);
		predio = new Predio();
		predio.setNome("super predio");
		predio.setEndereco("na zona oeste do norte sul");
		predio.setResponsavel("grande homem");
		// set elevadores
		predio.setNumeroAndares(5);
		predio.setAndaresOneByOne();
		
		System.out.println("Imóvel registrado com sucesso!");
	}
	
	// registra sensor
	public void registrarSensor()
	{
		scanner = new Scanner(System.in);
		sensor = new Sensor();
		sensor.setSerialNumber(00000);
		sensor.setAndarCorrente(0);
		sensor.setNumeroPessoas(0);
		sensor.setPesoCorrente(0);
		System.out.println("Sensor registrado com sucesso!");
	}
	
	// registrar elevador
	public void registrarElevador()
	{
		scanner = new Scanner(System.in);
		elevador = new Elevador();
		elevador.setCapacidade(1000);
		// sensor criado no método acima
		elevador.setSensor(sensor);
		
		predio.getElevadores().add(elevador);
		System.out.println("Elevador registrado com sucesso!");
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		
		Main main = new Main();
		main.registrarPredio();
		main.registrarSensor();
		main.registrarElevador();
		
		int andarCorrente = 1;
		int numeroPessoas = 0;
		int pesoCorrente = 0;
		
		while (true)
		{	
			// ta que andar?
			System.out.println("O Elevador está no andar: " + main.getPredio().getElevadores().get(0).getSensor().getAndarCorrente());
			// tem quantas pessoas?
			System.out.println("Número de pessoas dentro do elevador: " +main.getPredio().getElevadores().get(0).getSensor().getNumeroPessoas());
			// qual o peso atual gerado pelo numero de pessoas dentro do elevador? 
			System.out.println("Peso atual gerado pelo número de pessoas dentro do elevador: " +main.getPredio().getElevadores().get(0).getSensor().getPesoCorrente());
			
			// descer pessoas
			if (numeroPessoas > 0)
			{
				// gerar um número de pessoas que sairam do elevador
				int numeroPessoasSaindo =  ThreadLocalRandom.current().nextInt(numeroPessoas);
				// faz a substração com o número corrente de pessoas
				numeroPessoas -= numeroPessoasSaindo;
				main.getPredio().getElevadores().get(0).getSensor().setNumeroPessoas(numeroPessoas);
			}
			
			// abrir a porta do elevador para as pesoas 0 a 15 pessoas
			numeroPessoas += ThreadLocalRandom.current().nextInt(15);
			
			// peso corrente
			pesoCorrente = numeroPessoas * 70;
			
			// ver se a capacidade de pessoas dentro aceita mais supondo que todos pesam uma media de 70 kilos
			if (pesoCorrente < main.getPredio().getElevadores().get(0).getCapacidade() )
			{
				System.out.println("Capacidade não foi sobrecarregada!");
			
				// indo para o proximo andar 
				andarCorrente = ThreadLocalRandom.current().nextInt(main.getPredio().getNumeroAndares());
				
				// descer todas as pessoas se o andar corrente for 0
				if (andarCorrente == 0)
				{
					numeroPessoas = 0;
					pesoCorrente = 0;
					main.getPredio().getElevadores().get(0).getSensor().setPesoCorrente(0);
				}
				
				// andar corrente detectado pelo sensor e atualizado
				main.getPredio().getElevadores().get(0).getSensor().setAndarCorrente(andarCorrente);
				
				// numero de pesoas detectado pelo sensor
				main.getPredio().getElevadores().get(0).getSensor().setNumeroPessoas(numeroPessoas);
				main.getPredio().getElevadores().get(0).getSensor().setPesoCorrente(pesoCorrente);
				
				Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
				continue;
			}
			else 
			{
				System.out.println("Capacidade foi sobrecarregada!");
				continue;
			}
		}
	}
	
	public Predio getPredio() {
		return predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Elevador getElevador() {
		return elevador;
	}

	public void setElevador(Elevador elevador) {
		this.elevador = elevador;
	}
}
