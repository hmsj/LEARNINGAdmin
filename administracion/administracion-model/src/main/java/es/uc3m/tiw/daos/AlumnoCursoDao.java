package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.AlumnoCurso;

public interface AlumnoCursoDao {
	
	public abstract AlumnoCurso createAlumnoCurso(AlumnoCurso alumnoCursoNuevo) throws Exception;
	
	public abstract void removeAlumno (AlumnoCurso alumnoCurso) throws Exception;
	
	public abstract AlumnoCurso modifyAlumnoCurso(AlumnoCurso alumnoCurso) throws Exception;

	public abstract List<AlumnoCurso> findAll() throws Exception;
	
	public abstract AlumnoCurso findByUsername(String alumnoUsername) throws Exception;

	public abstract AlumnoCurso comprobarAlumnoCursado(String alumnoUsername, long idCurso) throws Exception;

	public abstract AlumnoCurso comprobarAlumnoEnCurso(String alumnoUsername, long idCurso) throws Exception;
	
	public abstract List<AlumnoCurso> listadoAlumnosEnCurso(long idCurso) throws Exception;
	
	public abstract List<AlumnoCurso> listadoAlumnosCursado(long idCurso) throws Exception;

	public abstract AlumnoCurso comprobarAlumno(String nombreAlumno,
			long idCurso);
}
