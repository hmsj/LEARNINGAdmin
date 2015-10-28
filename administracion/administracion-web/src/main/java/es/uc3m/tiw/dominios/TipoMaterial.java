package es.uc3m.tiw.dominios;

import java.io.Serializable;

public class TipoMaterial implements Serializable{
	int idtipoMaterial;
	String descripcion_tipoMaterial;
	
	public TipoMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoMaterial(int idtipoMaterial, String descripcion_tipoMaterial) {
		super();
		this.idtipoMaterial = idtipoMaterial;
		this.descripcion_tipoMaterial = descripcion_tipoMaterial;
	}

	public int getIdtipoMaterial() {
		return idtipoMaterial;
	}

	public void setIdtipoMaterial(int idtipoMaterial) {
		this.idtipoMaterial = idtipoMaterial;
	}

	public String getDescripcion_tipoMaterial() {
		return descripcion_tipoMaterial;
	}

	public void setDescripcion_tipoMaterial(String descripcion_tipoMaterial) {
		this.descripcion_tipoMaterial = descripcion_tipoMaterial;
	}
	
}
