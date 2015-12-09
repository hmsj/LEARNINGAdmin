package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.LeccionCurso;

public interface LeccionCursoDao {
	
	public abstract LeccionCurso createLeccionCurso(LeccionCurso leccionCursoNueva) throws Exception;

	public abstract void removeLeccion (LeccionCurso leccionCurso) throws Exception;

	public abstract LeccionCurso modifyLeccionCurso(LeccionCurso leccionCurso) throws Exception;

	public abstract List<LeccionCurso> findAll() throws Exception;
	
	public abstract LeccionCurso findById (Long idLeccion) throws Exception;
	
	public abstract List<LeccionCurso> ListadoLeccionesUnaSeccion (Long idSeccion) throws Exception;
	
	public abstract List<LeccionCurso> ListadoLeccionesUnCurso (Long idCurso) throws Exception;

}
