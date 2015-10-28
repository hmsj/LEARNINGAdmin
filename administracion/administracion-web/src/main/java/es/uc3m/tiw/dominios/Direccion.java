package es.uc3m.tiw.dominios;

import java.io.Serializable;

public class Direccion implements Serializable{
	int iddireccion;
	String calle;
	int numero;
	String ciudad;
	String pueblo;
	String codigoPostal;
	String pais;
	
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(int iddireccion, String calle, int numero, String ciudad,
			String pueblo, String codigoPostal, String pais) {
		super();
		this.iddireccion = iddireccion;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.pueblo = pueblo;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
	}

	public int getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
