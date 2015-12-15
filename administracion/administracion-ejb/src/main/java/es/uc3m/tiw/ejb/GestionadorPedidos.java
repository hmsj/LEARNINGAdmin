package es.uc3m.tiw.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	private AlumnoCursoDao alumnoCursoDao;
	private PedidoDao pedidoDao;
    /**
     * Default constructor. 
     */
    public GestionadorPedidos() {
        // TODO Auto-generated constructor stub
    	
    }
    
	
	@SuppressWarnings("unused")
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
			Date fechaFinPromo = new java.util.Date(promocion.getFechaFin().getTime());
			if(fechaActual.compareTo(fechaFinPromo)<0){
				if(promocion.getTipoPromocion().getIdTipoPromocion()==1){
					//Promocion precio fijo
					precioFinal = curso.getPrecioInicial()-promocion.getValor();
					if(promocion.getValor() < beneficioAdmin){
						precioFinal = precioFinal;
					}else{
						//No se puede aplicar la promocion
						precioFinal = curso.getPrecioInicial();
					}
				}else if(promocion.getTipoPromocion().getIdTipoPromocion()==2){
					//Promocion porcentaje del precio
					precioFinal = (1-promocion.getValor())*curso.getPrecioInicial();
					if(promocion.getValor()*curso.getPrecioInicial() < beneficioAdmin){
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
			if(fechaActual.compareTo(new java.util.Date(vale.getFechaCaducidad().getTime()))<0){
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
		Pedido pedido = null;
		Date fechaActual = new Date();
		Double importePedido = 0.0;
		importePedido = obtenerPrecioFinal(curso, usuario, em, ut);
		java.sql.Date fechaPedido = new java.sql.Date(fechaActual.getTime());
		String codigoPedido = generarCodigoPedido();
		String codigoOperacion = "BANCO";
		Double beneficioAdmin = obtenerBeneficioAdmin(curso, usuario, em, ut);
		Double beneficioProfe = obtenerBeneficioProfe(curso, usuario, em, ut);
		pedido = new Pedido(codigoPedido, importePedido, codigoOperacion, tarjeta, fechaPedido, beneficioAdmin, beneficioProfe);
		
		return pedido;
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
	
	public Double obtenerBeneficioAdmin(Curso curso, Usuario usuario, EntityManager em, UserTransaction ut){
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		Promocion promocion = curso.getIdPromocion();
		Double beneficioIniAdmin = curso.getPrecioInicial()*0.3;
		Date fechaActual =  new java.util.Date();
		Double beneficioFinalAdmin = beneficioIniAdmin;
		if(promocion != null){
			Date fechaFinPromo = new java.util.Date(promocion.getFechaFin().getTime());
			if(fechaActual.compareTo(fechaFinPromo)<0){
				if(promocion.getTipoPromocion().getIdTipoPromocion()==1){
					//Promocion precio fijo
					if(promocion.getValor() < beneficioIniAdmin){
						beneficioFinalAdmin = beneficioIniAdmin-promocion.getValor();
					}else{
						//No se puede aplicar la promocion
						beneficioFinalAdmin = beneficioIniAdmin;
					}
				}else if(promocion.getTipoPromocion().getIdTipoPromocion()==2){
					//Promocion porcentaje del precio
					if(promocion.getValor()*curso.getPrecioInicial() < beneficioIniAdmin){
						beneficioFinalAdmin = beneficioIniAdmin-promocion.getValor()*curso.getPrecioInicial();
					}else{
						//No se puede aplicar la promocion
						beneficioFinalAdmin = beneficioIniAdmin;
					}
				}else{
					//Se ha producido un error
				}
			}else{
				//ERROR La promocion esta caducada
				beneficioFinalAdmin = beneficioIniAdmin;
			}
		}else{
			beneficioFinalAdmin = beneficioIniAdmin;
		}
		return beneficioFinalAdmin;
	}

	public Double obtenerBeneficioProfe(Curso curso, Usuario usuario, EntityManager em, UserTransaction ut){
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
	    
		Vale vale = curso.getIdVale();
		Double beneficioIniProfe = curso.getPrecioInicial()*0.7;
		Date fechaActual =  new java.util.Date();
		Double beneficioFinalProfe = beneficioIniProfe;
		Double precioFinal = 0.0;
		if(vale != null && curso.getIdPromocion() == null){
			//Se hace despues de comprobar si hay promocion porque la promocion prevalece sobre el vale
			Date fechaFinVale = new java.util.Date(vale.getFechaCaducidad().getTime());
			if(fechaActual.compareTo(fechaFinVale)<0){
				precioFinal = curso.getPrecioInicial()-vale.getValorVale();
				if(precioFinal>beneficioIniProfe){
					if(precioFinal>vale.getCosteMinimoAlumno()){
						int numCursosAlumno = 0;
						try {
							numCursosAlumno = alumnoCursoDao.numeroCursosAlumno(usuario.getIdUsuario());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							numCursosAlumno = 0;
						}
						if(numCursosAlumno>0 && numCursosAlumno >= vale.getNumCursosInsc()){
							beneficioFinalProfe = precioFinal * 0.7 - vale.getValorVale();
						}else{
							beneficioFinalProfe = beneficioIniProfe;
						}
					}else{
						//Supera el coste minimo
						beneficioFinalProfe = beneficioIniProfe;
					}
				}else{
					//Supera el beneficio del profesor
					beneficioFinalProfe = beneficioIniProfe;
				}
			}else{
				//ERROR El vale no tiene validez
				beneficioFinalProfe = beneficioIniProfe;
			}
		}else{
			beneficioFinalProfe = beneficioIniProfe;
		}
		return beneficioFinalProfe;
	}
}
