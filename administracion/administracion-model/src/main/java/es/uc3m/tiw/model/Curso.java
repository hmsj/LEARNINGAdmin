package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
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
	
	@Column(nullable=true)
	private String imagen;
	
	@OneToOne
	private Oferta idOferta;
	
	@OneToOne
	private Categoria idCategoria;
	
	@OneToOne
	private Dificultad idDificultad;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(String titulo, String descripcion, double precioInicial,
			boolean estado, boolean destacado, String imagen, Oferta idOferta,
			Categoria idCategoria, Dificultad idDificultad) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precioInicial = precioInicial;
		this.estado = estado;
		this.destacado = destacado;
		this.imagen = imagen;
		this.idOferta = idOferta;
		this.idCategoria = idCategoria;
		this.idDificultad = idDificultad;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
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

	public double getPrecioInicial() {
		return precioInicial;
	}

	public void setPrecioInicial(double precioInicial) {
		this.precioInicial = precioInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isDestacado() {
		return destacado;
	}

	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Oferta getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Oferta idOferta) {
		this.idOferta = idOferta;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Dificultad getIdDificultad() {
		return idDificultad;
	}

	public void setIdDificultad(Dificultad idDificultad) {
		this.idDificultad = idDificultad;
	}
	
}
