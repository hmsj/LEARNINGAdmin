package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCurso;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	private double precioInicial;
	
	@Column(nullable=false)
	private boolean estado;
	
	@Column(nullable=false)
	private boolean destacado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario idUsuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Oferta idOferta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Logro idLogro;
}
