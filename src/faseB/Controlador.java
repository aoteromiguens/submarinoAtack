package faseB;

public class Controlador {
private Mar mar;
private Submarino submarino;

    public Controlador() {
    	comenzarJuego();
    }
    
    public boolean continuarJuego() {
    	return submarino.toView().getCantVidas() >-1;
    }

    private void comenzarJuego() {
    	crearSubmarino();
    	crearMar();  
    }

    public BarcoView BarcotoView() {
    	return mar.BarcotoView();
    }
    public BombaView[] BombatoView() {
    	return mar.BombatoView();
    }
    public SubmarinoView SubmarinoToView() {
    	return submarino.toView();
    }
    
    public void moverSubmarino(String teclado) {
        submarino.moverSubmarino(teclado);
    }
    
    public void moverBarcoYBombas () {
    	mar.actualizarPosicion();
    }

    private void crearMar() {
    	Mar mar=new Mar(submarino);
        this.mar=mar;
    }

    private void crearSubmarino() {
        Submarino submarino=new Submarino();
        this.submarino=submarino;
    }

}
