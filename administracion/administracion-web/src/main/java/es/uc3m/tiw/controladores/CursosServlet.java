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
			categorias = null;
		}
		List<SeccionCurso> seccionesCurso = null;
		try {
			seccionesCurso = seccionCursoDao.findAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			seccionesCurso = null;
		}
		List<LeccionCurso> leccionesCurso = null;
		try {
			leccionesCurso = leccionCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			leccionesCurso = null;
		}
		List<MaterialLeccion> materialesLeccion = null;
		try {
			materialesLeccion = materialLeccionDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			materialesLeccion = null;
		}
		List<AlumnoCurso> alumnosCurso = null;
		try {
			alumnosCurso = alumnoCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			alumnosCurso = null;
		}
		List<ProfesorCurso> profesoresCurso = null; 
		try {
			profesoresCurso = profesorCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			profesoresCurso = null; 
		}
		List<ProfesorCurso> profesoresTitulares = null;
		try {
			profesoresTitulares = profesorCursoDao.listadoProfesTitulares();
		} catch (Exception e) {
			// TODO: handle exception
			profesoresTitulares = null;
		}
		List<Dificultad> dificultades = null;
		try {
			dificultades = dificultadDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dificultades = null;
		}
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			usuarios = null;
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
						course = null;
					}
					if (course!=null){
						ProfesorCurso profesorTitularCurso = null;
						try {
							profesorTitularCurso = profesorCursoDao.ProfeTitularCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							profesorTitularCurso = null;
						}
						List<AlumnoCurso> listadoAlumnosCurso = null;
						try {
							listadoAlumnosCurso = alumnoCursoDao.listadoAlumnosEnUnCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							listadoAlumnosCurso = null;
						} 
						List<ProfesorCurso> profesoresInvitadosCurso = null;
						try {
							profesoresInvitadosCurso = profesorCursoDao.listadoProfesInvitadosUnCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							profesoresInvitadosCurso = null;
						}
						List<SeccionCurso> listadoSeccionesDelCurso = null;
						try {
							listadoSeccionesDelCurso = seccionCursoDao.listadoSeccionesUnCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							listadoSeccionesDelCurso = null;
						}
						List<LeccionCurso> listadoLeccionesDelCurso = null;
						try {
							listadoLeccionesDelCurso = leccionCursoDao.ListadoLeccionesUnCurso(course.getIdCurso());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							listadoLeccionesDelCurso = null;
						}
						List<MaterialLeccion> listadoMaterialesDelCurso = null;
						try {
							listadoMaterialesDelCurso = materialLeccionDao.listadoMaterialesCurso(course.getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							listadoMaterialesDelCurso = null;
						}
						List<Promocion> listadoPromociones = null;
						try {
							listadoPromociones = promocionDao.findAll();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							listadoPromociones = null;
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
						cursoVal = null;
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
				course = null;
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
								alumn2 = alumnoCursoDao.comprobarAlumnoCursado(nombreAlumno, idCurso);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								alumn2 = null;
							}
							if (alumn == null  && alumn2 == null) {
								AlumnoCurso nuevoAlumno = new AlumnoCurso();
								Usuario user = null;
								try {
									user = usuarioDao.findByUsername(nombreAlumno);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									user = null;
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
													pedidoCreado = pedidoDao.createPedido(pedido);
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													pedidoCreado = null;
												}
												if(pedidoCreado!=null){
													nuevoAlumno.setIdUsuario(user);
													nuevoAlumno.setIdCurso(course);
													nuevoAlumno.setEnCurso(true);
													nuevoAlumno.setIdPedido(pedido);
													AlumnoCurso alumnoMatriculado = null;
													try {
														alumnoMatriculado = alumnoCursoDao.createAlumnoCurso(nuevoAlumno);
													} catch (Exception e) {
														// TODO Auto-generated catch block
														alumnoMatriculado = null;
													}
													if(alumnoMatriculado!=null){	
														mensajeOK = "El alumno ha sido matriculado correctamente en el curso";
														request.setAttribute("alumnoMatriculado", alumnoMatriculado);
														request.setAttribute("pedidoCreado", pedidoCreado);
														forwardJSP = "/ticketPedido.jsp";													
													}
												}else{
													mensajeError = "Se ha producido un error";
													forwardJSP = "/curso.jsp";
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
							}else if(alumn!=null){
								mensajeError = "El alumno ya esta matriculado en este curso";
								forwardJSP = "/curso.jsp";
								
							}else if(alumn2!=null){
								mensajeError = "EL alumno ya ha realizado este curso";
								forwardJSP = "/curso.jsp";
							}
						}else{
							List<AlumnoCurso> listadoAlumnosCurso = null;
							try {
								listadoAlumnosCurso = alumnoCursoDao.listadoAlumnosEnUnCurso(course.getIdCurso());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								listadoAlumnosCurso = null;
							} 
							mensajeError = "Debe introducir un numero de tarjeta para matricular al alumno";
							forwardJSP = "/curso.jsp";
						}
					} else {
						mensajeError = "No ha seleccionado un alumno al que añadir al curso";
						forwardJSP = "/curso.jsp";
					}
				}
				List<AlumnoCurso> listadoAlumnosCurso = null;
				try {
					listadoAlumnosCurso = alumnoCursoDao.listadoAlumnosEnUnCurso(course.getIdCurso());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					listadoAlumnosCurso = null;
				} 
				ProfesorCurso profesorTitularCurso = null;
				try {
					profesorTitularCurso = profesorCursoDao.ProfeTitularCurso(course.getIdCurso());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					profesorTitularCurso = null;
				}
				
				List<ProfesorCurso> profesoresInvitadosCurso = null;
				try {
					profesoresInvitadosCurso = profesorCursoDao.listadoProfesInvitadosUnCurso(course.getIdCurso());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					profesoresInvitadosCurso = null;
				}
				List<SeccionCurso> listadoSeccionesDelCurso = null;
				try {
					listadoSeccionesDelCurso = seccionCursoDao.listadoSeccionesUnCurso(course.getIdCurso());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					listadoSeccionesDelCurso = null;
				}
				List<LeccionCurso> listadoLeccionesDelCurso = null;
				try {
					listadoLeccionesDelCurso = leccionCursoDao.ListadoLeccionesUnCurso(course.getIdCurso());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					listadoLeccionesDelCurso = null;
				}
				List<MaterialLeccion> listadoMaterialesDelCurso = null;
				try {
					listadoMaterialesDelCurso = materialLeccionDao.listadoMaterialesCurso(course.getIdCurso());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					listadoMaterialesDelCurso = null;
				}
				List<Promocion> listadoPromociones = null;
				try {
					listadoPromociones = promocionDao.findAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					listadoPromociones = null;
				}
				List<Usuario> usuarios = null;
				try {
					usuarios = usuarioDao.findAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					usuarios = null;
				}
				if(mensajeOK != null && !"".equalsIgnoreCase(mensajeOK)){
					request.setAttribute("mensajeOK", mensajeOK);
				}else if (mensajeError != null && !"".equalsIgnoreCase(mensajeError)){
					request.setAttribute("mensajeError", mensajeError);
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