package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class SeccionCurso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSeccion;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Curso idCurso;

	public SeccionCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeccionCurso(String titulo, String descripcion, Curso idCurso) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idCurso = idCurso;
	}

	public Long getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
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

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

}
