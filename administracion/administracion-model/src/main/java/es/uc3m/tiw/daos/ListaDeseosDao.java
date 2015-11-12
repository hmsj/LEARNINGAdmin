package es.uc3m.tiw.daos;


import es.uc3m.tiw.model.ListaDeseos;

public interface ListaDeseosDao {
	
	public abstract ListaDeseos createListaDeseos(ListaDeseos listaDeseosNueva) throws Exception;

}
