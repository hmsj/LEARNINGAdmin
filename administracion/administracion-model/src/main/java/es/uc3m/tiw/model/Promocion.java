package es.uc3m.tiw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Promocion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPromocion;
	
	@Column(unique = true)
	private String nombrePromocion;
	
	@Column(nullable=false)
	private double valor;
	
	@Column(nullable=false)
	private Date fechaFin;
	
	@ManyToOne
	private TipoPromocion tipoPromocion;

	public Promocion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promocion(String nombrePromocion, double valor, Date fechaFin, TipoPromocion tipoPromocion) {
		super();
		this.nombrePromocion = nombrePromocion;
		this.valor = valor;
		this.fechaFin = fechaFin;
		this.tipoPromocion = tipoPromocion;
		
	}

	public Long getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Long idPromocion) {
		this.idPromocion = idPromocion;
	}
	
	public String getNombrePromocion() {
		return nombrePromocion;
	}

	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public TipoPromocion getTipoPromocion() {
		return tipoPromocion;
	}

	public void setTipoPromocion(TipoPromocion tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

}
