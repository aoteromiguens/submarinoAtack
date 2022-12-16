package faseB;

public class Mar {

	private int CANT_BARCOS = 10;
	public float LARGO = 800;
	public float ANCHO = 600;
	private int cantBarcosCreados;
	private int cantBombasExplotadas, cantBombasCreados;
	private int nivel;
	private Barco [] barcos; 
	private Bomba [] bombas;
	private boolean [] yaExploto ;
	private Submarino subma;
   
    public Mar(Submarino sub) {
    	this.nivel = 0;
    	this.cantBarcosCreados = 0;
    	this.cantBombasCreados = 0;
    	this.cantBombasExplotadas = 0;
    	barcos = new Barco[this.CANT_BARCOS];
    	bombas = new Bomba[this.CANT_BARCOS];
    	yaExploto  = new boolean[this.CANT_BARCOS];
    	for (int i = 0; i<this.CANT_BARCOS; i++)
		{
    		yaExploto [i]=false;
		}
    	
    	crearBarco();
    	this.subma = sub;
    }
    
    private void cambiarNivel() {
    	this.nivel += 1;
    	this.cantBarcosCreados = 0;
    	this.cantBombasCreados = 0;
    	this.cantBombasExplotadas = 0;
    	subma.sumarPuntos(200);
    	crearBarco();
    	for (int i = 0; i<this.CANT_BARCOS; i++)
		{
    		yaExploto [i]=false;
		}
    }

    public void actualizarPosicion() {
    	this.crearBarco();
    	barcos[this.cantBarcosCreados-1].actualizaPosicion();
    	completarVectorBombas();
    	for (int i = 0; i < this.cantBombasCreados; i++) { // aunque exploten que sigan los restos hasta desaparecer de pantalla
    		bombas[i].actualizaPosicion();
    		if (!yaExploto[i] && bombas[i].toView().getExploto()) {
    			explotoBomba(bombas[i].toView());
    			yaExploto[i] = true;
    			//System.out.println("exloto la bomba "+ i);
    		}
    	}
    }
    
    private void explotoBomba(BombaView bomba) {
	    this.subma.calcularDistancia(bomba.getPosicionX(),bomba.getPosicionY() );
	    this.cantBombasExplotadas++;
    	if (this.cantBombasExplotadas == this.CANT_BARCOS -1) cambiarNivel();
    		
    }
    
    
    
    private void completarVectorBombas() {
    	if (this.cantBarcosCreados > this.cantBombasCreados && barcos[this.cantBarcosCreados-1].tiroBomba()) {
    		this.bombas[this.cantBombasCreados] = barcos[this.cantBarcosCreados-1].getBomba();
    		this.cantBombasCreados++;
    		//System.out.println("se creo la bomba "+ (this.cantBombasCreados-1));
    	}
    }
 
    private void crearBarco() {
    	if (this.cantBarcosCreados == 0) {
	        barcos [ this.cantBarcosCreados] = new Barco(this.nivel);
	        actualizaContadorBarcos();}
    	else if((barcos[this.cantBarcosCreados-1].posicionX < -100 || barcos[this.cantBarcosCreados-1].posicionX > 600)&&this.cantBarcosCreados < this.CANT_BARCOS) {
    		barcos [ this.cantBarcosCreados] = new Barco(this.nivel);
	        actualizaContadorBarcos();
    	}
    }
    
    public BombaView[] BombatoView()  {
    	BombaView[] bombitas=new BombaView[10];
    	for (int i = 0; i < this.cantBombasCreados; i++)
    	{
	    		BombaView bombaview = bombas[i].toView();
	    		bombitas[i]=bombaview;
    	}
    	return bombitas;
    }
    
    private void actualizaContadorBarcos() {
        this.cantBarcosCreados ++;
        
    }
    public BarcoView BarcotoView()  {
    	return barcos[cantBarcosCreados-1].toView();
    }

    
   

}
