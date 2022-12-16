package faseB;

public class BombaView {
	private float posicionX;
	private float posicionY;
	private float tamañoLargo;
	private float tamañoAncho;
	private boolean exploto;
	
	public BombaView(float tamañoLargo ,float tamañoAncho,float posicionX,float posicionY, boolean exploto) {
		this.tamañoLargo=tamañoLargo;
		this.tamañoAncho=tamañoAncho;
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
