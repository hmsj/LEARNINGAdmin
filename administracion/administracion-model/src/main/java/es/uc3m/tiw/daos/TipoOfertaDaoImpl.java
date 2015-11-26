package es.uc3m.tiw.daos;

import java.util.List;

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

	@Override
	public List<TipoOferta> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<TipoOferta> listadoTiposOferta = em.createQuery("SELECT t from TipoOferta t", TipoOferta.class).getResultList();
		return listadoTiposOferta;
	}

	@Override
	public TipoOferta findById(int idTipoOferta) throws Exception {
		// TODO Auto-generated method stub
		return em.find(TipoOferta.class, new Integer(idTipoOferta));
	}
}
