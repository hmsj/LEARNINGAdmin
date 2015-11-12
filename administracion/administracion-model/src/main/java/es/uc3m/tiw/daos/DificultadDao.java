package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Dificultad;

public interface DificultadDao {
	
	public abstract Dificultad createDificultad(Dificultad dificultadNueva) throws Exception;

}
