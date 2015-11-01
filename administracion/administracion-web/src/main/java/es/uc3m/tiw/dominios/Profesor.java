package es.uc3m.tiw.dominios;

import java.io.Serializable;

public class Profesor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5239875224782443362L;
	Usuario usuario_username;
	Curso curso_idcurso;
	boolean esTitular;
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(Usuario usuario_username, Curso curso_idcurso, boolean esTitular) {
		super();
		this.usuario_username = usuario_username;
		this.curso_idcurso = curso_idcurso;
		this.esTitular = esTitular;
	}

	public Profesor(Usuario usuario_username, Curso curso_idcurso) {
		super();
		this.usuario_username = usuario_username;
		this.curso_idcurso = curso_idcurso;
		this.esTitular = false;
	}
	
	public Usuario getUsuario_username() {
		return usuario_username;
	}

	public void setUsuario_username(Usuario usuario_username) {
		this.usuario_username = usuario_username;
	}

	public Curso getCurso_idcurso() {
		return curso_idcurso;
	}

	public void setCurso_idcurso(Curso curso_idcurso) {
		this.curso_idcurso = curso_idcurso;
	}

	public final boolean isEsTitular() {
		return esTitular;
	}

	public final void setEsTitular(boolean esTitular) {
		this.esTitular = esTitular;
	}
	
}
