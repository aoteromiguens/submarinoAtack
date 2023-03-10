package faseB;

public class BarcoView {
	private float posicionX;
	private float posicionY;
	private float tamaņoLargo;
	private float tamaņoAncho;
	private boolean tiroBomba;
	
	public BarcoView(float tamaņoLargo ,float tamaņoAncho,float posicionX,float posicionY, boolean tiroBomba) {
		this.setTamaņoLargo(tamaņoLargo);
		this.setTamaņoAncho(tamaņoAncho);
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

	public float getTamaņoLargo() {
		return tamaņoLargo;
	}

	public void setTamaņoLargo(float tamaņoLargo) {
		this.tamaņoLargo = tamaņoLargo;
	}

	public float getTamaņoAncho() {
		return tamaņoAncho;
	}

	public void setTamaņoAncho(float tamaņoAncho) {
		this.tamaņoAncho = tamaņoAncho;
	}

}
