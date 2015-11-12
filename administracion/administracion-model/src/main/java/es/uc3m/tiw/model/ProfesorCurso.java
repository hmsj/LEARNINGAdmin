package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ProfesorCurso implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProfesorCurso;
	
	@Column(nullable=false)
	private boolean titular;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario idUsuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Curso idCurso;

	public ProfesorCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfesorCurso(boolean titular, Usuario idUsuario, Curso idCurso) {
		super();
		this.titular = titular;
		this.idUsuario = idUsuario;
		this.idCurso = idCurso;
	}

	public Long getIdProfesorCurso() {
		return idProfesorCurso;
	}

	public void setIdProfesorCurso(Long idProfesorCurso) {
		this.idProfesorCurso = idProfesorCurso;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

}
