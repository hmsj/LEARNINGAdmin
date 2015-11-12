package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Oferta;

public interface OfertaDao {

	public abstract Oferta createCurso(Oferta ofertaNueva) throws Exception;

}
