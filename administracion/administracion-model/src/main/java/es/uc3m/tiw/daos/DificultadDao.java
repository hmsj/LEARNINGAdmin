package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Dificultad;

public interface DificultadDao {
	
	public abstract Dificultad createDificultad(Dificultad dificultadNueva) throws Exception;

	public abstract List<Dificultad> findAll() throws Exception;
	
	public abstract Dificultad findById(int idDificultad) throws Exception;
}
