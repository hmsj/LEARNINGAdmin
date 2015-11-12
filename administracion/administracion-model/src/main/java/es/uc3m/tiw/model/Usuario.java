package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido;
	
	@Column(nullable=true)
	private String descripcion;
	
	@Column(nullable=true)
	private String intereses;
	
	@Column(nullable=true)
	private String imagen;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Oferta idOferta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Direccion idDireccion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Banco idBanco;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String username, String nombre, String apellido,
			String descripcion, String intereses, String imagen,
			Oferta idOferta, Direccion idDireccion, Banco idBanco) {
		super();
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.descripcion = descripcion;
		this.intereses = intereses;
		this.imagen = imagen;
		this.idOferta = idOferta;
		this.idDireccion = idDireccion;
		this.idBanco = idBanco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIntereses() {
		return intereses;
	}

	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Oferta getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Oferta idOferta) {
		this.idOferta = idOferta;
	}

	public Direccion getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Direccion idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Banco getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Banco idBanco) {
		this.idBanco = idBanco;
	}

}
