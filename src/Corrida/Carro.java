package Corrida;

public class Carro {
	
	String nome;
	int velIni, velFin;
	float currentVel, acel, dist;
	
	public Carro(String _nome, int _velIni, int _velFin, float _acel) {
		nome	   = _nome;
		velIni	   = _velIni;
		velFin 	   = _velFin;
		acel	   = _acel;
		
		currentVel = _velIni;
		dist = 0;
	}
	
	public void setVel(float vel) {
		
		if(vel > velFin) {
			currentVel = velFin;
		} else {
			currentVel = vel;
		}
		
	}
	
	public void setDist(float _dist) {
		dist = _dist;
	}
	
}
