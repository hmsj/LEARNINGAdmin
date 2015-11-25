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

import es.uc3m.tiw.daos.AlumnoCursoDao;
import es.uc3m.tiw.daos.AlumnoCursoDaoImpl;
import es.uc3m.tiw.daos.CategoriaDao;
import es.uc3m.tiw.daos.CategoriaDaoImpl;
import es.uc3m.tiw.daos.CursoDao;
import es.uc3m.tiw.daos.CursoDaoImpl;
import es.uc3m.tiw.daos.DificultadDao;
import es.uc3m.tiw.daos.DificultadDaoImpl;
import es.uc3m.tiw.daos.LeccionCursoDao;
import es.uc3m.tiw.daos.LeccionCursoDaoImpl;
import es.uc3m.tiw.daos.MaterialLeccionDao;
import es.uc3m.tiw.daos.MaterialLeccionDaoImpl;
import es.uc3m.tiw.daos.ProfesorCursoDao;
import es.uc3m.tiw.daos.ProfesorCursoDaoImpl;
import es.uc3m.tiw.daos.SeccionCursoDao;
import es.uc3m.tiw.daos.SeccionCursoDaoImpl;
import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Categoria;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Dificultad;
import es.uc3m.tiw.model.LeccionCurso;
import es.uc3m.tiw.model.MaterialLeccion;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.SeccionCurso;

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
	private Dificultad dificultad;

	List<AlumnoCurso> alumnosCurso = new ArrayList<AlumnoCurso>();
	List<Curso> cursos = new ArrayList<Curso>();
	List<ProfesorCurso> profesoresCurso = new ArrayList<ProfesorCurso>();
	List<SeccionCurso> seccionesCurso = new ArrayList<SeccionCurso>();
	List<LeccionCurso> leccionesCurso = new ArrayList<LeccionCurso>();
	List<MaterialLeccion> materialesLeccion = new ArrayList<MaterialLeccion>();
	List<Categoria> categorias = new ArrayList<Categoria>();
	List<Dificultad> dificultades = new ArrayList<Dificultad>();

	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private AlumnoCursoDao alumnoCursoDao;
	private CursoDao cursoDao;
	private ProfesorCursoDao profesorCursoDao;
	private SeccionCursoDao seccionCursoDao;
	private LeccionCursoDao leccionCursoDao;
	private MaterialLeccionDao materialLeccionDao;
	private CategoriaDao categoriaDao;
	private DificultadDao dificultadDao;

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
		
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		cursoDao = new CursoDaoImpl(em, ut);
		profesorCursoDao = new ProfesorCursoDaoImpl(em, ut);
		seccionCursoDao = new SeccionCursoDaoImpl(em, ut);
		leccionCursoDao = new LeccionCursoDaoImpl(em, ut);
		materialLeccionDao = new MaterialLeccionDaoImpl(em, ut);
		categoriaDao = new CategoriaDaoImpl(em, ut);
		dificultadDao = new DificultadDaoImpl(em, ut);
		
		try {
			alumnosCurso = alumnoCursoDao.findAll();
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
			seccionesCurso = seccionCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			leccionesCurso = leccionCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			materialesLeccion = materialLeccionDao.findAll();
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
		String forwardJSP = "/crearCurso.jsp";
		request.getSession().setAttribute("categorias", categorias);
		request.getSession().setAttribute("dificultades", dificultades);
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
					switch (Integer.parseInt(request
							.getParameter("categoriaCurso"))) {
					case 1:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(1));
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						break;
					case 2:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(2));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 3:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(3));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 4:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(4));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 5:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(5));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 6:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(6));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 7:
						try {
							nuevoCurso.setIdCategoria(categoriaDao.findById(7));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					default:
						forwardJSP = "/crearCurso.jsp";
						String mensaje = "No ha seleccionado una categoria para el curso";
						sesion.setAttribute("mensaje", mensaje);
						forward(request, response, forwardJSP);
						break;
					}
				}
				if (request.getParameter("dificultadCurso") != null
						&& !"".equalsIgnoreCase(request
								.getParameter("dificultadCurso"))) {
					nuevoCurso.setDescripcion(request
							.getParameter("dificultadCurso"));
					switch (Integer.parseInt(request
							.getParameter("dificultadCurso"))) {
					case 1:
						try {
							nuevoCurso.setIdDificultad(dificultadDao
									.findById(1));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						try {
							nuevoCurso.setIdDificultad(dificultadDao
									.findById(2));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
						try {
							nuevoCurso.setIdDificultad(dificultadDao
									.findById(3));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					default:
						forwardJSP = "/crearCurso.jsp";
						String mensaje = "No ha introducido la dificultad del curso";
						sesion.setAttribute("mensaje", mensaje);
						forward(request, response, forwardJSP);
						break;
					}
				}
				if (request.getParameter("precioCurso") != null
						&& !"".equalsIgnoreCase(request
								.getParameter("precioCurso"))) {
					nuevoCurso.setPrecioInicial(Double.parseDouble(request
							.getParameter("precioCurso")));
				}
			}
			if (request.getParameter("imgCurso") != null
					&& !"".equalsIgnoreCase(request.getParameter("imgCurso"))) {
				nuevoCurso.setImagen(request.getParameter("imgCurso"));
			}
			nuevoCurso.setEstado(false);
			nuevoCurso.setDestacado(false);

			// cursos.add(nuevoCurso);
			try {
				cursoDao.createCurso(nuevoCurso);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
