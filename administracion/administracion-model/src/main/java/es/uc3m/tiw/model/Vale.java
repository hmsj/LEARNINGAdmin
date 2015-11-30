package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vale implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVale;
	
	@Column(nullable=false)
	String codigoVale;
	
	@Column(nullable=false)
	String fechaCaducidad;
	
	@Column(nullable=false)
	Integer valorVale;

	public Vale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vale(String codigoVale, String fechaCaducidad, Integer valorVale) {
		super();
		this.codigoVale = codigoVale;
		this.fechaCaducidad = fechaCaducidad;
		this.valorVale = valorVale;
	}

	public Long getIdVale() {
		return idVale;
	}

	public void setIdVale(Long idVale) {
		this.idVale = idVale;
	}

	public String getCodigoVale() {
		return codigoVale;
	}

	public void setCodigoVale(String codigoVale) {
		this.codigoVale = codigoVale;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Integer getValorVale() {
		return valorVale;
	}

	public void setValorVale(Integer valorVale) {
		this.valorVale = valorVale;
	}
	
}
