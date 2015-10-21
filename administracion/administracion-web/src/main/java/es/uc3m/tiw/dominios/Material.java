package es.uc3m.tiw.dominios;

public class Material {
	int idmaterial;
	TipoMaterial tipoMaterial;
	Leccion leccion;
	String archivo;
	
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Material(int idmaterial, TipoMaterial tipoMaterial, Leccion leccion,
			String archivo) {
		super();
		this.idmaterial = idmaterial;
		this.tipoMaterial = tipoMaterial;
		this.leccion = leccion;
		this.archivo = archivo;
	}

	public int getIdmaterial() {
		return idmaterial;
	}

	public void setIdmaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}

	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public Leccion getLeccion() {
		return leccion;
	}

	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
}
