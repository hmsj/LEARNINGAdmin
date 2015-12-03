package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.Usuario;

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
		List<ProfesorCurso> listadoProfesores = em.createQuery("SELECT p FROM ProfesorCurso p", ProfesorCurso.class).getResultList();
		return listadoProfesores;
	}

	@Override
	public ProfesorCurso findByUsername(String profesorUsername)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(ProfesorCurso.class, new String(profesorUsername));
	}
	
	@Override
	public ProfesorCurso comprobarProfesorInvitado(String profeInvUsername, long idCurso)
			throws Exception {
		// TODO Auto-generated method stub
		ProfesorCurso profeInvitado = null;
		profeInvitado = em.createQuery("SELECT p FROM ProfesorCurso p WHERE p.idUsuario.username='"+profeInvUsername+"' AND p.idCurso='"+ idCurso +"' AND p.titular='"+ false +"'", ProfesorCurso.class).getSingleResult();
		return profeInvitado;
	}

	@Override
	public ProfesorCurso comprobarProfesorTitularUnCurso(String profeTitUsername,
			long idCurso) throws Exception {
		// TODO Auto-generated method stub
		ProfesorCurso profeTitular = null;
		profeTitular = em.createQuery("SELECT p FROM ProfesorCurso p WHERE p.idUsuario.username='"+profeTitUsername+"' AND p.idCurso='"+ idCurso +"' AND p.titular='"+ true +"'", ProfesorCurso.class).getSingleResult();
		return profeTitular;
	}

	@Override
	public List<ProfesorCurso> listadoProfesInvitadosUnCurso(long idCurso)
			throws Exception {
		// TODO Auto-generated method stub
		List<ProfesorCurso> listadoProfesoresInvitados = em.createQuery("SELECT p FROM ProfesorCurso p WHERE p.idCurso.idCurso='"+ idCurso +"'AND p.titular='"+ false +"'", ProfesorCurso.class).getResultList();
		return listadoProfesoresInvitados;
	}
	
	@Override
	public ProfesorCurso ProfeTitularCurso(long idCurso)
			throws Exception {
		// TODO Auto-generated method stub
		ProfesorCurso profeTitular = em.createQuery("SELECT p FROM ProfesorCurso p WHERE p.idCurso.idCurso='"+ idCurso +"'AND p.titular='"+ true +"'", ProfesorCurso.class).getSingleResult();
		return profeTitular;
	}

	@Override
	public List<ProfesorCurso> listadoProfesTitulares()
			throws Exception {
		// TODO Auto-generated method stub
		List<ProfesorCurso> listadoProfesoresTitulares = em.createQuery("SELECT p FROM ProfesorCurso p WHERE p.titular='"+ true +"'", ProfesorCurso.class).getResultList();
		return listadoProfesoresTitulares;
	}
	
	//REvisar en caso de ser necesario el metodo
	@Override
	public List<ProfesorCurso> cursosByProfe(String username) throws Exception {
		// TODO Auto-generated method stub
		List<ProfesorCurso> listadoCursosProfe = em.createQuery("SELECT p.idCurso FROM ProfesorCurso p WHERE p.username='"+ username+"'AND p.titular='"+true+"'", ProfesorCurso.class).getResultList();
		return listadoCursosProfe;
	}

	@Override
	public List<ProfesorCurso> listadoTitularById(Long idUsuario)
			throws Exception {
		// TODO Auto-generated method stub
		List<ProfesorCurso> listadoTitularId = em.createQuery("SELECT p FROM ProfesorCurso p WHERE p.idUsuario.idUsuario='"+ idUsuario +"' AND p.titular='"+true+"'", ProfesorCurso.class).getResultList();
		return listadoTitularId;
	}
}
