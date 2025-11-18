package Corrida;

import java.util.List;

public class ThreadWorker extends Thread {
	

	Carro carro;
	List<Carro> podio;
	float tamPista;
	
	public ThreadWorker(Carro _carro, float _tamPista, List<Carro> _podio) {
		carro = _carro;
		tamPista = _tamPista;
		podio = _podio;
	}
	
	@Override
	public void run() {
		
		long lastTime = System.nanoTime();
        double deltaTime = 0;
		
		while (carro.dist < tamPista) {
			
            long currentTime = System.nanoTime();
            long timeElapsedNanos = currentTime - lastTime;
            deltaTime = (double) timeElapsedNanos / 1000000000.0;
            lastTime = currentTime;
			
			
			carro.setVel(carro.currentVel + (carro.acel * (float)deltaTime));
			carro.setDist(carro.dist + (carro.currentVel * (float)deltaTime));
			
			System.out.println(carro.nome + " | currentVel: " + carro.velFin + " | Distancia: " + carro.dist);
			
			try {
                Thread.sleep(16); // ~60 FPS (1000ms / 60 frames ≈ 16.6ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			
		}
		podio.add(carro);
		System.out.println("======= " + carro.nome + " CHEGOU! ========");
		
	}
	
}
