package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Banco;

public interface BancoDao {
	public abstract Banco createBanco(Banco bancoNuevo) throws Exception;

}
