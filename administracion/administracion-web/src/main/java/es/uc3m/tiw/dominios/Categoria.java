package es.uc3m.tiw.dominios;

public class Categoria {
	int idcategoria;
	String descripcion_categoria;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int idcategoria, String descripcion_categoria) {
		super();
		this.idcategoria = idcategoria;
		this.descripcion_categoria = descripcion_categoria;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}
		
}
