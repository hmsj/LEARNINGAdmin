package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Oferta;

public interface OfertaDao {

	public abstract Oferta createOferta(Oferta ofertaNueva) throws Exception;

	public abstract void removeOferta (Oferta oferta) throws Exception;

	public abstract List<Oferta> findAll() throws Exception;
	
	public abstract Oferta findById(Long idOferta) throws Exception;
}
