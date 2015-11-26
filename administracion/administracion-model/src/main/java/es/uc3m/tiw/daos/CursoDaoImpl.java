package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Curso;

public class CursoDaoImpl implements CursoDao{
	private EntityManager em;
	private UserTransaction ut;

	public CursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Curso createCurso(Curso cursoNuevo) throws Exception{
		ut.begin();
		em.persist(cursoNuevo);
		ut.commit();
		return cursoNuevo;
	}

	@Override
	public List<Curso> findAll() throws Exception {
		List<Curso> listaCursos = em.createQuery("SELECT c from Curso c",Curso.class).getResultList();
		return listaCursos;
	}

	@Override
	public void removeCurso(Curso curso) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(curso));
		ut.commit();
	}

	@Override
	public Curso modifyCurso(Curso curso) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(curso);
		ut.commit();
		return curso;
	}
	
	@Override
	public Curso findById(Long idCurso) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Curso.class, new Long(idCurso));
	}
	
}
