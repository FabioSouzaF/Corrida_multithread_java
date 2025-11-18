package Corrida;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		int numCars = 5;
		int tamPista = 50;
		Carro[] carros = new Carro[numCars];
		List<Carro> podio = Collections.synchronizedList(new ArrayList<>());
		Random random = new Random();
		ThreadWorker[] threadWorkers = new ThreadWorker[numCars];
		
		int velIni = 5;
		int velMax = 100;
		
		for (int i = 0; i < numCars; i++) {
			
			carros[i] = new Carro("Carro_" + i, 0, random.nextInt(velMax - velIni + 1) + velIni, 0.5f);
			printM(carros[i].nome + " | VelMax: " + carros[i].velFin);
		}
		
		for (int i = 0; i < carros.length; i++) {
			threadWorkers[i] = new ThreadWorker(carros[i], tamPista, podio);
			threadWorkers[i].start();
		}
		
		try {
			for (int i = 0; i < threadWorkers.length; i++) {
				threadWorkers[i].join();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		printM("======== Finalistas =========");
		for (int i = 0; i < podio.size(); i++) {
			Carro carro = podio.get(i);
			printM("Posição "+ i + " - " + carro.nome);
		}
		
	}
	
	public static void printM(String message) {
		System.out.println(message);
	}

}
