package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Curso;

public interface CursoDao {
	
	public abstract Curso createCurso(Curso cursoNuevo) throws Exception;
	
	public abstract void removeCurso (Curso curso) throws Exception;

	public abstract Curso modifyCurso(Curso curso) throws Exception;

	public abstract List<Curso> findAll() throws Exception;
	
	public abstract Curso findById(Long idCurso) throws Exception;
}
