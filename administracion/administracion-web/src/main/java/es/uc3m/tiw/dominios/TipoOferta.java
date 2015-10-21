package es.uc3m.tiw.dominios;

public class TipoOferta {
	int idtipoOferta;
	String descripcion_tipoOferta;
	
	public TipoOferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoOferta(int idtipoOferta, String descripcion_tipoOferta) {
		super();
		this.idtipoOferta = idtipoOferta;
		this.descripcion_tipoOferta = descripcion_tipoOferta;
	}

	public int getIdtipoOferta() {
		return idtipoOferta;
	}

	public void setIdtipoOferta(int idtipoOferta) {
		this.idtipoOferta = idtipoOferta;
	}

	public String getDescripcion_tipoOferta() {
		return descripcion_tipoOferta;
	}

	public void setDescripcion_tipoOferta(String descripcion_tipoOferta) {
		this.descripcion_tipoOferta = descripcion_tipoOferta;
	}
	
}
