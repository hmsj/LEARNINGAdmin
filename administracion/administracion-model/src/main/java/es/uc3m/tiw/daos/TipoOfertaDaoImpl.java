package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.TipoOferta;

public class TipoOfertaDaoImpl implements TipoOfertaDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public TipoOfertaDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public TipoOferta createTipoOferta(TipoOferta tipoOfertaNuevo) throws Exception{
		ut.begin();
		em.persist(tipoOfertaNuevo);
		ut.commit();
		return tipoOfertaNuevo;
	}
}
