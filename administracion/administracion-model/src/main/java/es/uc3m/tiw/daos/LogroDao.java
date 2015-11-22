package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Logro;

public interface LogroDao {

	public abstract Logro createLogro(Logro logroNuevo) throws Exception;

	public abstract List<Logro> findAll() throws Exception;
	
	public abstract Logro findById(int idLogro) throws Exception;
}
