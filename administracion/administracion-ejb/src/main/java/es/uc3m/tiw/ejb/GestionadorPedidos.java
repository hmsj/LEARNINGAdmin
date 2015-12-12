package es.uc3m.tiw.ejb;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.AlumnoCursoDao;
import es.uc3m.tiw.daos.AlumnoCursoDaoImpl;
import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.Promocion;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.Vale;

@Stateless(mappedName = "servicioMatricula")
@LocalBean
public class GestionadorPedidos implements IGestionadorPedidos {
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private AlumnoCursoDao alumnoCursoDao;
	
	@Override
	public Double obtenerPrecioFinal(Curso curso, Usuario usuario) {
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

	@Override
	public Pedido generarPedido(Curso curso, Usuario usuario, String tarjeta) {
		// TODO Auto-generated method stub
		Pedido pedido = new Pedido();
		Date fechaActual = new Date();
		Double importePedido = 0.0;
		importePedido = obtenerPrecioFinal(curso, usuario);
		
		pedido.setImporte(importePedido);
		pedido.setCodigoTarjeta(tarjeta);
		pedido.setFechaPedido((java.sql.Date) fechaActual);
		pedido.setCodigoPedido(generarCodigoPedido());
		pedido.setCodigoOperacion("BANCO");
		
		return null;
	}

	@Override
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
