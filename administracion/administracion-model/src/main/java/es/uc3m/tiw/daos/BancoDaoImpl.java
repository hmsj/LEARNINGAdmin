package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Banco;

public class BancoDaoImpl implements BancoDao{
	private EntityManager em;
	private UserTransaction ut;

	public BancoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Banco createBanco(Banco bancoNuevo) throws Exception{
		ut.begin();
		em.persist(bancoNuevo);
		ut.commit();
		return bancoNuevo;
	}
	
}
