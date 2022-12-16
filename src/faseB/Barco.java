package faseB;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Barco extends Movil {

	private int cantBombasRestantes;
	
	private int tiraBombaEn;
	
	private int salePor = salirPor();
	
	private Bomba b;
	
	private int nivel;
	
	private boolean tiroBomba;
	
	public  Barco(int nivel) {
		
		this.tamañoAncho = 100;
		this.tamañoLargo = 100;
		this.nivel = nivel;
		this.cantBombasRestantes = 1;
		this.posicionY = 50;
		if (salePor == 1) this.posicionX = -this.tamañoAncho;
		else this.posicionX = 600;
		this.velocidad = 1 * (1+nivel/10);
		this.tiraBombaEn = tirarBombaEn();
		this.tiroBomba = false;
		
		
	}
	
	
	
	
	
	public Bomba getBomba() {
		return b;
	}
	
	public float getX() {
		return this.posicionX;
	}
	
	public boolean tiroBomba() {
		return this.cantBombasRestantes == 0;
	}
	
	
	public void tiraBomba(int nivel) {
		if (cantBombasRestantes != 0 ) {
			if (this.salePor == 1 && this.posicionX > tiraBombaEn) {
				b = new Bomba(nivel, tiraBombaEn);
				this.actualizaCantidadBombas();
				this.tiroBomba = true;}
			else if (this.salePor == -1 && this.posicionX < tiraBombaEn) {
				b = new Bomba(nivel, tiraBombaEn);
				this.actualizaCantidadBombas();
				this.tiroBomba = true;}
		}
	}
	
	
	public void actualizaPosicion() {
		this.posicionX += 10 * this.velocidad * salePor; // si salePor es negativo restara
		this.tiraBomba(nivel);
	}

	private int salirPor() { // devuelve 1 si sale por izquierda o -1 si sale por derecha
    	int numero = (int)(Math.random()*10+1);
    	if (numero%2 == 0 ) return 1;
    	else return -1;
		}
	
	private int tirarBombaEn() {
    	int numero = (int)(Math.random()*500+1);
    	return numero;
		}

    public boolean explotoBomba() {
    	boolean exploto = false;
    	if (this.posicionX >= tiraBombaEn) {
    		exploto = b.detono();
    	}
    	return exploto;
    }
    
    public float posicionBombaX() {
    	return tiraBombaEn;
    }
    
    public float posicionBombaY() {
    	return b.posicionY;
    }
    
    private void actualizaCantidadBombas() {
       this.cantBombasRestantes -= 1;
    }
    public BarcoView toView() {
    	return new BarcoView(tamañoLargo , tamañoAncho, posicionX, posicionY,this.tiroBomba);
    }

}