package es.uc3m.tiw.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.*;
import es.uc3m.tiw.model.*;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Direccion direccion;
	
	List<Usuario> usuarios = new ArrayList<Usuario>();
	List<Direccion> direcciones = new ArrayList<Direccion>();
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private UsuarioDao usuarioDao;
	private DireccionDao direccionDao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		usuarioDao = new UsuarioDaoImpl(em, ut);
		direccionDao = new DireccionDaoImpl(em, ut);
		try {
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardJSP = "/signup.jsp";
		forward(request, response, forwardJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario nuevoUsuario = new Usuario();
		Direccion nuevaDireccion = new Direccion();
		boolean estaVacio = false;
		String forwardJSP = "";
		HttpSession sesion = request.getSession(true);

		if (request.getParameter("nombre") != null
				&& !"".equalsIgnoreCase(request.getParameter("nombre"))) {
			nuevoUsuario.setNombre(request.getParameter("nombre"));
			if (request.getParameter("apellidos") != null
					&& !"".equalsIgnoreCase(request.getParameter("apellidos"))) {
				nuevoUsuario.setApellido(request.getParameter("apellidos"));
				if (request.getParameter("username") != null
						&& !"".equalsIgnoreCase(request
								.getParameter("username"))) {
					nuevoUsuario.setUsername(request.getParameter("username"));
					if (request.getParameter("email") != null
							&& !"".equalsIgnoreCase(request
									.getParameter("email"))) {
						nuevoUsuario.setCorreo(request.getParameter("email"));
						if (request.getParameter("password") != null
								&& !"".equalsIgnoreCase(request
										.getParameter("password"))) {
							nuevoUsuario.setPassword(request
									.getParameter("password"));
						} else {
							estaVacio = true;
						}
					} else {
						estaVacio = true;
					}
				} else {
					estaVacio = true;
				}
			} else {
				estaVacio = true;
			}
		} else {
			estaVacio = true;
		}

		if (estaVacio) {
			forwardJSP = "/signup.jsp";
			String mensaje = "Debe rellenar los datos marcados con *";
			request.setAttribute("mensaje", mensaje);
			forward(request, response, forwardJSP);
		} else {
			if (request.getParameter("edad") != null
					&& !"".equalsIgnoreCase(request.getParameter("edad"))) {
				int nuevaEdad = Integer.parseInt(request.getParameter("edad"));
				nuevoUsuario.setEdad(nuevaEdad);
			}
			if (request.getParameter("intereses") != null
					&& !"".equalsIgnoreCase(request.getParameter("intereses"))) {
				nuevoUsuario.setIntereses(request.getParameter("intereses"));
			}
			if (request.getParameter("descripcion") != null
					&& !"".equalsIgnoreCase(request.getParameter("descripcion"))) {
				nuevoUsuario
						.setDescripcion(request.getParameter("descripcion"));
			}
			if (request.getParameter("pais") != null
					&& !"".equalsIgnoreCase(request.getParameter("pais"))) {
				nuevaDireccion.setPais(request.getParameter("pais"));
			}
			if (request.getParameter("ciudad") != null
					&& !"".equalsIgnoreCase(request.getParameter("ciudad"))) {
				nuevaDireccion.setCiudad(request.getParameter("ciudad"));
			}
			if (request.getParameter("calle") != null
					&& !"".equalsIgnoreCase(request.getParameter("calle"))) {
				nuevaDireccion.setCalle(request.getParameter("calle"));
			}
			if (request.getParameter("numero") != null
					&& !"".equalsIgnoreCase(request.getParameter("numero"))) {
				nuevaDireccion.setNumero(Integer.parseInt(request.getParameter("numero")));
			}
			if (request.getParameter("piso") != null
					&& !"".equalsIgnoreCase(request.getParameter("piso"))) {
				nuevaDireccion.setPiso(request.getParameter("piso"));
			}
			if (request.getParameter("telefono") != null
					&& !"".equalsIgnoreCase(request.getParameter("telefono"))) {
				nuevaDireccion.setTelefono(request.getParameter("telefono"));
			}
			if (request.getParameter("codigoPostal") != null
					&& !"".equalsIgnoreCase(request.getParameter("codigoPostal"))) {
				nuevaDireccion.setCodigoPostal(request.getParameter("codigoPostal"));
			}
			// usuarios.add(nuevoUsuario);
			Direccion dirCreated = null;
			try {
				dirCreated = direccionDao.createDireccion(nuevaDireccion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(dirCreated!=null){
				nuevoUsuario.setIdDireccion(nuevaDireccion);
			}
			nuevoUsuario.setAdmin(false);
			Usuario userCreated = null;
			try {
				userCreated = usuarioDao.createUsuario(nuevoUsuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (userCreated!=null){
			forwardJSP = "/principal.jsp";
			sesion.setAttribute("usuario", nuevoUsuario);
			sesion.setAttribute("acceso", "ok");
			forward(request, response, forwardJSP);
			}else{
				forwardJSP = "/signup.jsp";
				String mensaje = "Se ha producido un error al crear el perfil";
				sesion.setAttribute("mensaje", mensaje);
				forward(request, response, forwardJSP);
			}
			
		}
	}

	protected void forward(HttpServletRequest request,
			HttpServletResponse response, String uri) {
		try {
			javax.servlet.RequestDispatcher dispatcher = request
					.getRequestDispatcher(response.encodeURL(uri));
			dispatcher.forward(request, response);
			return;
		} catch (ServletException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
