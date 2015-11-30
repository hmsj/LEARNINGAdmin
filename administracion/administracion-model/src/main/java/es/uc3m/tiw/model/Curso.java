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
	private boolean validado;
	
	@Column(nullable=false)
	private boolean destacado;
	
	@Column(nullable=true)
	private String imagen;
	
	@OneToOne(optional = true) 
	private Promocion idPromocion;
	
	@OneToOne(optional = true) 
	private Vale idVale;
	
	@OneToOne
	private Categoria idCategoria;
	
	@OneToOne
	private Dificultad idDificultad;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(String titulo, String descripcion, double precioInicial,
			boolean validado, boolean destacado, String imagen, Promocion idPromocion, Vale idVale,
			Categoria idCategoria, Dificultad idDificultad) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precioInicial = precioInicial;
		this.validado = validado;
		this.destacado = destacado;
		this.imagen = imagen;
		this.idPromocion = idPromocion;
		this.idVale = idVale;
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

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
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

	public Promocion getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Promocion idPromocion) {
		this.idPromocion = idPromocion;
	}
	
	public Vale getIdVale() {
		return idVale;
	}

	public void setIdVale(Vale idVale) {
		this.idVale = idVale;
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
