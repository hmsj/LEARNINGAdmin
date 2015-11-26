package es.uc3m.tiw.model;

import javax.faces.application.StateManager.SerializedView;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class AlumnoLeccion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAlumnoLeccion;
	
	@Column(nullable=true)
	private double notaLeccion;
	
	@ManyToOne
	private Usuario idUsuario;
	
	@ManyToOne
	private LeccionCurso idLeccion;

	public AlumnoLeccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlumnoLeccion(double notaLeccion, Usuario idUsuario,
			LeccionCurso idLeccion) {
		super();
		this.notaLeccion = notaLeccion;
		this.idUsuario = idUsuario;
		this.idLeccion = idLeccion;
	}

	public Long getIdAlumnoLeccion() {
		return idAlumnoLeccion;
	}

	public void setIdAlumnoLeccion(Long idAlumnoLeccion) {
		this.idAlumnoLeccion = idAlumnoLeccion;
	}

	public double getNotaLeccion() {
		return notaLeccion;
	}

	public void setNotaLeccion(double notaLeccion) {
		this.notaLeccion = notaLeccion;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LeccionCurso getIdLeccion() {
		return idLeccion;
	}

	public void setIdLeccion(LeccionCurso idLeccion) {
		this.idLeccion = idLeccion;
	}
	
}
