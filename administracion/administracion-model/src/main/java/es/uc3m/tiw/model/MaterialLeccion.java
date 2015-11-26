package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MaterialLeccion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMaterial;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	private String fichero;
	
	@ManyToOne
	private LeccionCurso idLeccion;
	
	public MaterialLeccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaterialLeccion(String titulo, String descripcion, String fichero,
			LeccionCurso idLeccion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fichero = fichero;
		this.idLeccion = idLeccion;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	public LeccionCurso getIdLeccion() {
		return idLeccion;
	}

	public void setIdLeccion(LeccionCurso idLeccion) {
		this.idLeccion = idLeccion;
	}

	
}
