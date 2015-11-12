package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoOferta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idTipoOferta;
	
	@Column(nullable=false)
	private String descripcionTipoOferta;

	public TipoOferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoOferta(int idTipoOferta, String descripcionTipoOferta) {
		super();
		this.idTipoOferta = idTipoOferta;
		this.descripcionTipoOferta = descripcionTipoOferta;
	}

	public int getIdTipoOferta() {
		return idTipoOferta;
	}

	public void setIdTipoOferta(int idTipoOferta) {
		this.idTipoOferta = idTipoOferta;
	}

	public String getDescripcionTipoOferta() {
		return descripcionTipoOferta;
	}

	public void setDescripcionTipoOferta(String descripcionTipoOferta) {
		this.descripcionTipoOferta = descripcionTipoOferta;
	}

}
