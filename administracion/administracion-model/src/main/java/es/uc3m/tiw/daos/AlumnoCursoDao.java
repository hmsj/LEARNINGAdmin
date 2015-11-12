package es.uc3m.tiw.daos;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.AlumnoCurso;

public interface AlumnoCursoDao {
	
	public abstract AlumnoCurso createAlumnoCurso(AlumnoCurso alumnoCursoNuevo) throws Exception;
	
	
}
