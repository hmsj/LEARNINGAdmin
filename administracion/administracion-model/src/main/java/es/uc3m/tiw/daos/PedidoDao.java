package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Pedido;

public interface PedidoDao {
	public abstract Pedido createPedido(Pedido pedidoNuevo) throws Exception;

	public abstract void removePedido (Pedido pedido) throws Exception;
	
	public abstract Pedido modifyPedido(Pedido pedido) throws Exception;

	public abstract Pedido findById(Long idPedido) throws Exception;

}
