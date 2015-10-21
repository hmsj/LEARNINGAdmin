package es.uc3m.tiw.dominios;

public class ProfesorInvitado {
	Usuario usuario_username;
	Curso curso_idcurso;
	
	public ProfesorInvitado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfesorInvitado(Usuario usuario_username, Curso curso_idcurso) {
		super();
		this.usuario_username = usuario_username;
		this.curso_idcurso = curso_idcurso;
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
	
}
