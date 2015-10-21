package es.uc3m.tiw.dominios;

public class TipoLogro {
	int idtipoLogro;
	String descripcion_tipoLogro;
	
	public TipoLogro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoLogro(int idtipoLogro, String descripcion_tipoLogro) {
		super();
		this.idtipoLogro = idtipoLogro;
		this.descripcion_tipoLogro = descripcion_tipoLogro;
	}

	public int getIdtipoLogro() {
		return idtipoLogro;
	}

	public void setIdtipoLogro(int idtipoLogro) {
		this.idtipoLogro = idtipoLogro;
	}

	public String getDescripcion_tipoLogro() {
		return descripcion_tipoLogro;
	}

	public void setDescripcion_tipoLogro(String descripcion_tipoLogro) {
		this.descripcion_tipoLogro = descripcion_tipoLogro;
	}
	
}
