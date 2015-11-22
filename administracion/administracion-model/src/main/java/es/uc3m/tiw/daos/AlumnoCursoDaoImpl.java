package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.AlumnoCurso;

public class AlumnoCursoDaoImpl implements AlumnoCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public AlumnoCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public AlumnoCurso createAlumnoCurso(AlumnoCurso alumnoCursoNuevo) throws Exception {
		ut.begin();
		em.persist(alumnoCursoNuevo);
		ut.commit();
		return alumnoCursoNuevo;
	}

	@Override
	public void removeAlumno(AlumnoCurso alumnoCurso) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(alumnoCurso));
		ut.commit();
	}

	@Override
	public List<AlumnoCurso> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<AlumnoCurso> listadoAlumnosCurso = em.createQuery("SELECT a FROM AlumnoCurso a", AlumnoCurso.class).getResultList();
		return listadoAlumnosCurso;
	}

	@Override
	public AlumnoCurso findByUsername(String alumnoUsername)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(AlumnoCurso.class, new String(alumnoUsername));
	}
}
