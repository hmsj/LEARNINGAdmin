package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Usuario;

public interface AlumnoCursoDao {
	
	public abstract AlumnoCurso createAlumnoCurso(AlumnoCurso alumnoCursoNuevo) throws Exception;
	
	public abstract void removeAlumno (AlumnoCurso alumnoCurso) throws Exception;
	
	public abstract AlumnoCurso modifyAlumnoCurso(AlumnoCurso alumnoCurso) throws Exception;

	public abstract List<AlumnoCurso> findAll() throws Exception;
	
	public abstract AlumnoCurso findByUsername(String alumnoUsername) throws Exception;

	public abstract AlumnoCurso comprobarAlumnoCursado(String alumnoUsername, long idCurso) throws Exception;

	public abstract AlumnoCurso comprobarAlumnoEnCurso(String alumnoUsername, long idCurso) throws Exception;
	
	public abstract List<AlumnoCurso> listadoAlumnosEnUnCurso(long idCurso) throws Exception;
	
	public abstract List<AlumnoCurso> listadoAlumnosUnCursado(long idCurso) throws Exception;;

	public abstract List<AlumnoCurso> listadoAlumnosEnCurso() throws Exception;

	public abstract List<AlumnoCurso> listadoAlumnosCursado() throws Exception;
	
	public abstract List<AlumnoCurso> listadoAlumnosEnCursoById(Long idUsuario) throws Exception;
	
	public abstract List<AlumnoCurso> listadoAlumnosCursadoById(Long idUsuario) throws Exception;

}
