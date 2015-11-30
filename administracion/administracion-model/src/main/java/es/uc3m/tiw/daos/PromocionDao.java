package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Promocion;

public interface PromocionDao {

	public abstract Promocion createPromocion(Promocion promocionNueva) throws Exception;

	public abstract void removePromocion (Promocion promocion) throws Exception;

	public abstract List<Promocion> findAll() throws Exception;
	
	public abstract Promocion findById(Long idPromocion) throws Exception;
}
