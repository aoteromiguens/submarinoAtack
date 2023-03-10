package faseB;

public class BombaView {
	private float posicionX;
	private float posicionY;
	private float tamaņoLargo;
	private float tamaņoAncho;
	private boolean exploto;
	
	public BombaView(float tamaņoLargo ,float tamaņoAncho,float posicionX,float posicionY, boolean exploto) {
		this.tamaņoLargo=tamaņoLargo;
		this.tamaņoAncho=tamaņoAncho;
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setExploto(exploto);
		
	}
	
	private void setExploto(boolean exploto) {
		this.exploto=exploto;
	}
	
	public boolean getExploto() {
		return this.exploto;
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

}
