package es.uc3m.tiw.daos;

import java.util.List;

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

	@Override
	public void removeMaterial(MaterialLeccion material) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(material));
		ut.commit();
	}

	@Override
	public List<MaterialLeccion> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<MaterialLeccion> listadoMateriales = em.createQuery("SELECT m from MaterialLeccion m", MaterialLeccion.class).getResultList();
		return listadoMateriales;
	}

	@Override
	public MaterialLeccion findById(Long idMaterial) throws Exception {
		// TODO Auto-generated method stub
		return em.find(MaterialLeccion.class, new Long(idMaterial));
	}
}
