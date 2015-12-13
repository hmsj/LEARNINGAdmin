package es.uc3m.tiw.controladores;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import es.uc3m.tiw.daos.PedidoDao;
import es.uc3m.tiw.daos.PedidoDaoImpl;
import es.uc3m.tiw.daos.ProfesorCursoDao;
import es.uc3m.tiw.daos.ProfesorCursoDaoImpl;
import es.uc3m.tiw.daos.PromocionDao;
import es.uc3m.tiw.daos.PromocionDaoImpl;
import es.uc3m.tiw.daos.SeccionCursoDao;
import es.uc3m.tiw.daos.SeccionCursoDaoImpl;
import es.uc3m.tiw.daos.UsuarioDao;
import es.uc3m.tiw.daos.UsuarioDaoImpl;
import es.uc3m.tiw.ejb.GestionadorPedidos;
import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Categoria;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Dificultad;
import es.uc3m.tiw.model.LeccionCurso;
import es.uc3m.tiw.model.MaterialLeccion;
import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.Promocion;
import es.uc3m.tiw.model.SeccionCurso;
import es.uc3m.tiw.model.Usuario;

/**
 * Servlet implementation class CursosServlet
 */
@WebServlet(value = "/cursos")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 2,  // 2 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 50, // 50 MB
        location            = "/"
)
public class CursosServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5079331756861773626L;

	private static final String UPLOAD_DIR = "img/courses";
	
	@EJB
	private GestionadorPedidos gestionadorPedidos;
	
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
	private PromocionDao promocionDao;
	private PedidoDao pedidoDao;
	
	
	
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
		promocionDao = new PromocionDaoImpl(em, ut);
		pedidoDao = new PedidoDaoImpl(em, ut);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Curso> cursos = null;
		try {
			cursos = cursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Categoria> categorias = null;
		try {
			categorias = categoriaDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SeccionCurso> seccionesCurso = null;
		try {
			seccionesCurso = seccionCursoDao.findAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<LeccionCurso> leccionesCurso = null;
		try {
			leccionesCurso = leccionCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MaterialLeccion> materialesLeccion = null;
		try {
			materialesLeccion = materialLeccionDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AlumnoCurso> alumnosCurso = null;
		try {
			alumnosCurso = alumnoCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ProfesorCurso> profesoresCurso = null; 
		try {
			profesoresCurso = profesorCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ProfesorCurso> profesoresTitulares = null;
		try {
			profesoresTitulares = profesorCursoDao.listadoProfesTitulares();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		List<Dificultad> dificultades = null;
		try {
			dificultades = dificultadDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
						try {
							listadoLeccionesDelCurso = leccionCursoDao.ListadoLeccionesUnCurso(course.getIdCurso());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						List<MaterialLeccion> listadoMaterialesDelCurso = null;
						try {
							listadoMaterialesDelCurso = materialLeccionDao.listadoMaterialesCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List<Promocion> listadoPromociones = null;
						try {
							listadoPromociones = promocionDao.findAll();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.setAttribute("curso", course);
						request.setAttribute("profesorTitularCurso", profesorTitularCurso);
						request.setAttribute("profesoresInvitadosCurso", profesoresInvitadosCurso);
						request.setAttribute("listadoAlumnosCurso", listadoAlumnosCurso);
						request.setAttribute("usuarios", usuarios);
						request.setAttribute("listadoSeccionesDelCurso", listadoSeccionesDelCurso);
						request.setAttribute("listadoLeccionesDelCurso", listadoLeccionesDelCurso);
						request.setAttribute("listadoMaterialesLeccion", listadoMaterialesDelCurso);
						request.setAttribute("listadoPromociones", listadoPromociones);
						forwardJSP = "/curso.jsp";
					}else {
						mensajeError = "Se ha producido un error al acceder a los datos";
						request.setAttribute("mensajeError", mensajeError);
						forwardJSP = "/curso.jsp";
					}
				}else{
					
					forwardJSP = "/listadoCursos.jsp";
				}
			}else if(accion=="validarCurso"){
				if(request.getParameter("idCurso")!=null && !"".equalsIgnoreCase(request.getParameter("idCurso"))){
					Curso cursoVal = null;
					try {
						cursoVal = cursoDao.findById(Long.parseLong(request.getParameter("idCurso")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					if(cursoVal != null && !cursoVal.isValidado()){
						cursoVal.setValidado(true);
						try {
							cursoDao.modifyCurso(cursoVal);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						mensajeOK = "Curso validado";
						request.setAttribute("mensajeOK", mensajeOK);
						forwardJSP = "/curso.jsp";
					}
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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCursoParam = request.getParameter("idCurso");
		String mensajeOK = "";
		String mensajeError = "";
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String forwardJSP = "";
		
		if (idCursoParam != null && !"".equals(idCursoParam)) {
			Long idCurso = Long.parseLong(idCursoParam);
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
						if(request.getParameter("tarjeta")!=null && !"".equalsIgnoreCase(request.getParameter("tarjeta"))){
							String numTarjeta = request.getParameter("tarjeta");
							AlumnoCurso alumn = null;
							try {
								alumn = alumnoCursoDao.comprobarAlumnoEnCurso(nombreAlumno, idCurso);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								alumn = null;
							}
							AlumnoCurso alumn2 = null;
							try {
								alumn = alumnoCursoDao.comprobarAlumnoCursado(nombreAlumno, idCurso);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								alumn2 = null;
							}
							if (alumn == null  && alumn2 == null) {
								AlumnoCurso nuevoAlumno = null;
								Usuario user = null;
								try {
									user = usuarioDao.findByUsername(nombreAlumno);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									nuevoAlumno = null;
								}
								if(user!=null){
									if(numTarjeta.length()==20){
										boolean tarjetaok = false;
										if (numTarjeta.substring(0,1).equalsIgnoreCase("A") || numTarjeta.substring(0,1).equalsIgnoreCase("B"))
											tarjetaok = true;
										if (tarjetaok)
										{
											Pedido pedido = null;
											pedido = gestionadorPedidos.generarPedido(course, user, numTarjeta, em, ut);
											if(pedido!=null){
												Pedido pedidoCreado = null;
												try {
													pedidoDao.createPedido(pedido);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													pedidoCreado = null;
												}
												if(pedidoCreado!=null){
													nuevoAlumno.setIdUsuario(user);
													nuevoAlumno.setIdCurso(course);
													nuevoAlumno.setEnCurso(true);
													nuevoAlumno.setIdPedido(pedidoCreado);
													AlumnoCurso alumnoMatriculado = null;
													try {
														alumnoMatriculado = alumnoCursoDao.createAlumnoCurso(nuevoAlumno);
													} catch (Exception e) {
														// TODO Auto-generated catch block
														alumnoMatriculado = null;
													}
													if(alumnoMatriculado!=null){
														
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
															try {
																listadoLeccionesDelCurso = leccionCursoDao.ListadoLeccionesUnCurso(course.getIdCurso());
															} catch (Exception e1) {
																// TODO Auto-generated catch block
																e1.printStackTrace();
															}
															List<MaterialLeccion> listadoMaterialesDelCurso = null;
															try {
																listadoMaterialesDelCurso = materialLeccionDao.listadoMaterialesCurso(course.getIdCurso());
															} catch (Exception e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
															List<Promocion> listadoPromociones = null;
															try {
																listadoPromociones = promocionDao.findAll();
															} catch (Exception e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
															List<Usuario> usuarios = null;
															try {
																usuarios = usuarioDao.findAll();
															} catch (Exception e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
															
														mensajeOK = "El alumno ha sido matriculado correctamente en el curso";
														forwardJSP = "/curso.jsp";
														request.setAttribute("mensajeOK", mensajeOK);
														request.setAttribute("curso", course);
														request.setAttribute("profesorTitularCurso", profesorTitularCurso);
														request.setAttribute("profesoresInvitadosCurso", profesoresInvitadosCurso);
														request.setAttribute("listadoAlumnosCurso", listadoAlumnosCurso);
														request.setAttribute("usuarios", usuarios);
														request.setAttribute("listadoSeccionesDelCurso", listadoSeccionesDelCurso);
														request.setAttribute("listadoLeccionesDelCurso", listadoLeccionesDelCurso);
														request.setAttribute("listadoMaterialesLeccion", listadoMaterialesDelCurso);
														request.setAttribute("listadoPromociones", listadoPromociones);
														forward(request, response, forwardJSP);
														}
													}
												}
											}
										}
										else{
											mensajeError = "La tarjeta introducida no es valida, debe empezar por A o B";
											forwardJSP = "/curso.jsp";
										}	
									}
									else{
										mensajeError = "La tarjeta introducida no es valida, debe tener 20 caracteres";
										forwardJSP = "/curso.jsp";
									}								
								}
							}
						}else{
							mensajeError = "Debe introducir un numero de tarjeta para matricular al alumno";
							forwardJSP = "/curso.jsp";
						}
					} else {
						mensajeError = "No ha seleccionado una alumno al que añadir al curso";
					}
					forwardJSP = "/curso.jsp";
				} /*else if (accion != null
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
			}*/
				request.setAttribute("mensajeError", mensajeError);
		}
		
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