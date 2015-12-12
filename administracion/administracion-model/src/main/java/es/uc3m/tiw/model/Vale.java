package es.uc3m.tiw.model;

import java.io.Serializable;
import java.sql.Date;

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
	Date fechaCaducidad;
	
	@Column(nullable=false)
	Double valorVale;

	@Column(nullable=false)
	Integer numCursosInsc;
	
	@Column(nullable=false)
	Double costeMinimoAlumno;
	public Vale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vale(String codigoVale, Date fechaCaducidad, Double valorVale,
			Integer numCursosInsc, Double costeMinimoAlumno) {
		super();
		this.codigoVale = codigoVale;
		this.fechaCaducidad = fechaCaducidad;
		this.valorVale = valorVale;
		this.numCursosInsc = numCursosInsc;
		this.costeMinimoAlumno = costeMinimoAlumno;
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
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Double getValorVale() {
		return valorVale;
	}
	public void setValorVale(Double valorVale) {
		this.valorVale = valorVale;
	}
	public Integer getNumCursosInsc() {
		return numCursosInsc;
	}
	public void setNumCursosInsc(Integer numCursosInsc) {
		this.numCursosInsc = numCursosInsc;
	}
	public Double getCosteMinimoAlumno() {
		return costeMinimoAlumno;
	}
	public void setCosteMinimoAlumno(Double costeMinimoAlumno) {
		this.costeMinimoAlumno = costeMinimoAlumno;
	}
}
