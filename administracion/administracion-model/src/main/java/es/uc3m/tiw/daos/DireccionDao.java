package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Direccion;

public interface DireccionDao {
	
	public abstract Direccion createDireccion(Direccion direccionNueva) throws Exception;

	public abstract void removeDireccion (Direccion direccion) throws Exception;
	
	public abstract Direccion modifyDireccion(Direccion direccion) throws Exception;

	public abstract Direccion findById(Long idDireccion) throws Exception;

}
