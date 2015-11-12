package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TipoOferta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idTipoOferta;
	
	@Column(nullable=false)
	private String descripcionTipoOferta;

	public TipoOferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoOferta(Long idTipoOferta, String descripcionTipoOferta) {
		super();
		this.idTipoOferta = idTipoOferta;
		this.descripcionTipoOferta = descripcionTipoOferta;
	}

	public Long getIdTipoOferta() {
		return idTipoOferta;
	}

	public void setIdTipoOferta(Long idTipoOferta) {
		this.idTipoOferta = idTipoOferta;
	}

	public String getDescripcionTipoOferta() {
		return descripcionTipoOferta;
	}

	public void setDescripcionTipoOferta(String descripcionTipoOferta) {
		this.descripcionTipoOferta = descripcionTipoOferta;
	}

}
