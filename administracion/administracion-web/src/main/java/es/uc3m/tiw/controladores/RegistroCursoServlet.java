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

import es.uc3m.tiw.daos.AlumnoCursoDaoImpl;
import es.uc3m.tiw.daos.CategoriaDaoImpl;
import es.uc3m.tiw.daos.CursoDaoImpl;
import es.uc3m.tiw.daos.LeccionCursoDaoImpl;
import es.uc3m.tiw.daos.MaterialLeccionDaoImpl;
import es.uc3m.tiw.daos.ProfesorCursoDaoImpl;
import es.uc3m.tiw.daos.SeccionCursoDaoImpl;
import es.uc3m.tiw.model.*;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/nuevoCurso")
public class RegistroCursoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3114864424385386858L;

	private AlumnoCurso alumnoCurso;
	private Curso curso;
	private ProfesorCurso profesorCurso;
	private SeccionCurso seccionCurso;
	private LeccionCurso leccionCurso;
	private MaterialLeccion materialLeccion;
	private Categoria categoria;

	List<AlumnoCurso> alumnosCursos = new ArrayList<AlumnoCurso>();
	List<Curso> cursos = new ArrayList<Curso>();
	List<ProfesorCurso> profesoresCurso = new ArrayList<ProfesorCurso>();
	List<SeccionCurso> secciones = new ArrayList<SeccionCurso>();
	List<LeccionCurso> lecciones = new ArrayList<LeccionCurso>();
	List<MaterialLeccion> materiales = new ArrayList<MaterialLeccion>();
	List<Categoria> categorias = new ArrayList<Categoria>();

	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private AlumnoCursoDaoImpl alumnoCursoDao;
	private CursoDaoImpl cursoDao;
	private ProfesorCursoDaoImpl profesorCursoDao;
	private SeccionCursoDaoImpl seccionCursoDao;
	private LeccionCursoDaoImpl leccionCursoDao;
	private MaterialLeccionDaoImpl materialLeccionDao;
	private CategoriaDaoImpl categoriaDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroCursoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		try {
			alumnosCursos = alumnoCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cursos = cursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			profesoresCurso = profesorCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			secciones = seccionCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lecciones = leccionCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			materiales = materialLeccionDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			categorias = categoriaDao.findAll();
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
		Curso nuevoCurso = new Curso();
		// Seccion nuevaSeccion = new Seccion();
		// Leccion nuevaLeccion = new Leccion();
		// Material nuevoMaterial = new Material();
		Categoria nuevaCategoria = new Categoria();
		boolean estaVacio = false;
		String forwardJSP = "";
		HttpSession sesion = request.getSession(true);

		if (request.getParameter("tituloCurso") != null
				&& !"".equalsIgnoreCase(request.getParameter("tituloCurso"))) {
			nuevoCurso.setTitulo(request.getParameter("tituloCurso"));
			if (request.getParameter("descripcionCurso") != null
					&& !"".equalsIgnoreCase(request
							.getParameter("descripcionCurso"))) {
				nuevoCurso.setDescripcion(request
						.getParameter("descripcionCurso"));
				if (request.getParameter("categoriaCurso") != null
						&& !"".equalsIgnoreCase(request
								.getParameter("categoriaCurso"))) {
					if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("programacion")) {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(1));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("fotografia")) {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(2));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("marketing")) {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(3));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						categorias.add(nuevaCategoria);
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("diseño")) {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(4));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("idiomas")) {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(5));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("negocios")) {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(6));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(7));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//cursos.add(nuevoCurso);
					try {
						cursoDao.createCurso(nuevoCurso);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			forwardJSP = "/curso.jsp";
			String mensaje = "Se ha creado correctamente el curso";
			sesion.setAttribute("mensaje", mensaje);
			forward(request, response, forwardJSP);
		}
		forwardJSP = "/crearCurso.jsp";
		String mensaje = "Se ha producido un error al crear el curso";
		sesion.setAttribute("mensaje", mensaje);
		forward(request, response, forwardJSP);

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
