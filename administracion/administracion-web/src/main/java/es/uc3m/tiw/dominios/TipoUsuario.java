package es.uc3m.tiw.dominios;

import java.io.Serializable;

public class TipoUsuario implements Serializable{
	int idtipoUsuario;
	String descripcion_tipoUsuario;
	
	public TipoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoUsuario(int idtipoUsuario, String descripcion_tipoUsuario) {
		super();
		this.idtipoUsuario = idtipoUsuario;
		this.descripcion_tipoUsuario = descripcion_tipoUsuario;
	}

	public int getIdtipoUsuario() {
		return idtipoUsuario;
	}

	public void setIdtipoUsuario(int idtipoUsuario) {
		this.idtipoUsuario = idtipoUsuario;
	}

	public String getDescripcion_tipoUsuario() {
		return descripcion_tipoUsuario;
	}

	public void setDescripcion_tipoUsuario(String descripcion_tipoUsuario) {
		this.descripcion_tipoUsuario = descripcion_tipoUsuario;
	}
	
}
