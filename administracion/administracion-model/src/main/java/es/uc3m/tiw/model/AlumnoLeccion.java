package es.uc3m.tiw.model;

import javax.faces.application.StateManager.SerializedView;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.io.Serializable;

public class AlumnoLeccion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAlumnoLeccion;
	
	@Column(nullable=true)
	private double notaLeccion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario idUsuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private LeccionCurso idLeccion;
	
}
