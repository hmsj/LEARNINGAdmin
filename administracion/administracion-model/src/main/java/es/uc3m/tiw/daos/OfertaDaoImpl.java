package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Oferta;

public class OfertaDaoImpl implements OfertaDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public OfertaDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Oferta createOferta(Oferta ofertaNueva) throws Exception{
		ut.begin();
		em.persist(ofertaNueva);
		ut.commit();
		return ofertaNueva;
	}
}
