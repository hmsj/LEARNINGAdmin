package es.uc3m.tiw.daos;

import java.util.List;

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

	@Override
	public void removeListaDeseos(ListaDeseos listaDeseos) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(listaDeseos));
		ut.commit();
	}

	@Override
	public List<ListaDeseos> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<ListaDeseos> listadoListaDeseos = em.createQuery("SELECT l from ListaDeseos l", ListaDeseos.class).getResultList();
		return listadoListaDeseos;
	}

	@Override
	public ListaDeseos modifyListaDeseos(ListaDeseos listaDeseos)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(listaDeseos);
		ut.commit();
		return listaDeseos;
	}	
	
	@Override
	public ListaDeseos findById(Long idListaDeseos) throws Exception {
		// TODO Auto-generated method stub
		return em.find(ListaDeseos.class, new Long(idListaDeseos));
	}
	
}
