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
		List<LeccionCurso> listadoLeccionesCurso = em.createQuery("SELECT l FROM LeccionCurso l",LeccionCurso.class).getResultList();
		return listadoLeccionesCurso;
	}

	@Override
	public LeccionCurso findById(Long idLeccion) throws Exception {
		// TODO Auto-generated method stub
		return em.find(LeccionCurso.class, new Long(idLeccion));
	}

	@Override
	public List<LeccionCurso> ListadoLeccionesUnaSeccion(Long idSeccion)
			throws Exception {
		// TODO Auto-generated method stub
		List<LeccionCurso> listadoLeccionesUnaSeccion= em.createQuery("SELECT l FROM LeccionCurso l WHERE l.idSeccion.idSeccion ='"+ idSeccion +"'",LeccionCurso.class).getResultList();
		return listadoLeccionesUnaSeccion;
	}

	@Override
	public List<LeccionCurso> ListadoLeccionesUnCurso(Long idCurso)
			throws Exception {
		// TODO Auto-generated method stub
		List<LeccionCurso> listadoLeccionesUnCurso= em.createQuery("SELECT l FROM LeccionCurso l WHERE l.idSeccion.idCurso.idCurso ='"+ idCurso +"'",LeccionCurso.class).getResultList();
		return listadoLeccionesUnCurso;
	}
	
}
