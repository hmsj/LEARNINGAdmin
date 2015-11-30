package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Promocion;

public class PromocionDaoImpl implements PromocionDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public PromocionDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Promocion createPromocion(Promocion promocionNueva) throws Exception{
		ut.begin();
		em.persist(promocionNueva);
		ut.commit();
		return promocionNueva;
	}

	@Override
	public void removePromocion(Promocion promocion) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(promocion));
		ut.commit();
	}
	
	@Override
	public List<Promocion> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Promocion> listadoPromociones = em.createQuery("SELECT p FROM Promocion p", Promocion.class).getResultList();
		return listadoPromociones;
	}

	@Override
	public Promocion findById(Long idPromocion) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Promocion.class, new Long(idPromocion));
	}

}
