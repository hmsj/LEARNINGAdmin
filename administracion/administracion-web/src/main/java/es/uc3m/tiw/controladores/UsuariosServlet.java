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

	List<AlumnoCurso> alumnosEnCursos = new ArrayList<AlumnoCurso>();
	List<AlumnoCurso> alumnosCursados = new ArrayList<AlumnoCurso>(); 
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private CursoDao cursoDao;
	private AlumnoCursoDao alumnoCursoDao;
	private UsuarioDao usuarioDao;
	private BancoDao bancoDao;
	private DireccionDao direccionDao;
	private LogroDao logroDao;
	private DificultadDao dificultadDao;

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
		cursoDao = new CursoDaoImpl(em, ut);
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		usuarioDao = new UsuarioDaoImpl(em, ut);
		logroDao = new LogroDaoImpl(em, ut);
		dificultadDao = new DificultadDaoImpl(em, ut);
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
		try {
			alumnosEnCursos = alumnoCursoDao.listadoAlumnosEnCurso();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			alumnosCursados = alumnoCursoDao.listadoAlumnosCursado();
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
		String mensajeOK = "";
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String accion=request.getParameter("accion");
		String mensajeError = "";
		usuario = null;
		if (usuarioLogado != null && usuarioLogado.isAdmin()) {
			if (accion==null || "".equalsIgnoreCase(accion)){
				if(request.getParameter("idUsuario")!=null && !"".equalsIgnoreCase(request.getParameter("idUsuario"))){
				try {
					usuario = usuarioDao.findById(Long.parseLong(request.getParameter("idUsuario")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (usuario!=null) {
					request.setAttribute("usuario", usuario);
					request.setAttribute("alumnosEnCursos", alumnosEnCursos);
					request.setAttribute("alumnosCursados", alumnosCursados);
					forwardJSP = "/editUser.jsp";
				}else {
					mensajeError="Se ha producido un error al acceder a los datos";
					request.setAttribute("mensajeError", mensajeError);
					forwardJSP = "/listadoAlumnos.jsp";
				}
				}	

			} else {
				mensajeError = "No tiene permiso para acceder a estos datos";
				request.setAttribute("mensajeError", mensajeError);
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
