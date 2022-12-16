package faseB;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Submarino {
	
	private int cantPuntos;
	private int cantVidas;
	private int HP;
	private int PROF_MAX;
	private int PROF_MIN;
	private int ancho, alto;
	private float posicionX;
	private float posicionY;
	private int cantVidasSumadas;
	

    public Submarino() {
    	tamaño();
    	this.PROF_MIN =(int) (((alto * 0.9)-150) * 0.375)+150;
    	this.PROF_MAX = (int) (((alto * 0.9)-150) * 1)-100+150;
    	this.cantVidas = 3;
    	this.cantPuntos = 0;
    	this.HP=100;
    	this.posicionX = 333;
    	this.posicionY = 400;
    	this.cantVidasSumadas = 0;
    }
    
    private void tamaño() {
	    Toolkit t = Toolkit.getDefaultToolkit();    
        Dimension dimensions = t.getScreenSize();
        ancho = dimensions.width;
        alto = dimensions.height;
	}
    

    public void moverSubmarino( String direccion) {
    	int opcion=0;
    	if (direccion=="der") {opcion=1;}
    	else if (direccion=="izq") {opcion=2;}
    	else if (direccion=="arr") {opcion=3;}
    	else if (direccion=="aba") {opcion=4;}
        switch (opcion){
        	case 1:
        	if (posicionX<490)
        	posicionX+=10;
        	break;
        	case 2:
        	if (posicionX>10)
        	posicionX-=10;
        	break;
        	case 3:
        	if (posicionY>PROF_MIN)
        	posicionY-=10;
        	break;
        	case 4:
        	if (posicionY<PROF_MAX)
        	posicionY+=10;
        	break;
        	}
    }
  
    public void calcularDistancia( float x,  float y) {
        // TODO implement here
    	int centroX = (int) x + 25;
    	int centroY = (int) y + 25;
    	int posX = (int)this.posicionX + 50;
    	int posY = (int)this.posicionY + 50;
    	float distanciaX = centroX - posX;
    	float distanciaY = centroY - posY;
    	double distancia=Math.sqrt(distanciaX*distanciaX+distanciaY*distanciaY);
        //System.out.println("calcula dist: ");
        if (distancia>190)
        {
        	//System.out.println(distancia + "cat1");
        	this.sumarPuntos(30);
        	this.restarHP(0);
        }
        else if (distancia>140)
        {
        	//System.out.println(distancia + "cat2");
        	this.sumarPuntos(10);
        	this.restarHP(30);
        }
        else if (distancia>=100)
        {
        	//System.out.println(distancia + "cat3");
        	this.restarHP(50);
        }
        else if (distancia<100)
        {
        	//System.out.println(distancia + "cat4");
        	this.restarHP(100);}
        
    }

    public void sumarPuntos(int puntos) {
    	//System.out.println("sumar puntos: "+puntos);
    	this.cantPuntos += puntos;
    	if (this.cantPuntos >= (this.cantVidasSumadas + 1) * 500) {
    		this.cantVidas ++;
    		this.cantVidasSumadas ++;
    	}
    }

   private void restarHP(int restar) {
	   //System.out.println("restar: "+restar);
	   this.HP -= restar;
	   if (this.HP < 1 && this.cantVidas > -1) {
		   this.cantVidas -= 1;
		   this.HP = 100;
	   }
   }
   
    public SubmarinoView toView() {
    	return new SubmarinoView( this.cantPuntos,this.cantVidas, this.HP, this.posicionX, this.posicionY);
    }

}
