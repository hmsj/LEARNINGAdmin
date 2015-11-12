package es.uc3m.tiw.daos;

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
	
}
