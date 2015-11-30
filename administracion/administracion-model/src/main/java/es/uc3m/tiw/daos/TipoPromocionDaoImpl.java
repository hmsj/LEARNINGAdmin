package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.TipoPromocion;

public class TipoPromocionDaoImpl implements TipoPromocionDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public TipoPromocionDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public TipoPromocion createTipoPromocion(TipoPromocion tipoPromocionNuevo) throws Exception{
		ut.begin();
		em.persist(tipoPromocionNuevo);
		ut.commit();
		return tipoPromocionNuevo;
	}

	@Override
	public List<TipoPromocion> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<TipoPromocion> listadoTiposPromocion = em.createQuery("SELECT t from TipoPromocion t", TipoPromocion.class).getResultList();
		return listadoTiposPromocion;
	}

	@Override
	public TipoPromocion findById(int idTipoPromocion) throws Exception {
		// TODO Auto-generated method stub
		return em.find(TipoPromocion.class, new Integer(idTipoPromocion));
	}
}
