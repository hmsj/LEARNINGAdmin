package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.Usuario;

public interface ProfesorCursoDao {
	
	public abstract ProfesorCurso createProfesorCurso(ProfesorCurso profesorCursoNuevo) throws Exception;

	public abstract void removeProfesor (ProfesorCurso profesorCurso) throws Exception;

	public abstract List<ProfesorCurso> findAll() throws Exception;
	
	public abstract ProfesorCurso findByUsername(String profesorUsername) throws Exception;

	public abstract ProfesorCurso comprobarProfesorInvitado(String profeInvUsername,
			long idCurso) throws Exception;
	
	public abstract ProfesorCurso comprobarProfesorTitularUnCurso(String profeTitUsername,
			long idCurso) throws Exception;
	
	public abstract List<ProfesorCurso> listadoProfesInvitadosUnCurso(long idCurso) throws Exception;
	
	public abstract ProfesorCurso ProfeTitularCurso(long idCurso) throws Exception; 

	public abstract List<ProfesorCurso> listadoProfesTitulares() throws Exception;
	
	public abstract List<ProfesorCurso> cursosByProfe(String username) throws Exception;
	
	public abstract List<ProfesorCurso> listadoTitularById (Long idUsuario) throws Exception;
}
