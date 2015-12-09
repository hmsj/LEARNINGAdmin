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
	private SeccionCurso seccionCurso;
	private LeccionCurso leccionCurso;
	private MaterialLeccion materialLeccion;
	private AlumnoCurso alumnoCurso;
	private ProfesorCurso profesorCurso;
	private Dificultad dificultad;

	List<Curso> cursos = new ArrayList<Curso>();
	List<Categoria> categorias = new ArrayList<Categoria>();
	List<SeccionCurso> seccionesCurso = new ArrayList<SeccionCurso>();
	List<LeccionCurso> leccionesCurso = new ArrayList<LeccionCurso>();
	List<MaterialLeccion> materialesLeccion = new ArrayList<MaterialLeccion>();
	List<AlumnoCurso> alumnosCurso = new ArrayList<AlumnoCurso>();
	List<ProfesorCurso> profesoresCurso = new ArrayList<ProfesorCurso>();
	List<Dificultad> dificultades = new ArrayList<Dificultad>();
	List<ProfesorCurso> profesoresTitulares = new ArrayList<ProfesorCurso>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private CursoDao cursoDao;
	private CategoriaDao categoriaDao;
	private SeccionCursoDao seccionCursoDao;
	private LeccionCursoDao leccionCursoDao;
	private MaterialLeccionDao materialLeccionDao;
	private AlumnoCursoDao alumnoCursoDao;
	private ProfesorCursoDao profesorCursoDao;
	private DificultadDao dificultadDao;
	private UsuarioDao usuarioDao;
	

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
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		cursoDao = new CursoDaoImpl(em, ut);
		seccionCursoDao = new SeccionCursoDaoImpl(em, ut);
		leccionCursoDao = new LeccionCursoDaoImpl(em, ut);
		materialLeccionDao = new MaterialLeccionDaoImpl(em, ut);
		categoriaDao = new CategoriaDaoImpl(em, ut);
		dificultadDao = new DificultadDaoImpl(em, ut);
		profesorCursoDao = new ProfesorCursoDaoImpl(em, ut);
		usuarioDao = new UsuarioDaoImpl(em, ut);
		
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
			seccionesCurso = seccionCursoDao.findAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			alumnosCurso = alumnoCursoDao.findAll();
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
			profesoresTitulares = profesorCursoDao.listadoProfesTitulares();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			dificultades = dificultadDao.findAll();
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCursoParam = request.getParameter("idCurso");
		String mensajeOK = "";
		String mensajeError = "";
		HttpSession sesion = request.getSession(true);
		request.setAttribute("categorias", categorias);
		request.setAttribute("dificultades", dificultades);
		request.setAttribute("cursos", cursos);
		request.setAttribute("profesoresTitulares", profesoresTitulares);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String forwardJSP = "";
		String accion = request.getParameter("accion");
		
		if(usuarioLogado!=null && usuarioLogado.isAdmin()){
			if(accion==null || "".equalsIgnoreCase(accion)){
				if(idCursoParam!=null && !"".equalsIgnoreCase(idCursoParam)){
					Long idCurso = Long.parseLong(idCursoParam);
					Curso course = null;
					try {
						course  = cursoDao.findById(idCurso);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (course!=null){
						ProfesorCurso profesorTitularCurso = null;
						try {
							profesorTitularCurso = profesorCursoDao.ProfeTitularCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List<AlumnoCurso> listadoAlumnosCurso = null;
						try {
							listadoAlumnosCurso = alumnoCursoDao.listadoAlumnosEnUnCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						List<ProfesorCurso> profesoresInvitadosCurso = null;
						try {
							profesoresInvitadosCurso = profesorCursoDao.listadoProfesInvitadosUnCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List<SeccionCurso> listadoSeccionesDelCurso = null;
						try {
							listadoSeccionesDelCurso = seccionCursoDao.listadoSeccionesUnCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List<LeccionCurso> listadoLeccionesDelCurso = null;
						if(listadoSeccionesDelCurso!=null){
							for (int i = 0; i < listadoSeccionesDelCurso.size(); i++) {
								try {
									listadoLeccionesDelCurso = leccionCursoDao.ListadoLeccionesUnaSeccion(listadoSeccionesDelCurso.get(i).getIdSeccion());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						List<MaterialLeccion> listadoMaterialesLeccion = null;
						if(listadoLeccionesDelCurso!=null){
							for (int i = 0; i < listadoLeccionesDelCurso.size(); i++) {
								try {
									listadoMaterialesLeccion = materialLeccionDao.listadoMaterialesLeccion(listadoLeccionesDelCurso.get(i).getIdLeccion());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						request.setAttribute("curso", course);
						request.setAttribute("profesorTitularCurso", profesorTitularCurso);
						request.setAttribute("profesoresInvitadosCurso", profesoresInvitadosCurso);
						request.setAttribute("listadoAlumnosCurso", listadoAlumnosCurso);
						request.setAttribute("usuarios", usuarios);
						request.setAttribute("listadoSeccionesDelCurso", listadoSeccionesDelCurso);
						request.setAttribute("listadoLeccionesDelCurso", listadoLeccionesDelCurso);
						request.setAttribute("listadoMaterialesLeccion", listadoMaterialesLeccion);
						forwardJSP = "/curso.jsp";
					}else {
						mensajeError = "Se ha producido un error al acceder a los datos";
						request.setAttribute("mensajeError", mensajeError);
						forwardJSP = "/curso.jsp";
					}
				}else{
					forwardJSP = "/listadoCursos.jsp";
				}
			}
		}
		
		
		/*if (idCursoParam != null && !"".equals(idCursoParam)) {
			long idCurso = Integer.parseInt(idCursoParam);
			Curso course = null;
			try {
				course = cursoDao.findById(idCurso);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (course != null) {
				if (usuarioLogado != null && usuarioLogado.isAdmin()) {
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
								alumn = alumnoCursoDao.comprobarAlumnoEnCurso(
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
									// TODO Llamar metodo para eliminar alumnos
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
								boolean yaEnCurso = comprobarProfesorYaEnCurso(
										profe, course);
								if (profeAyudante.isTitular()) {
									// TODO Llamar metodo DAO para eliminar profesor invitado
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
					request.setAttribute("curso", course);
					forwardJSP = "/curso.jsp";
				}
			}
		}*/
		
		forward(request, response, forwardJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCursoParam = request.getParameter("idCurso");
		String mensajeOK = "";
		String mensajeError = "";
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		
		
		
		/*if (idCursoParam != null && !"".equals(idCursoParam)) {
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
							alumn = alumnoCursoDao.comprobarAlumnoEnCurso(nombreAlumno, idCurso);
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
								for (int i = 0; i < alumnosCurso.size(); i++) {
									if (alumnosCurso
											.get(i)
											.getIdUsuario()
											.getUsername()
											.equalsIgnoreCase(
													alumn.getIdUsuario()
															.getUsername())) {
										alumnosCurso.get(i).setIdCurso(course);
										this.getServletContext().setAttribute(
												"alumnos", alumnosCurso);
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
							profe = profesorCursoDao.findByUsername(nombreProfesor);
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
		forward(request, response, forwardJSP);*/
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