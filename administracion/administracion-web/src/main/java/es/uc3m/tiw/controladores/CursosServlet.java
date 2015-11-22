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
	List<ProfesorCurso> profesores = new ArrayList<ProfesorCurso>();
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
			profesores = profeDao.findAll();
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
			Curso course = cursoDao.findById(idCurso);
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
							AlumnoCurso alumn = alumnoCursoDao.comprobarAlumno(
									nombreAlumno, idCurso);
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
							ProfesorCurso profeAyudante = profeDao.comprobarProfesorInvitado(nombreProfesor, idCurso);
							if (profeAyudante != null) {
								boolean yaEnCurso = comprobarProfesorYaEnCurso(
										profe, course);
								if (yaEnCurso) {
									for (int i = 0; i < profesores.size(); i++) {
										if (course.getIdcurso() == profesores
												.get(i).getCurso_idcurso()
												.getIdcurso()) {
											if (profe
													.getUsuario_username()
													.getUsername()
													.equalsIgnoreCase(
															profesores
																	.get(i)
																	.getUsuario_username()
																	.getUsername())) {
												// un profesor no podria
												// eliminar al profesor titular
												// del curso salvo el
												// administrador
												if (!profesores.get(i)
														.isEsTitular()) {
													profesores.remove(i);
													mensaje = "El profesor ya se ha eliminado del curso";
													this.getServletContext()
															.setAttribute(
																	"profesores",
																	profesores);
												} else {
													if (tipoUser
															.getIdtipoUsuario() == 3) {
														profesores.remove(i);
														for (int i1 = 0; i1 < cursos
																.size(); i1++) {
															if (cursos
																	.get(i1)
																	.getIdcurso() == course
																	.getIdcurso()) {
																cursos.get(i1)
																		.setProfesor_titular(
																				null);
																this.getServletContext()
																		.setAttribute(
																				"cursos",
																				cursos);
																mensaje = "El alumno se ha eliminado del curso";
																break;
															}
														}
														mensaje = "El profesor titular ya se ha eliminado del curso";
														this.getServletContext()
																.setAttribute(
																		"profesores",
																		profesores);
													} else {
														mensaje = "No se puede eliminar el profesor titular del curso";
													}
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
					} else {
						if (tipoUser.getIdtipoUsuario() == 1) {
							AlumnoCurso alumn = alumnoCursoDao.comprobarAlumno(
									usuarioLogado.getUsername(), idCurso);
							if (alumn != null) {
								/*
								 * Curso cursado = comprobarCursado(alumn,
								 * course); Curso matriculado =
								 * comprobarMatricula(alumn, course); if
								 * (matriculado != null)
								 */if (alumn.isEnCurso()) {
									request.setAttribute("mensaje2",
											"El alumno esta matriculado en el curso");
									sesion.setAttribute("curso", course);
									forwardJSP = "/curso.jsp";
								} else {
									request.setAttribute("mensaje1",
											"El alumno ya ha realizado el curso");
									sesion.setAttribute("curso", course);
									forwardJSP = "/curso.jsp";
								}
							}
						} else if (tipoUser.getIdtipoUsuario() == 2) {
							boolean esProfe = comprobarProfeCurso(
									usuarioLogado, course);
							if (esProfe) {
								request.setAttribute("mensaje4",
										"El usuario es profesor del curso");
								sesion.setAttribute("curso", course);
								forwardJSP = "/curso.jsp";
							} else {
								mensaje = "No es profesor de este curso";
								sesion.setAttribute("curso", course);
								forwardJSP = "/curso.jsp";
							}

						} else {
							mensaje = "Los datos no son validos para realizar esta accion, por favor acceda de nuevo";
							request.getSession().invalidate();
							forwardJSP = "/login.jsp";
						}
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
		String idCurso = request.getParameter("idcurso");
		String mensaje = null;
		String accion = request.getParameter("accion");
		if (idCurso != null && !"".equals(idCurso)) {
			Curso course = obtenerCurso(idCurso);
			if (course != null) {
				if (accion != null && "addAlumno".equalsIgnoreCase(accion)) {
					String nombreAlumno = "";
					if (request.getParameter("target") != null
							&& !"".equalsIgnoreCase(request
									.getParameter("target"))) {
						nombreAlumno = request.getParameter("target");
						Alumno alumn = comprobarAlumno(nombreAlumno);
						if (alumn != null) {
							Curso cursado = comprobarCursado(alumn, course);
							if (cursado != null)
								mensaje = "El alumno ya ha cursado este curso";
							Curso matriculado = comprobarMatricula(alumn,
									course);
							if (matriculado != null)
								mensaje = "El alumno ya está matriculado en este curso";
							boolean yaEstaMatriculado = comprobarYaMatriculado(alumn);
							if (yaEstaMatriculado)
								mensaje = "El alumno ya está matriculado en otro curso";

							if (mensaje == null) {
								for (int i = 0; i < alumnos.size(); i++) {
									if (alumnos
											.get(i)
											.getUsername()
											.getUsername()
											.equalsIgnoreCase(
													alumn.getUsername()
															.getUsername())) {
										alumnos.get(i).setCurso_actual(course);
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
						Profesor profe = comprobarExisteProfesor(nombreProfesor);
						if (profe != null) {
							boolean yaEnCurso = comprobarProfesorYaEnCurso(
									profe, course);
							if (yaEnCurso)
								mensaje = "El profesor ya esta dado de alta en el curso";

							if (mensaje == null) {
								profe.setCurso_idcurso(course);
								profesores.add(profe);
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