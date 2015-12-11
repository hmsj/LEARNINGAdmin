package es.uc3m.tiw.controladores;

import java.io.File;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.AlumnoCursoDao;
import es.uc3m.tiw.daos.AlumnoCursoDaoImpl;
import es.uc3m.tiw.daos.CursoDao;
import es.uc3m.tiw.daos.CursoDaoImpl;
import es.uc3m.tiw.daos.LeccionCursoDao;
import es.uc3m.tiw.daos.LeccionCursoDaoImpl;
import es.uc3m.tiw.daos.MaterialLeccionDao;
import es.uc3m.tiw.daos.MaterialLeccionDaoImpl;
import es.uc3m.tiw.daos.ProfesorCursoDao;
import es.uc3m.tiw.daos.ProfesorCursoDaoImpl;
import es.uc3m.tiw.daos.PromocionDao;
import es.uc3m.tiw.daos.PromocionDaoImpl;
import es.uc3m.tiw.daos.SeccionCursoDao;
import es.uc3m.tiw.daos.SeccionCursoDaoImpl;
import es.uc3m.tiw.daos.TipoPromocionDao;
import es.uc3m.tiw.daos.TipoPromocionDaoImpl;
import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.LeccionCurso;
import es.uc3m.tiw.model.MaterialLeccion;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.Promocion;
import es.uc3m.tiw.model.SeccionCurso;
import es.uc3m.tiw.model.Usuario;


/**
 * Servlet implementation class PromocionServlet
 */
