package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.TipoOferta;

public interface TipoOfertaDao {

	public abstract TipoOferta createTipoOferta(TipoOferta tipoOfertaNuevo) throws Exception;

}
