package es.uc3m.tiw.ejb;

import javax.ejb.Local;

import es.uc3m.tiw.model.*;

@Local
public interface IGestionadorPedidos {
	
	public abstract Double obtenerPrecioFinal(Curso curso, Usuario usuario);
}
