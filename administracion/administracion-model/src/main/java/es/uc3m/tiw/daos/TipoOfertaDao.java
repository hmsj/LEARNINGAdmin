package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.TipoOferta;

public interface TipoOfertaDao {

	public abstract TipoOferta createTipoOferta(TipoOferta tipoOfertaNuevo) throws Exception;

	public abstract List<TipoOferta> findAll() throws Exception;
	
	public abstract TipoOferta findById(int idTipoOferta) throws Exception;
}
