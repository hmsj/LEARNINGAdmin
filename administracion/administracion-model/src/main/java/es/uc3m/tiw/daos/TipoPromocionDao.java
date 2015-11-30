package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.TipoPromocion;

public interface TipoPromocionDao {

	public abstract TipoPromocion createTipoPromocion(TipoPromocion tipoPromocionNuevo) throws Exception;

	public abstract List<TipoPromocion> findAll() throws Exception;
	
	public abstract TipoPromocion findById(int idTipoPromocion) throws Exception;
}
