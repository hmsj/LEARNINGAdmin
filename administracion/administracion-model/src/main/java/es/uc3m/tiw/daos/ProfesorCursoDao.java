package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.ProfesorCurso;

public interface ProfesorCursoDao {
	
	public abstract ProfesorCurso createProfesorCurso(ProfesorCurso profesorCursoNuevo) throws Exception;

	public abstract void removeProfesor (ProfesorCurso profesorCurso) throws Exception;

	public abstract List<ProfesorCurso> findAll() throws Exception;
	
	public abstract ProfesorCurso findByUsername(String profesorUsername) throws Exception;

	public abstract ProfesorCurso comprobarProfesorInvitado(String profeInvUsername,
			long idCurso) throws Exception;
	
	public abstract ProfesorCurso comprobarProfesorTitular(String profeTitUsername,
			long idCurso) throws Exception;
	
	public abstract List<ProfesorCurso> listadoProfesInvitados(long idCurso) throws Exception;
}
