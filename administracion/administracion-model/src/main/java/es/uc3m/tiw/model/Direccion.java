package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Direccion implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDireccion;
	
	@Column(nullable=false)
	private String pais;
	
	@Column(nullable=false)
	private String ciudad;
	
	@Column(nullable=false)
	private String calle;
	
	@Column(nullable=false)
	private int numero;
	
	@Column(nullable=true)
	private String piso;
	
	@Column(nullable=true)
	private String telefono;
	
	@Column(nullable=false)
	private String codigoPostal;

	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(String pais, String ciudad, String calle, int numero,
			String piso, String telefono, String codigoPostal) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.telefono = telefono;
		this.codigoPostal = codigoPostal;
	}

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
}
