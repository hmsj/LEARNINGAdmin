package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.AlumnoLeccion;

public class AlumnoLeccionDaoImpl implements AlumnoLeccionDao{
	private EntityManager em;
	private UserTransaction ut;
	public AlumnoLeccionDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	@Override
	public AlumnoLeccion createAlumnoLeccion(AlumnoLeccion alumnoLeccionNuevo) throws Exception{
		ut.begin();
		em.persist(alumnoLeccionNuevo);
		ut.commit();
		return alumnoLeccionNuevo;
	}

	@Override
	public void removeAlumnoLeccion(AlumnoLeccion alumnoLeccion)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(alumnoLeccion));
		ut.commit();
	}

	@Override
	public AlumnoLeccion modifyAlumnoLeccion(AlumnoLeccion alumnoLeccion)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(alumnoLeccion);
		ut.commit();
		return alumnoLeccion;
	}	
	
	@Override
	public List<AlumnoLeccion> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<AlumnoLeccion> listadoAlumnosLeccion = em.createQuery("SELECT a FROM AlumnoLeccion a", AlumnoLeccion.class).getResultList();
		return listadoAlumnosLeccion;
	}

	@Override
	public AlumnoLeccion findByUsername(String alumnoLeccionUsername)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(AlumnoLeccion.class, new String(alumnoLeccionUsername));
	}

}
