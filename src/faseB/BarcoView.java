package faseB;

public class BarcoView {
	private float posicionX;
	private float posicionY;
	private float tama�oLargo;
	private float tama�oAncho;
	private boolean tiroBomba;
	
	public BarcoView(float tama�oLargo ,float tama�oAncho,float posicionX,float posicionY, boolean tiroBomba) {
		this.setTama�oLargo(tama�oLargo);
		this.setTama�oAncho(tama�oAncho);
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setTiroBomba(tiroBomba);
		
	}
	
	private void setTiroBomba(boolean tiroBomba) {
		this.tiroBomba=tiroBomba;
	}
	
	public boolean getTiroBomba() {
		return this.tiroBomba;
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

	public float getTama�oLargo() {
		return tama�oLargo;
	}

	public void setTama�oLargo(float tama�oLargo) {
		this.tama�oLargo = tama�oLargo;
	}

	public float getTama�oAncho() {
		return tama�oAncho;
	}

	public void setTama�oAncho(float tama�oAncho) {
		this.tama�oAncho = tama�oAncho;
	}

}
