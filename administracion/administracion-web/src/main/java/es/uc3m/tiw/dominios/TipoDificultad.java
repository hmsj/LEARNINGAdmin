package es.uc3m.tiw.dominios;

public class TipoDificultad {
	int idtipoDificultad;
	String descripcion_tipoDificultad;
	
	public TipoDificultad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoDificultad(int idtipoDificultad,
			String descripcion_tipoDificultad) {
		super();
		this.idtipoDificultad = idtipoDificultad;
		this.descripcion_tipoDificultad = descripcion_tipoDificultad;
	}

	public int getIdtipoDificultad() {
		return idtipoDificultad;
	}

	public void setIdtipoDificultad(int idtipoDificultad) {
		this.idtipoDificultad = idtipoDificultad;
	}

	public String getDescripcion_tipoDificultad() {
		return descripcion_tipoDificultad;
	}

	public void setDescripcion_tipoDificultad(String descripcion_tipoDificultad) {
		this.descripcion_tipoDificultad = descripcion_tipoDificultad;
	}
	
}
