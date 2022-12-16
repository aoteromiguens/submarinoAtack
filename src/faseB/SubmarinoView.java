package faseB;

public class SubmarinoView {
	  private int cantPuntos;
	    private int cantVidas;
	    private float HP;
	    private float posicionX;
	    private float posicionY;
	    public SubmarinoView(int cantPuntos,int cantVidas,float HP,float posicionX,float posicionY) {
			this.setCantPuntos(cantPuntos);
			this.setCantVidas(cantVidas);
			this.setHP(HP);
			this.setPosicionX(posicionX);
			this.setPosicionY(posicionY);
			
		}

		public float getPosicionX() {
			return posicionX;
		}

		public void setPosicionX(float posicionX) {
			this.posicionX = posicionX;
		}

		public float getPosicionY() {
			return posicionY;
		}

		public void setPosicionY(float posicionY) {
			this.posicionY = posicionY;
		}

		public int getCantPuntos() {
			return cantPuntos;
		}

		public void setCantPuntos(int cantPuntos) {
			this.cantPuntos = cantPuntos;
		}

		public int getCantVidas() {
			return cantVidas;
		}

		public void setCantVidas(int cantVidas) {
			this.cantVidas = cantVidas;
		}

		public float getHP() {
			return HP;
		}

		public void setHP(float hP) {
			HP = hP;
		}
}
