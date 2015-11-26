package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ListaDeseos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idListaDeseos;
	
	@ManyToOne
	private Usuario idUsuario;
	
	@ManyToOne
	private Curso idCurso;

	public ListaDeseos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaDeseos(Usuario idUsuario, Curso idCurso) {
		super();
		this.idUsuario = idUsuario;
		this.idCurso = idCurso;
	}

	public Long getIdListaDeseos() {
		return idListaDeseos;
	}

	public void setIdListaDeseos(Long idListaDeseos) {
		this.idListaDeseos = idListaDeseos;
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
