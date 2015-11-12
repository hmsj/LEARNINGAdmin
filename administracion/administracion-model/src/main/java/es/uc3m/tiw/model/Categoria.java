package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idCategoria;
	
	@Column(nullable=false)
	private String descripcionCategoria;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long idCategoria, String descripcionCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

}
