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
import es.uc3m.tiw.daos.DificultadDaoImpl;
import es.uc3m.tiw.daos.LeccionCursoDaoImpl;
import es.uc3m.tiw.daos.MaterialLeccionDaoImpl;
import es.uc3m.tiw.daos.ProfesorCursoDaoImpl;
import es.uc3m.tiw.daos.SeccionCursoDaoImpl;
import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Categoria;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Dificultad;
import es.uc3m.tiw.model.LeccionCurso;
import es.uc3m.tiw.model.MaterialLeccion;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.SeccionCurso;
import es.uc3m.tiw.model.Usuario;

/**
 * Servlet implementation class CursosServlet
 */
@WebServlet(value = "/cursos")
public class CursosServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5079331756861773626L;

	private Curso curso;
	private Categoria categoria;
	private SeccionCurso seccion;
	private LeccionCurso leccion;
	private MaterialLeccion material;
	private AlumnoCurso alumno;
	private ProfesorCurso profesor;
	private Dificultad dificultad;

	List<Curso> cursos = new ArrayList<Curso>();
	List<Categoria> categorias = new ArrayList<Categoria>();
	List<SeccionCurso> secciones = new ArrayList<SeccionCurso>();
	List<LeccionCurso> lecciones = new ArrayList<LeccionCurso>();
	List<MaterialLeccion> materiales = new ArrayList<MaterialLeccion>();
	List<AlumnoCurso> alumnos = new ArrayList<AlumnoCurso>();
	List<ProfesorCurso> profesoresCurso = new ArrayList<ProfesorCurso>();
	List<Dificultad> dificultades = new ArrayList<Dificultad>();
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private CursoDaoImpl cursoDao;
	private CategoriaDaoImpl categoriaDao;
	private SeccionCursoDaoImpl seccionDao;
	private LeccionCursoDaoImpl leccionDao;
	private MaterialLeccionDaoImpl materialDao;
	private AlumnoCursoDaoImpl alumnoCursoDao;
	private ProfesorCursoDaoImpl profeDao;
	private DificultadDaoImpl dificultadDao;

	String forwardJSP = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CursosServlet() {
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
			categorias = categoriaDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			secciones = seccionDao.findAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			lecciones = leccionDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			materiales = materialDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			alumnos = alumnoCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			profesoresCurso = profeDao.findAll();
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
		String idCursoParam = request.getParameter("idcurso");
		String mensaje = null;
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		forwardJSP = "/listadoCursos.jsp";
		String accion = request.getParameter("accion");
		if (idCursoParam != null && !"".equals(idCursoParam)) {
			long idCurso = Integer.parseInt(idCursoParam);
			Curso course = null;
			try {
				course = cursoDao.findById(idCurso);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (course != null) {
				if (usuarioLogado != null) {
					// TipoUsuario tipoUser = comprobarUsuario(usuarioLogado);
					if (accion != null
							&& "deleteAlumno".equalsIgnoreCase(accion)) {
						String nombreAlumno = "";
						if (request.getParameter("target") != null
								&& !"".equalsIgnoreCase(request
										.getParameter("target"))) {
							nombreAlumno = request.getParameter("target");
							AlumnoCurso alumn = null;
							try {
								alumn = alumnoCursoDao.comprobarAlumno(
										nombreAlumno, idCurso);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (alumn != null) {
								// Curso matriculado = comprobarMatricula(alumn,
								// course);
								if (!alumn.isEnCurso())
									mensaje = "El alumno no está matriculado en este curso";

								if (mensaje == null) {
									for (int i = 0; i < alumnos.size(); i++) {
										if (alumnos
												.get(i)
												.getIdUsuario()
												.getUsername()
												.equalsIgnoreCase(
														alumn.getIdUsuario()
																.getUsername())) {
											alumnos.get(i).setEnCurso(false);
											this.getServletContext()
													.setAttribute("alumnos",
															alumnos);
											mensaje = "El alumno se ha eliminado del curso";
										}
									}
								}
							} else {
								mensaje = "El alumno que desea eliminar no existe en el sistema";
							}
						} else {
							mensaje = "No ha seleccionado un alumno al que eliminar del curso";
						}
						forwardJSP = "/curso.jsp";
					} else if (accion != null
							&& "modifyTem".equalsIgnoreCase(accion)) {

					} else if (accion != null
							&& "deleteTem".equalsIgnoreCase(accion)) {

					} else if (accion != null
							&& "deleteProfesor".equalsIgnoreCase(accion)) {
						String nombreProfesor = "";
						if (request.getParameter("target") != null
								&& !"".equalsIgnoreCase(request
										.getParameter("target"))) {
							nombreProfesor = request.getParameter("target");
							ProfesorCurso profeAyudante = null;//profeDao.comprobarProfesorInvitado(nombreProfesor, idCurso);
							if (profeAyudante != null) {
								/*boolean yaEnCurso = comprobarProfesorYaEnCurso(
										profe, course);*/
								if (profeAyudante.isTitular()) {
									for (int i = 0; i < profesoresCurso.size(); i++) {
										if (course.getIdCurso() == profesoresCurso
												.get(i).getIdCurso().getIdCurso()) {
											if (profeAyudante
													.getIdUsuario()
													.getUsername()
													.equalsIgnoreCase(
															profesoresCurso
																	.get(i)
																	.getIdUsuario()
																	.getUsername())) {
												// un profesor no podria
												// eliminar al profesor titular
												// del curso salvo el
												// administrador
												if (!profesoresCurso.get(i)
														.isTitular()) {
													profesoresCurso.remove(i);
													mensaje = "El profesor ya se ha eliminado del curso";
													this.getServletContext()
															.setAttribute(
																	"profesores",
																	profesoresCurso);
												} 
											}
										}
									}
								} else {
									mensaje = "El profesor ya esta dado de alta en el curso";
								}
							} else {
								mensaje = "El profesor que desea eliminar no existe en el sistema";
							}
						} else {
							mensaje = "No ha seleccionado un profesor al que eliminar del curso";
						}
						forwardJSP = "/curso.jsp";
					} 
				} else {
					sesion.setAttribute("curso", course);
					forwardJSP = "/curso.jsp";
				}
			}
		}
		if (mensaje != null) {
			request.setAttribute("mensaje", mensaje);
		}
		forward(request, response, forwardJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCursoParam = request.getParameter("idcurso");
		String mensaje = null;
		String accion = request.getParameter("accion");
		if (idCursoParam != null && !"".equals(idCursoParam)) {
			long idCurso = Integer.parseInt(idCursoParam);
			Curso course = null;
			try {
				course = cursoDao.findById(idCurso);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (course != null) {
				if (accion != null && "addAlumno".equalsIgnoreCase(accion)) {
					String nombreAlumno = "";
					if (request.getParameter("target") != null
							&& !"".equalsIgnoreCase(request
									.getParameter("target"))) {
						nombreAlumno = request.getParameter("target");
						AlumnoCurso alumn = null;
						try {
							alumn = alumnoCursoDao.comprobarAlumno(nombreAlumno, idCurso);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (alumn != null) {
							//Curso cursado = comprobarCursado(alumn, course);
							if (!alumn.isEnCurso())
								mensaje = "El alumno ya ha cursado este curso";
							//Curso matriculado = comprobarMatricula(alumn,
									//course);
							if (alumn.isEnCurso())
								mensaje = "El alumno ya está matriculado en este curso";

							if (mensaje == null) {
								for (int i = 0; i < alumnos.size(); i++) {
									if (alumnos
											.get(i)
											.getIdUsuario()
											.getUsername()
											.equalsIgnoreCase(
													alumn.getIdUsuario()
															.getUsername())) {
										alumnos.get(i).setIdCurso(course);
										this.getServletContext().setAttribute(
												"alumnos", alumnos);
										mensaje = "El alumno ya se ha matriculado en el curso";
									}
								}
							}
						} else {
							mensaje = "El alumno que desea añadir no existe en el sistema";
						}
					} else {
						mensaje = "No ha seleccionado una alumno al que añadir al curso";
					}
					forwardJSP = "/curso.jsp";
				} else if (accion != null
						&& "addProfesor".equalsIgnoreCase(accion)) {
					String nombreProfesor = "";
					if (request.getParameter("target") != null
							&& !"".equalsIgnoreCase(request
									.getParameter("target"))) {
						nombreProfesor = request.getParameter("target");
						ProfesorCurso profe=null;
						try {
							profe = profeDao.findByUsername(nombreProfesor);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (profe != null) {
							//boolean yaEnCurso = comprobarProfesorYaEnCurso(
									//profe, course);
							if (profe.getIdCurso().getIdCurso()==course.getIdCurso())
								mensaje = "El profesor ya esta dado de alta en el curso";

							if (mensaje == null) {
								profe.setIdCurso(course);
								profe.setTitular(false);
								profesoresCurso.add(profe);
								mensaje = "El profesor ya se ha añadido en el curso";
								this.getServletContext().setAttribute("cursos",
										cursos);
							}
						} else {
							mensaje = "El profesor que desea añadir no existe en el sistema";
						}
					} else {
						mensaje = "No ha seleccionado una profesor al que añadir al curso";
					}
					forwardJSP = "/curso.jsp";
				}
			}
		}
		if (mensaje != null) {
			request.setAttribute("mensaje", mensaje);
		}
		forward(request, response, forwardJSP);
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