package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Dificultad implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idDificultad;
	
	@Column(nullable=false)
	private String descripcionDificultad;

	public Dificultad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dificultad(Long idDificultad, String descripcionDificultad) {
		super();
		this.idDificultad = idDificultad;
		this.descripcionDificultad = descripcionDificultad;
	}

	public Long getIdDificultad() {
		return idDificultad;
	}

	public void setIdDificultad(Long idDificultad) {
		this.idDificultad = idDificultad;
	}

	public String getDescripcionDificultad() {
		return descripcionDificultad;
	}

	public void setDescripcionDificultad(String descripcionDificultad) {
		this.descripcionDificultad = descripcionDificultad;
	}
	
}
