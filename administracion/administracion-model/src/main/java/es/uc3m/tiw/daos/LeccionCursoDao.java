package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.LeccionCurso;

public interface LeccionCursoDao {
	
	public abstract LeccionCurso createLeccionCurso(LeccionCurso leccionCursoNueva) throws Exception;

}
