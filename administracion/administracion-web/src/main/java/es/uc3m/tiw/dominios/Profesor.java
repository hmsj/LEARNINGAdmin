package es.uc3m.tiw.dominios;

public class Profesor {
	int tipo=2;
	Usuario usuario;
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(int tipo, Usuario usuario) {
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
