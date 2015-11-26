package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.ProfesorCurso;

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
	public AlumnoCurso modifyAlumnoCurso(AlumnoCurso alumnoCurso)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(alumnoCurso);
		ut.commit();
		return alumnoCurso;
	}

	@Override
	public List<AlumnoCurso> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<AlumnoCurso> listadoTotalAlumnosCurso = em.createQuery("SELECT a FROM AlumnoCurso a", AlumnoCurso.class).getResultList();
		return listadoTotalAlumnosCurso;
	}

	@Override
	public AlumnoCurso findByUsername(String alumnoUsername)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(AlumnoCurso.class, new String(alumnoUsername));
	}

	@Override
	public AlumnoCurso comprobarAlumnoCursado(String alumnoUsername, long idCurso)
			throws Exception {
		// TODO Auto-generated method stub
		AlumnoCurso alumno = null;
		alumno = em.createQuery("SELECT a FROM AlumnoCurso a WHERE a.idUsuario.username='"+alumnoUsername+"' AND a.idCurso='"+idCurso+"' AND a.enCurso='"+true+"'", AlumnoCurso.class).getSingleResult();
		return alumno;
	}

	@Override
	public AlumnoCurso comprobarAlumnoEnCurso(String alumnoUsername,
			long idCurso) throws Exception {
		// TODO Auto-generated method stub
		AlumnoCurso alumno = null;
		alumno = em.createQuery("SELECT a FROM AlumnoCurso a WHERE a.idUsuario.username='"+alumnoUsername+"' AND a.idCurso='"+idCurso+"' AND a.enCurso='"+false+"'", AlumnoCurso.class).getSingleResult();
		return alumno;
	}
	
	@Override
	public List<AlumnoCurso> listadoAlumnosEnCurso(long idCurso) throws Exception {
		// TODO Auto-generated method stub
		List<AlumnoCurso> listadoAlumnosEnCurso = em.createQuery("SELECT a FROM AlumnoCurso a WHERE a.idCurso.idCurso='"+ idCurso +"'AND a.enCurso='"+ true +"'", AlumnoCurso.class).getResultList();
		return listadoAlumnosEnCurso;
	}

	@Override
	public List<AlumnoCurso> listadoAlumnosCursado(long idCurso)
			throws Exception {
		// TODO Auto-generated method stub
		List<AlumnoCurso> listadoAlumnosCursado = em.createQuery("SELECT a FROM AlumnoCurso a WHERE a.idCurso.idCurso='"+ idCurso +"'AND a.enCurso='"+ false +"'", AlumnoCurso.class).getResultList();
		return listadoAlumnosCursado;
	}

	@Override
	public AlumnoCurso comprobarAlumno(String nombreAlumno, long idCurso) {
		// TODO Auto-generated method stub
		AlumnoCurso alumno = null;
		alumno = em.createQuery("SELECT a FROM AlumnoCurso a WHERE a.idUsuario.username='"+nombreAlumno+"' AND a.idCurso='"+idCurso+"'", AlumnoCurso.class).getSingleResult();
		return alumno;
	}

}
