package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.LeccionCurso;

public class LeccionCursoDaoImpl implements LeccionCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public LeccionCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public LeccionCurso createLeccionCurso(LeccionCurso leccionCursoNueva) throws Exception{
		ut.begin();
		em.persist(leccionCursoNueva);
		ut.commit();
		return leccionCursoNueva;
	}

	@Override
	public void removeLeccion(LeccionCurso leccionCurso) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(leccionCurso));
		ut.commit();
	}

	@Override
	public LeccionCurso modifyLeccionCurso(LeccionCurso leccionCurso)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(leccionCurso);
		ut.commit();
		return leccionCurso;
	}
	
	@Override
	public List<LeccionCurso> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<LeccionCurso> listadoLeccionesCurso = em.createQuery("SELECT l from LeccionCurso l",LeccionCurso.class).getResultList();
		return listadoLeccionesCurso;
	}

	@Override
	public LeccionCurso findById(Long idLeccion) throws Exception {
		// TODO Auto-generated method stub
		return em.find(LeccionCurso.class, new Long(idLeccion));
	}
	
}
