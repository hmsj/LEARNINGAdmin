package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Vale;

public interface ValeDao {

	public abstract Vale createVale(Vale valeNuevo) throws Exception;

	public abstract void removeVale (Vale vale) throws Exception;

	public abstract List<Vale> findAll() throws Exception;
	
	public abstract Vale findById(Long idVale) throws Exception;
}
