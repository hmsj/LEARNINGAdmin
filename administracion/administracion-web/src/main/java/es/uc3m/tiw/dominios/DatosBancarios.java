package es.uc3m.tiw.dominios;

import java.io.Serializable;

public class DatosBancarios implements Serializable{
	int iddatosBancarios;
	String tarjeta;
	String fecha_caducidad;
	int cvv;
	
	public DatosBancarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosBancarios(int iddatosBancarios, String tarjeta,
			String fecha_caducidad, int cvv) {
		super();
		this.iddatosBancarios = iddatosBancarios;
		this.tarjeta = tarjeta;
		this.fecha_caducidad = fecha_caducidad;
		this.cvv = cvv;
	}

	public int getIddatosBancarios() {
		return iddatosBancarios;
	}

	public void setIddatosBancarios(int iddatosBancarios) {
		this.iddatosBancarios = iddatosBancarios;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(String fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
}
