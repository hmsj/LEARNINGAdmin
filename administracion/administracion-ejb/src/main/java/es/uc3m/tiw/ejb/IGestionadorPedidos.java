package es.uc3m.tiw.ejb;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.*;

@Local
public interface IGestionadorPedidos {
	
	public abstract Double obtenerPrecioFinal(Curso curso, Usuario usuario, EntityManager em, UserTransaction ut);
	
	public abstract Pedido generarPedido (Curso curso, Usuario usuario, String tarjeta, EntityManager em, UserTransaction ut);
	
	public abstract String generarCodigoPedido ();
}
