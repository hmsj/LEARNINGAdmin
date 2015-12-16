package es.uc3m.tiw.controladores;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.PromocionDao;
import es.uc3m.tiw.daos.PromocionDaoImpl;
import es.uc3m.tiw.daos.TipoPromocionDao;
import es.uc3m.tiw.daos.TipoPromocionDaoImpl;
import es.uc3m.tiw.model.Promocion;
import es.uc3m.tiw.model.Usuario;


/**
 * Servlet implementation class PromocionServlet
 */
@WebServlet("/promocion")
public class PromocionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Promocion promocion;
	
	List<Promocion> promociones = new ArrayList<Promocion>();
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private PromocionDao promocionDao;
	private TipoPromocionDao tipoPromocionDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromocionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		promocionDao = new PromocionDaoImpl(em, ut);
		tipoPromocionDao = new TipoPromocionDaoImpl(em, ut);
		
		try {
			promociones = promocionDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			promociones = null;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String forwardJSP = "/promocion.jsp";
		forward(request, response, forwardJSP);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardJSP="";
		String mensajeError = "";
		String mensajeOK = "";
		HttpSession sesion = request.getSession(true);
		Promocion nuevaPromocion = new Promocion();
		if(request.getParameter("nombrePromocion")!=null && !"".equalsIgnoreCase(request.getParameter("nombrePromocion"))){
			Promocion promo = new Promocion();
			for(int i = 0; i<promociones.size();i++){
				promo = promociones.get(i);
				if(request.getParameter("nombrePromocion")!=promo.getNombrePromocion()){
					nuevaPromocion.setNombrePromocion(request.getParameter("nombrePromocion"));
				}else{
					mensajeError = "Debe elegir un nombre distinto para la promocion, ya existe";
					forwardJSP = "/promocion.jsp";
					request.setAttribute("mensajeError", mensajeError);
					forward(request, response, forwardJSP);
				}
			}
		}else{
			mensajeError = "Debe asignar un nombre a la promocion ";
			forwardJSP = "/promocion.jsp";
			request.setAttribute("mensajeError", mensajeError);
			forward(request, response, forwardJSP);
		}
		if(request.getParameter("tipoCupon")!=null && !"".equalsIgnoreCase(request.getParameter("tipoCupon"))){
			if(request.getParameter("tipoCupon").equalsIgnoreCase("fijo")){
				try {
					nuevaPromocion.setTipoPromocion(tipoPromocionDao.findById(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(request.getParameter("tipoCupon").equalsIgnoreCase("porcentaje")){
				try {
					nuevaPromocion.setTipoPromocion(tipoPromocionDao.findById(2));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				mensajeError = "Debe seleccionar el tipo de descuento de la promocion";
				forwardJSP = "/promocion.jsp";
				request.setAttribute("mensajeError", mensajeError);
				forward(request, response, forwardJSP);
			}
		}
		if(request.getParameter("valorPromocion")!=null && !"".equalsIgnoreCase(request.getParameter("valorPromocion"))){
			
			double valor = Double.parseDouble(request.getParameter("valorPromocion"));
			nuevaPromocion.setValor(valor);
		}else{
			mensajeError = "Debe aplicar un valor a la promocion";
			forwardJSP = "/promocion.jsp";
			request.setAttribute("mensajeError", mensajeError);
			forward(request, response, forwardJSP);
		}
		if(request.getParameter("fechaFinPromocion")!=null && !"".equalsIgnoreCase(request.getParameter("fechaFinPromocion"))){
			int day = Integer.parseInt(request.getParameter("fechaFinPromocion").substring(0, 2));
			int month = Integer.parseInt(request.getParameter("fechaFinPromocion").substring(3, 5));
			int year = Integer.parseInt(request.getParameter("fechaFinPromocion").substring(6, 10));
			Date fechaFin = new Date (year, month, day);
			nuevaPromocion.setFechaFin(fechaFin);
		}else{
		
		}
		Promocion promoCreated = null;
		try {
			promoCreated = promocionDao.createPromocion(nuevaPromocion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (promoCreated != null) {
			forwardJSP = "/principal.jsp";
			mensajeOK = "Promocion creada correctamente";
			request.setAttribute("mensajeOK", mensajeOK);
			forward(request, response, forwardJSP);
		} else {
			forwardJSP = "/promocion.jsp";
			mensajeError = "Se ha producido un error al crear el perfil";
			request.setAttribute("mensajeError", mensajeError);
			forward(request, response, forwardJSP);
		}
	}
	
	/*Metodo para redirigir a los jsp*/
	protected void forward(HttpServletRequest request, HttpServletResponse response, String uri){
		try{
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL(uri));
			dispatcher.forward(request, response);
			return;
		}
		catch(ServletException se){
			se.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	 public Date sumarRestarDiasFecha(Date fechaActual, int dias){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(fechaActual); // Configuramos la fecha que se recibe
		 calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
		 return (Date) calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	 }
}
