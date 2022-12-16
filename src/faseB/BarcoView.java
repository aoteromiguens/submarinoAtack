package faseB;

public class BarcoView {
	private float posicionX;
	private float posicionY;
	private float tamañoLargo;
	private float tamañoAncho;
	private boolean tiroBomba;
	
	public BarcoView(float tamañoLargo ,float tamañoAncho,float posicionX,float posicionY, boolean tiroBomba) {
		this.setTamañoLargo(tamañoLargo);
		this.setTamañoAncho(tamañoAncho);
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

	public float getTamañoLargo() {
		return tamañoLargo;
	}

	public void setTamañoLargo(float tamañoLargo) {
		this.tamañoLargo = tamañoLargo;
	}

	public float getTamañoAncho() {
		return tamañoAncho;
	}

	public void setTamañoAncho(float tamañoAncho) {
		this.tamañoAncho = tamañoAncho;
	}

}
