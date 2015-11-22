package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ProfesorCurso;

public class ProfesorCursoDaoImpl implements ProfesorCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public ProfesorCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public ProfesorCurso createProfesorCurso(ProfesorCurso profesorCursoNuevo) throws Exception{
		ut.begin();
		em.persist(profesorCursoNuevo);
		ut.commit();
		return profesorCursoNuevo;
	}

	@Override
	public void removeProfesor(ProfesorCurso profesorCurso) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(profesorCurso));
		ut.commit();
	}

	@Override
	public List<ProfesorCurso> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<ProfesorCurso> listadoProfesores = em.createQuery("SELECT p from ProfesorCurso m", ProfesorCurso.class).getResultList();
		return listadoProfesores;
	}

	@Override
	public ProfesorCurso findByUsername(String profesorUsername)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(ProfesorCurso.class, new String(profesorUsername));
	}
}
