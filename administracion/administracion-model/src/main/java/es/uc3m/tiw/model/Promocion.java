package es.uc3m.tiw.model;

import java.io.Serializable;

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
	private String fechaFin;
	
	@ManyToOne
	private TipoPromocion tipoPromocion;

	public Promocion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promocion(String nombrePromocion, double valor, String fechaFin, TipoPromocion tipoPromocion) {
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

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public TipoPromocion getTipoPromocion() {
		return tipoPromocion;
	}

	public void setTipoPromocion(TipoPromocion tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

}
