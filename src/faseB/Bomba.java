package faseB;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Bomba extends Movil {


	private int distanciaDetonar;
	private boolean exploto;
	private int PROF_MAX;
	private int PROF_MIN;
	private int ancho, alto;
	
	
	
	
	public Bomba(int nivel, int tiraBombaEn) {
		tamaño();
    	this.PROF_MIN =(int) (((alto * 0.9)-150) * 0.375)-50+150;
    	this.PROF_MAX = (int) (((alto * 0.9)-150) * 0.875)-50+150;
    	
		this.posicionY = 100;
		this.posicionX = tiraBombaEn;
		this.velocidad = 1 * (1+nivel/10);
		this.tamañoAncho = 10;
		this.tamañoLargo = 5;
		this.distanciaDetonar = explotarBombaEn();
		this.exploto = false;
	}
	private void tamaño() {
	    Toolkit t = Toolkit.getDefaultToolkit();    
        Dimension dimensions = t.getScreenSize();
        ancho = dimensions.width;
        alto = dimensions.height;
	}
	
	private int explotarBombaEn() { 
    	int numero = (int)(Math.random()*(this.PROF_MAX-this.PROF_MIN)+1);
    	return numero + this.PROF_MIN;
		}

    public boolean detono() {
        return exploto;
        		
    }

    public void actualizaPosicion() {
    	this.posicionY += 10 * this.velocidad;
    	if (this.posicionY >= this.distanciaDetonar) exploto = true;
    	
    }
    
    public BombaView toView() {
    	return new BombaView(tamañoLargo , tamañoAncho, posicionX, posicionY, exploto );
    }
}