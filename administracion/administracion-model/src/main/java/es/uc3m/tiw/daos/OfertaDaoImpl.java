package es.uc3m.tiw.daos;

import java.util.List;

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

	@Override
	public void removeOferta(Oferta oferta) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(oferta));
		ut.commit();
	}
	
	@Override
	public List<Oferta> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Oferta> listadoOfertas = em.createQuery("SELECT o from Oferta o", Oferta.class).getResultList();
		return listadoOfertas;
	}

	@Override
	public Oferta findById(Long idOferta) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Oferta.class, new Long(idOferta));
	}

}
