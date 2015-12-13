package es.uc3m.tiw.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.AlumnoCursoDao;
import es.uc3m.tiw.daos.AlumnoCursoDaoImpl;
import es.uc3m.tiw.daos.PedidoDao;
import es.uc3m.tiw.daos.PedidoDaoImpl;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.Promocion;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.Vale;

/**
 * Session Bean implementation class GestionadorPedidos2
 */
@Stateless(mappedName = "servicioMatricula")
@LocalBean
public class GestionadorPedidos {
    /**
     * Default constructor. 
     */
    public GestionadorPedidos() {
        // TODO Auto-generated constructor stub
    }
    
    private AlumnoCursoDao alumnoCursoDao;
	private PedidoDao pedidoDao;
	
	public Double obtenerPrecioFinal(Curso curso, Usuario usuario, EntityManager em, UserTransaction ut) {
		// TODO Auto-generated method stub
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		
		Promocion promocion = curso.getIdPromocion();
		Vale vale = curso.getIdVale();
		Double beneficioAdmin = curso.getPrecioInicial()*0.3;
		Double beneficioProfe = curso.getPrecioInicial()*0.7;
		Double precioFinal = 0.0;
		Date fechaActual =  new java.util.Date();
		if(promocion != null){
			if(fechaActual.compareTo(promocion.getFechaFin())>0){
				if(promocion.getTipoPromocion().getIdTipoPromocion()==1){
					//Promocion precio fijo
					precioFinal = curso.getPrecioInicial()-promocion.getValor();
					if(precioFinal > beneficioAdmin){
						precioFinal = precioFinal;
					}else{
						//No se puede aplicar la promocion
						precioFinal = curso.getPrecioInicial();
					}
				}else if(promocion.getTipoPromocion().getIdTipoPromocion()==2){
					//Promocion porcentaje del precio
					precioFinal = (1-promocion.getValor())*curso.getPrecioInicial();
					if(precioFinal > beneficioAdmin){
						precioFinal = precioFinal;
					}else{
						//No se puede aplicar la promocion
						precioFinal = curso.getPrecioInicial();
					}
				}else{
					//Se ha producido un error
				}
			}else{
				//ERROR La promocion esta caducada
				precioFinal = curso.getPrecioInicial();
				
			}
		}else if(vale != null){
			//Se hace despues de comprobar si hay promocion porque la promocion prevalece sobre el vale
			if(fechaActual.compareTo(vale.getFechaCaducidad())>0){
				precioFinal = curso.getPrecioInicial()-vale.getValorVale();
				if(precioFinal>beneficioProfe){
					if(precioFinal>vale.getCosteMinimoAlumno()){
						int numCursosAlumno = 0;
						try {
							numCursosAlumno = alumnoCursoDao.numeroCursosAlumno(usuario.getIdUsuario());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							numCursosAlumno = 0;
						}
						if(numCursosAlumno>0 && numCursosAlumno >= vale.getNumCursosInsc()){
							precioFinal = precioFinal;
						}else{
							precioFinal =  curso.getPrecioInicial();
						}
					}else{
						//Supera el coste minimo
						precioFinal = curso.getPrecioInicial();
					}
				}else{
					//Supera el beneficio del profesor
					precioFinal=curso.getPrecioInicial();
				}
			}else{
				//ERROR El vale no tiene validez
				precioFinal = curso.getPrecioInicial();
			}
		}else{
			precioFinal = curso.getPrecioInicial();
		}
		return precioFinal;
	}

	public Pedido generarPedido(Curso curso, Usuario usuario, String tarjeta, EntityManager em, UserTransaction ut) {
		// TODO Auto-generated method stub
		pedidoDao = new PedidoDaoImpl(em, ut);
		Pedido pedido = new Pedido();
		Date fechaActual = new Date();
		Double importePedido = 0.0;
		importePedido = obtenerPrecioFinal(curso, usuario, em, ut);
		
		pedido.setImporte(importePedido);
		pedido.setCodigoTarjeta(tarjeta);
		pedido.setFechaPedido(new java.sql.Date(2015,12,13));
		pedido.setCodigoPedido(generarCodigoPedido());
		pedido.setCodigoOperacion("BANCO");
		
		Pedido pedidoCreado = null;
		try {
			pedidoCreado = pedidoDao.createPedido(pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pedidoCreado;
	}

	public String generarCodigoPedido() {
		// TODO Auto-generated method stub
		String codigoPedido = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSa");
	    Date fechaActual = new Date();
	    String strDate = sdfDate.format(fechaActual);
	    codigoPedido = "ORDER"+strDate;

		return codigoPedido;
	}


}
