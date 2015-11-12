package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ListaDeseos;

public class ListaDeseosDaoImpl implements ListaDeseosDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public ListaDeseosDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public ListaDeseos createListaDeseos(ListaDeseos listaDeseosNueva) throws Exception{
		ut.begin();
		em.persist(listaDeseosNueva);
		ut.commit();
		return listaDeseosNueva;
	}	
	
}
