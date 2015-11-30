package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPromocion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idTipoPromocion;
	
	@Column(nullable=false)
	private String descripcionTipoPromocion;

	public TipoPromocion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoPromocion(int idTipoPromocion, String descripcionTipoPromocion) {
		super();
		this.idTipoPromocion = idTipoPromocion;
		this.descripcionTipoPromocion = descripcionTipoPromocion;
	}

	public int getIdTipoPromocion() {
		return idTipoPromocion;
	}

	public void setIdTipoPromocion(int idTipoPromocion) {
		this.idTipoPromocion = idTipoPromocion;
	}

	public String getDescripcionTipoPromocion() {
		return descripcionTipoPromocion;
	}

	public void setDescripcionTipoPromocion(String descripcionTipoPromocion) {
		this.descripcionTipoPromocion = descripcionTipoPromocion;
	}

}
