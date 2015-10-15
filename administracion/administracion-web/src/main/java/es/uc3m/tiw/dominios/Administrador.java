package es.uc3m.tiw.dominios;

public class Administrador {
	int tipo=1;
	Usuario usuario;
	
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(int tipo, Usuario usuario) {
		super();
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
