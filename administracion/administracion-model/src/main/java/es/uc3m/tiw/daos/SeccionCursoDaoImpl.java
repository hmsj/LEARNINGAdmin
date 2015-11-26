package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.SeccionCurso;

public class SeccionCursoDaoImpl implements SeccionCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public SeccionCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public SeccionCurso createSeccionCurso(SeccionCurso seccionCursoNueva) throws Exception{
		ut.begin();
		em.persist(seccionCursoNueva);
		ut.commit();
		return seccionCursoNueva;
	}

	@Override
	public void removeSeccion(SeccionCurso seccionCurso) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(seccionCurso));
		ut.commit();
	}

	@Override
	public List<SeccionCurso> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<SeccionCurso> listadoSecciones = em.createQuery("SELECT s from SeccionCurso s", SeccionCurso.class).getResultList();
		return listadoSecciones;
	}

	@Override
	public SeccionCurso findById(Long idSeccion) throws Exception {
		// TODO Auto-generated method stub
		return em.find(SeccionCurso.class, new Long(idSeccion));
	}
}
