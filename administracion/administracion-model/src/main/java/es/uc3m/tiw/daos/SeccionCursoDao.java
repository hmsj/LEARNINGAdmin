package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.SeccionCurso;

public interface SeccionCursoDao {

	public abstract SeccionCurso createSeccionCurso(SeccionCurso seccionCursoNueva) throws Exception;

	public abstract void removeSeccion (SeccionCurso seccionCurso) throws Exception;

	public abstract List<SeccionCurso> findAll() throws Exception;
	
	public abstract SeccionCurso findById(Long idSeccion) throws Exception;

}
