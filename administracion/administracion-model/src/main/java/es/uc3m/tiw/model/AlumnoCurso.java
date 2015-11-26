package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class AlumnoCurso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAlumnoCurso;
	
	@Column(nullable=true)
	private double notaMedia;
	
	@Column(nullable=false)
	private boolean enCurso;
	
	@ManyToOne
	private Usuario idUsuario;
	
	@ManyToOne
	private Curso idCurso;
	
	@ManyToOne
	private Logro idLogro;

	public AlumnoCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlumnoCurso(double notaMedia,boolean enCurso, Usuario idUsuario, Curso idCurso,
			Logro idLogro) {
		super();
		this.notaMedia = notaMedia;
		this.enCurso = enCurso;
		this.idUsuario = idUsuario;
		this.idCurso = idCurso;
		this.idLogro = idLogro;
	}

	public Long getIdAlumnoCurso() {
		return idAlumnoCurso;
	}

	public void setIdAlumnoCurso(Long idAlumnoCurso) {
		this.idAlumnoCurso = idAlumnoCurso;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
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

	public Logro getIdLogro() {
		return idLogro;
	}

	public void setIdLogro(Logro idLogro) {
		this.idLogro = idLogro;
	}

}
