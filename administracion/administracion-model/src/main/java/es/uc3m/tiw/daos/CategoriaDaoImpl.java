package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {
	private EntityManager em;
	private UserTransaction ut;

	public CategoriaDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Categoria createCategoria(Categoria categoriaNueva) throws Exception {
		ut.begin();
		em.persist(categoriaNueva);
		ut.commit();
		return categoriaNueva;
	}

	@Override
	public List<Categoria> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Categoria> listadoCategorias = em.createQuery("SELECT c from Categoria c",
				Categoria.class).getResultList();
		return listadoCategorias;
	}

	@Override
	public Categoria findById(int idCategoria) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Categoria.class, new Integer(idCategoria));
	}

}
