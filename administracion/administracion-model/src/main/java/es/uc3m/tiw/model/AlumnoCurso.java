package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.*;

public class AlumnoCurso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAlumnoCurso;
	
	@Column(nullable=true)
	private double notaMedia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario idUsuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Curso idCurso;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Logro idLogro;
	
}
