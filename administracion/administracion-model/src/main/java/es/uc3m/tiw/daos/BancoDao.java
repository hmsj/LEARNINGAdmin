package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Banco;

public interface BancoDao {
	public abstract Banco createBanco(Banco bancoNuevo) throws Exception;

	public abstract void removeBanco (Banco banco) throws Exception;
	
	public abstract Banco modifyBanco(Banco banco) throws Exception;

	public abstract Banco findById(Long idBanco) throws Exception;

}
