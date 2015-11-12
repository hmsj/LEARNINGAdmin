package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class LeccionCurso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLeccion;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SeccionCurso idSeccion;

	public LeccionCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeccionCurso(String titulo, String descripcion,
			SeccionCurso idSeccion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idSeccion = idSeccion;
	}

	public Long getIdLeccion() {
		return idLeccion;
	}

	public void setIdLeccion(Long idLeccion) {
		this.idLeccion = idLeccion;
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

	public SeccionCurso getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(SeccionCurso idSeccion) {
		this.idSeccion = idSeccion;
	}

}
