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
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Curso curso;
	private AlumnoCurso alumnoCurso;
	private Usuario usuario;
	private Banco banco;
	private Direccion direccion;
	private Logro logro;
	private Dificultad dificultad;

	List<Curso> cursos = new ArrayList<Curso>();
	List<AlumnoCurso> alumnosCurso = new ArrayList<AlumnoCurso>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	List<Banco> bancos = new ArrayList<Banco>();
	List<Direccion> direcciones = new ArrayList<Direccion>();
	List<Logro> logros = new ArrayList<Logro>();
	List<Dificultad> dificultades = new ArrayList<Dificultad>();

	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private CursoDaoImpl cursoDao;
	private AlumnoCursoDaoImpl alumnoCursoDao;
	private UsuarioDaoImpl usuarioDao;
	private BancoDaoImpl bancoDao;
	private DireccionDaoImpl direccionDao;
	private LogroDaoImpl logroDao;
	private DificultadDaoImpl dificultadDao;

	String forwardJSP = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuariosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		try {
			cursos = cursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			alumnosCurso = alumnoCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			logros = logroDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dificultades = dificultadDao.findAll();
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
		String username = request.getParameter("username");
		String mensaje = "";
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		if (usuarioLogado != null) {
			if (username != null && !"".equals(username)
					&& usuarioLogado.getUsername().equals(username)) {
				// TipoUsuario tipoUsuario = comprobarUsuario(usuarioLogado);
				// Alumno alumnoLogado = obtenerAlumno(usuarioLogado);
				try {
					usuarioLogado = usuarioDao.findByUsername(username);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sesion.setAttribute("alumno", usuarioLogado);
				// mensaje = "Es un usuario alumno";
				request.setAttribute("mensaje", mensaje);
				forwardJSP = "/editUser.jsp";

			} else {
				mensaje = "Debe entrar al sistema para acceder a sus datos";
				request.setAttribute("mensaje", mensaje);
				forwardJSP = "/login.jsp";
			}
			forward(request, response, forwardJSP);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/* Metodo para redirigir a los jsp */
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
