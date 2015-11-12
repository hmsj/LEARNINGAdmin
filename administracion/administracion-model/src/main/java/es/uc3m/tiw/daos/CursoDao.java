package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Curso;

public interface CursoDao {
	
	public abstract Curso createCurso(Curso cursoNuevo) throws Exception;

}