@WebServlet("/material")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50, // 50MB
location="/")
public class MaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String SAVE_DIR = "materiales";
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private CursoDao cursoDao;
	private SeccionCursoDao seccionCursoDao;
	private LeccionCursoDao leccionCursoDao;
	private MaterialLeccionDao materialLeccionDao;
	private PromocionDao promocionDao;
	private AlumnoCursoDao alumnoCursoDao;
	private ProfesorCursoDao profesorCursoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		cursoDao = new CursoDaoImpl(em, ut);
		seccionCursoDao = new SeccionCursoDaoImpl(em, ut);
		leccionCursoDao = new LeccionCursoDaoImpl(em, ut);
		materialLeccionDao = new MaterialLeccionDaoImpl(em, ut);
		profesorCursoDao = new ProfesorCursoDaoImpl(em, ut);
		promocionDao = new PromocionDaoImpl(em, ut);
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(true);
		String forwardJSP = "";
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String accion = request.getParameter("accion");
		String mensajeError ="";
		Curso curso = null;
		if(request.getParameter("idCurso")!=null && !"".equalsIgnoreCase(request.getParameter("idCurso"))){
			try {
				curso = cursoDao.findById(Long.parseLong(request.getParameter("idCurso")));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(accion.equalsIgnoreCase("material")){
				List<LeccionCurso> listadoLeccionesCurso = null;
				try {
					listadoLeccionesCurso = leccionCursoDao.ListadoLeccionesUnCurso(Long.parseLong(request.getParameter("idCurso")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(listadoLeccionesCurso != null){
					request.setAttribute("listadoLeccionesCurso", listadoLeccionesCurso);
					request.setAttribute("curso", curso);
					forwardJSP = "/crearMaterial.jsp";
				}
			}else if(accion.equalsIgnoreCase("leccion")){
				List<SeccionCurso> listadoSeccionesCurso = null;
				try {
					listadoSeccionesCurso = seccionCursoDao.listadoSeccionesUnCurso(Long.parseLong(request.getParameter("idCurso")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(listadoSeccionesCurso != null){
					request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
					request.setAttribute("curso", curso);
					forwardJSP = "/crearLeccion.jsp";
				}
			}else if(accion.equalsIgnoreCase("seccion")){
				request.setAttribute("curso", curso);
				forwardJSP = "/crearSeccion.jsp";
			}else{
				mensajeError = "Se ha producido un error";
				request.setAttribute("mensajeError", mensajeError);
				forwardJSP = "/principal.jsp";
				forward(request, response, forwardJSP);
			}
		}
		
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
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		
		MaterialLeccion nuevoMaterial = new MaterialLeccion();
		
		Curso curso = null;
		LeccionCurso leccionCurso = null;
		List<LeccionCurso> listadoLeccionesCurso = null;
		List<SeccionCurso> listadoSeccionesCurso = null;
		
		String titulo = "";	
		String descripcion = "";		
		
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String accion = request.getParameter("accion");
		
		if(usuarioLogado!=null){
			if(accion.equalsIgnoreCase("material")){
				if(request.getParameter("idCurso")!=null && !"".equalsIgnoreCase(request.getParameter("idCurso"))){
					try {
						listadoLeccionesCurso = leccionCursoDao.ListadoLeccionesUnCurso(Long.parseLong(request.getParameter("idCurso")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(request.getParameter("leccionMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("leccionMaterial"))){
					try {
						leccionCurso = leccionCursoDao.findById(Long.parseLong(request.getParameter("leccionMaterial")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(leccionCurso!=null){
						try {
							curso = cursoDao.findById(leccionCurso.getIdSeccion().getIdCurso().getIdCurso());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(request.getParameter("tituloMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("tituloMaterial"))){
						titulo = request.getParameter("tituloMaterial");
						if(request.getParameter("descripcionMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("descripcionMaterial"))){
							descripcion = request.getParameter("descripcionMaterial");
								File fileSaveDir = new File(savePath);
								if (!fileSaveDir.exists()) {
									fileSaveDir.mkdir();
								}
								String fileName = "";
								for (Part part : request.getParts()) {
									fileName = extractFileName(part);
									if (!"".equalsIgnoreCase(fileName)){
										part.write(savePath + File.separator + fileName);
										break;
									}
								}
								if(leccionCurso!=null && titulo!=null && !"".equalsIgnoreCase(titulo) && descripcion!=null && !"".equalsIgnoreCase(descripcion) && fileName!=null && !"".equalsIgnoreCase(fileName)){
									nuevoMaterial.setTitulo(titulo);
									nuevoMaterial.setDescripcion(descripcion);
									nuevoMaterial.setFichero(savePath + File.separator + fileName);
									nuevoMaterial.setIdLeccion(leccionCurso);
									try {
										materialLeccionDao.createMaterialLeccion(nuevoMaterial);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									mensajeOK = "Material añadido correctamente";
									request.setAttribute("mensajeOK", mensajeOK);
									if (curso!=null){
										ProfesorCurso profesorTitularCurso = null;
										try {
											profesorTitularCurso = profesorCursoDao.ProfeTitularCurso(curso.getIdCurso());
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										List<AlumnoCurso> listadoAlumnosCurso = null;
										try {
											listadoAlumnosCurso = alumnoCursoDao.listadoAlumnosEnUnCurso(curso.getIdCurso());
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										List<ProfesorCurso> profesoresInvitadosCurso = null;
										try {
											profesoresInvitadosCurso = profesorCursoDao.listadoProfesInvitadosUnCurso(curso.getIdCurso());
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										List<SeccionCurso> listadoSeccionesDelCurso = null;
										try {
											listadoSeccionesDelCurso = seccionCursoDao.listadoSeccionesUnCurso(curso.getIdCurso());
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										List<LeccionCurso> listadoLeccionesDelCurso = null;
										try {
											listadoLeccionesDelCurso = leccionCursoDao.ListadoLeccionesUnCurso(curso.getIdCurso());
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										List<MaterialLeccion> listadoMaterialesDelCurso = null;
										try {
											listadoMaterialesDelCurso = materialLeccionDao.listadoMaterialesCurso(curso.getIdCurso());
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
										request.setAttribute("curso", curso);
										request.setAttribute("profesorTitularCurso", profesorTitularCurso);
										request.setAttribute("profesoresInvitadosCurso", profesoresInvitadosCurso);
										request.setAttribute("listadoAlumnosCurso", listadoAlumnosCurso);
										request.setAttribute("listadoSeccionesDelCurso", listadoSeccionesDelCurso);
										request.setAttribute("listadoLeccionesDelCurso", listadoLeccionesDelCurso);
										request.setAttribute("listadoMaterialesLeccion", listadoMaterialesDelCurso);
										request.setAttribute("listadoPromociones", listadoPromociones);
										forwardJSP = "/curso.jsp";
										forward(request, response, forwardJSP);
									}
									
								}else{
									mensajeError = "Debe rellenar todos los campos";
									request.setAttribute("listadoLeccionesCurso", listadoLeccionesCurso);
									request.setAttribute("mensajeError", mensajeError);
									forwardJSP = "/crearMaterial.jsp";
									forward(request, response, forwardJSP);
								}
						
						}else{
							mensajeError = "Debe añadir una descripcion";
							request.setAttribute("listadoLeccionesCurso", listadoLeccionesCurso);
							request.setAttribute("mensajeError", mensajeError);
							forwardJSP = "/crearMaterial.jsp";
							forward(request, response, forwardJSP);
						}
					}else{
						mensajeError = "Debe añadir un titulo";
						request.setAttribute("listadoLeccionesCurso", listadoLeccionesCurso);
						request.setAttribute("mensajeError", mensajeError);
						forwardJSP = "/crearMaterial.jsp";
						forward(request, response, forwardJSP);
					}
				}else{
					mensajeError = "Debe seleccionar una leccion del listado";
					request.setAttribute("listadoLeccionesCurso", listadoLeccionesCurso);
					request.setAttribute("mensajeError", mensajeError);
					forwardJSP = "/crearMaterial.jsp";
					forward(request, response, forwardJSP);
				}
			}else if(accion.equalsIgnoreCase("leccion")){
				if(request.getParameter("idCurso")!=null && !"".equalsIgnoreCase(request.getParameter("idCurso"))){
					try {
						listadoSeccionesCurso = seccionCursoDao.listadoSeccionesUnCurso(Long.parseLong(request.getParameter("idCurso")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				LeccionCurso nuevaLeccionCurso = new LeccionCurso();
				if(request.getParameter("seccionLeccion")!=null && !"".equalsIgnoreCase(request.getParameter("seccionLeccion"))){
					SeccionCurso seccion = null;
					try {
						seccion = seccionCursoDao.findById(Long.parseLong(request.getParameter("seccionLeccion")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					nuevaLeccionCurso.setIdSeccion(seccion);
					if(request.getParameter("tituloLeccion")!=null && !"".equalsIgnoreCase(request.getParameter("tituloLeccion"))){
						nuevaLeccionCurso.setTitulo(request.getParameter("tituloLeccion"));
						if(request.getParameter("descripcionLeccion")!=null && !"".equalsIgnoreCase(request.getParameter("descripcionLeccion"))){
							nuevaLeccionCurso.setDescripcion(request.getParameter("descripcionLeccion"));
							LeccionCurso leccion = null;
							try {
								leccion = leccionCursoDao.createLeccionCurso(nuevaLeccionCurso);
							} catch (Exception e2) {
								// TODO Auto-generated catch block
								leccion = null;
							}
							if(leccion!=null){
								nuevoMaterial.setIdLeccion(leccion);
							}
							if(request.getParameter("tituloMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("tituloMaterial"))){
								titulo = request.getParameter("tituloMaterial");
								if(request.getParameter("descripcionMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("descripcionMaterial"))){
									descripcion = request.getParameter("descripcionMaterial");
										File fileSaveDir = new File(savePath);
										if (!fileSaveDir.exists()) {
											fileSaveDir.mkdir();
										}
										String fileName = "";
										for (Part part : request.getParts()) {
											fileName = extractFileName(part);
											if (!"".equalsIgnoreCase(fileName)){
												part.write(savePath + File.separator + fileName);
												break;
											}
										}
										if(titulo!=null && !"".equalsIgnoreCase(titulo) && descripcion!=null && !"".equalsIgnoreCase(descripcion) && fileName!=null && !"".equalsIgnoreCase(fileName)){
											nuevoMaterial.setTitulo(titulo);
											nuevoMaterial.setDescripcion(descripcion);
											nuevoMaterial.setFichero(savePath + File.separator + fileName);
											
											try {
												materialLeccionDao.createMaterialLeccion(nuevoMaterial);
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											mensajeOK = "Leccion añadida correctamente";
											request.setAttribute("mensajeOK", mensajeOK);
											forwardJSP = "/principal.jsp";
											forward(request, response, forwardJSP);
											
										}else{
											mensajeError = "Debe rellenar todos los campos";
											request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
											request.setAttribute("mensajeError", mensajeError);
											forwardJSP = "/crearLeccion.jsp";
											forward(request, response, forwardJSP);
										}
								
								}else{
									mensajeError = "Debe añadir una descripcion";
									request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
									request.setAttribute("mensajeError", mensajeError);
									forwardJSP = "/crearLeccion.jsp";
									forward(request, response, forwardJSP);
								}
							}else{
								mensajeError = "Debe añadir un titulo";
								request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
								request.setAttribute("mensajeError", mensajeError);
								forwardJSP = "/crearLeccion.jsp";
								forward(request, response, forwardJSP);
							}
								
						}else{
							mensajeError = "Debe añadir una descripcion de leccion";
							request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
							request.setAttribute("mensajeError", mensajeError);
							forwardJSP = "/crearLeccion.jsp";
							forward(request, response, forwardJSP);
						}
					}else{
						mensajeError = "Debe añadir un titulo de leccion";
						request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
						request.setAttribute("mensajeError", mensajeError);
						forwardJSP = "/crearLeccion.jsp";
						forward(request, response, forwardJSP);
					}
				}else{
					mensajeError = "Debe seleccionar una seccion del listado";
					request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
					request.setAttribute("mensajeError", mensajeError);
					forwardJSP = "/crearLeccion.jsp";
					forward(request, response, forwardJSP);
				}
			}else if(accion.equalsIgnoreCase("seccion")){
				SeccionCurso nuevaSeccionCurso = new SeccionCurso();
				LeccionCurso leccionSeccion = new LeccionCurso();
				if(request.getParameter("idCurso")!=null && !"".equalsIgnoreCase(request.getParameter("idCurso"))){
					Curso cursoSeccion = null;
					try {
						cursoSeccion = cursoDao.findById(Long.parseLong(request.getParameter("idCurso")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					nuevaSeccionCurso.setIdCurso(cursoSeccion);
				}
				if(request.getParameter("tituloSeccion")!=null && !"".equalsIgnoreCase(request.getParameter("tituloSeccion"))){
					nuevaSeccionCurso.setTitulo(request.getParameter("tituloSeccion"));
					if(request.getParameter("descripcionSeccion")!=null && !"".equalsIgnoreCase(request.getParameter("descripcionSeccion"))){
						nuevaSeccionCurso.setDescripcion(request.getParameter("descripcionSeccion"));
						
						SeccionCurso seccionCreada =  null;
						try {
							seccionCreada = seccionCursoDao.createSeccionCurso(nuevaSeccionCurso);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							seccionCreada =  null;
						}
						if(seccionCreada !=  null)
							leccionSeccion.setIdSeccion(seccionCreada);
						if(request.getParameter("tituloLeccion")!=null && !"".equalsIgnoreCase(request.getParameter("tituloLeccion"))){
							leccionSeccion.setTitulo(request.getParameter("tituloLeccion"));
							if(request.getParameter("descripcionLeccion")!=null && !"".equalsIgnoreCase(request.getParameter("descripcionLeccion"))){
								leccionSeccion.setDescripcion(request.getParameter("descripcionLeccion"));
								LeccionCurso leccion = null;
								try {
									leccion = leccionCursoDao.createLeccionCurso(leccionSeccion);
								} catch (Exception e2) {
									// TODO Auto-generated catch block
									leccion = null;
								}
								if(leccion!=null){
									nuevoMaterial.setIdLeccion(leccion);
								}
								if(request.getParameter("tituloMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("tituloMaterial"))){
									titulo = request.getParameter("tituloMaterial");
									if(request.getParameter("descripcionMaterial")!=null && !"".equalsIgnoreCase(request.getParameter("descripcionMaterial"))){
										descripcion = request.getParameter("descripcionMaterial");
											File fileSaveDir = new File(savePath);
											if (!fileSaveDir.exists()) {
												fileSaveDir.mkdir();
											}
											String fileName = "";
											for (Part part : request.getParts()) {
												fileName = extractFileName(part);
												if (!"".equalsIgnoreCase(fileName)){
													part.write(savePath + File.separator + fileName);
													break;
												}
											}
											if(titulo!=null && !"".equalsIgnoreCase(titulo) && descripcion!=null && !"".equalsIgnoreCase(descripcion) && fileName!=null && !"".equalsIgnoreCase(fileName)){
												nuevoMaterial.setTitulo(titulo);
												nuevoMaterial.setDescripcion(descripcion);
												nuevoMaterial.setFichero(savePath + File.separator + fileName);
												
												try {
													materialLeccionDao.createMaterialLeccion(nuevoMaterial);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												mensajeOK = "Seccion añadida correctamente";
												request.setAttribute("mensajeOK", mensajeOK);
												forwardJSP = "/principal.jsp";
												forward(request, response, forwardJSP);
												
											}else{
												mensajeError = "Debe rellenar todos los campos";
												request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
												request.setAttribute("mensajeError", mensajeError);
												forwardJSP = "/crearLeccion.jsp";
												forward(request, response, forwardJSP);
											}
									
									}else{
										mensajeError = "Debe añadir una descripcion";
										request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
										request.setAttribute("mensajeError", mensajeError);
										forwardJSP = "/crearLeccion.jsp";
										forward(request, response, forwardJSP);
									}
								}else{
									mensajeError = "Debe añadir un titulo";
									request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
									request.setAttribute("mensajeError", mensajeError);
									forwardJSP = "/crearLeccion.jsp";
									forward(request, response, forwardJSP);
								}
									
							}else{
								mensajeError = "Debe añadir una descripcion de leccion";
								request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
								request.setAttribute("mensajeError", mensajeError);
								forwardJSP = "/crearLeccion.jsp";
								forward(request, response, forwardJSP);
							}
						}else{
							mensajeError = "Debe añadir un titulo de leccion";
							request.setAttribute("listadoSeccionesCurso", listadoSeccionesCurso);
							request.setAttribute("mensajeError", mensajeError);
							forwardJSP = "/crearLeccion.jsp";
							forward(request, response, forwardJSP);
						}
					}else{
						mensajeError = "Debe añadir una descripcion de seccion";
						request.setAttribute("mensajeError", mensajeError);
						forwardJSP = "/crearSeccion.jsp";
						forward(request, response, forwardJSP);
					}
				}else{
					mensajeError = "Debe añadir un titulo de seccion";
					request.setAttribute("mensajeError", mensajeError);
					forwardJSP = "/crearSeccion.jsp";
					forward(request, response, forwardJSP);
				}
			}else{
				mensajeError = "Se ha producido un error";
				request.setAttribute("mensajeError", mensajeError);
				forwardJSP = "/principal.jsp";
				forward(request, response, forwardJSP);
			}
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
	 
	 private String extractFileName(Part part) {
			String contentDisp = part.getHeader("content-disposition");
			String[] items = contentDisp.split(";");
			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					return s.substring(s.indexOf("=") + 2, s.length() - 1);
				}
			}
			return "";
		}
}
