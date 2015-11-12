package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Categoria;

public class CategoriaDaoImpl implements CategoriaDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public CategoriaDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Categoria createCategoria(Categoria categoriaNueva) throws Exception{
		ut.begin();
		em.persist(categoriaNueva);
		ut.commit();
		return categoriaNueva;
	}
	
}
