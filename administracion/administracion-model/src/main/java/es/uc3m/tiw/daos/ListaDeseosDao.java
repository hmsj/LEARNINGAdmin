package es.uc3m.tiw.daos;


import java.util.List;

import es.uc3m.tiw.model.ListaDeseos;

public interface ListaDeseosDao {
	
	public abstract ListaDeseos createListaDeseos(ListaDeseos listaDeseosNueva) throws Exception;

	public abstract void removeListaDeseos (ListaDeseos listaDeseos) throws Exception;

	public abstract ListaDeseos modifyListaDeseos(ListaDeseos listaDeseos) throws Exception;

	public abstract List<ListaDeseos> findAll() throws Exception;
	
	public abstract ListaDeseos findById(Long idListaDeseos) throws Exception;

}
