package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Categoria;

public interface CategoriaDao {
	
	public abstract Categoria createCategoria(Categoria categoriaNueva) throws Exception;
	
	public abstract List<Categoria> findAll() throws Exception;
	
	public abstract Categoria findById(int idCategoria) throws Exception;

}
