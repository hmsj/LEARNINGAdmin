package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Categoria;

public interface CategoriaDao {
	
	public abstract Categoria createCategoria(Categoria categoriaNueva) throws Exception;

}
