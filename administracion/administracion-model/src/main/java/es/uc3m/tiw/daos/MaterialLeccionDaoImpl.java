package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.MaterialLeccion;

public class MaterialLeccionDaoImpl implements MaterialLeccionDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public MaterialLeccionDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public MaterialLeccion createMaterialLeccion(
			MaterialLeccion materialLeccionNuevo) throws Exception{
		ut.begin();
		em.persist(materialLeccionNuevo);
		ut.commit();
		return materialLeccionNuevo;
	}
}
