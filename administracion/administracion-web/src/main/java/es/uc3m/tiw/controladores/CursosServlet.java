package es.uc3m.tiw.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.tiw.dominios.Alumno;
import es.uc3m.tiw.dominios.Categoria;
import es.uc3m.tiw.dominios.Curso;
import es.uc3m.tiw.dominios.Leccion;
import es.uc3m.tiw.dominios.Material;
import es.uc3m.tiw.dominios.Profesor;
import es.uc3m.tiw.dominios.Seccion;
import es.uc3m.tiw.dominios.TipoDificultad;
import es.uc3m.tiw.dominios.TipoUsuario;
import es.uc3m.tiw.dominios.Usuario;

/**
 * Servlet implementation class CursosServlet
 */
@WebServlet(value = "/cursos")
public class CursosServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5079331756861773626L;
	ArrayList<Curso> cursos = new ArrayList<Curso>();
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	ArrayList<Seccion> secciones = new ArrayList<Seccion>();
	ArrayList<Leccion> lecciones = new ArrayList<Leccion>();
	ArrayList<Material> materiales = new ArrayList<Material>();
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	ArrayList<TipoDificultad> dificultades = new ArrayList<TipoDificultad>();
	ArrayList<TipoUsuario> tipoUsuarios = new ArrayList<TipoUsuario>();
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
		cursos = (ArrayList<Curso>) this.getServletContext().getAttribute("cursos");
		categorias = (ArrayList<Categoria>) this.getServletContext().getAttribute("categorias");
		secciones = (ArrayList<Seccion>) this.getServletContext().getAttribute("secciones");
		lecciones = (ArrayList<Leccion>) this.getServletContext().getAttribute("lecciones");
		materiales = (ArrayList<Material>) this.getServletContext().getAttribute("materiales");
		alumnos = (ArrayList<Alumno>) this.getServletContext().getAttribute("alumnos");
		tipoUsuarios = (ArrayList<TipoUsuario>) this.getServletContext().getAttribute("tipoUsuarios");
		profesores = (ArrayList<Profesor>) this.getServletContext().getAttribute("profesores");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCurso = request.getParameter("idcurso");
		String mensaje = null;
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		forwardJSP = "/listadoCursos.jsp";
		String accion = request.getParameter("accion");
		if (idCurso != null && !"".equals(idCurso)) {
			Curso course = obtenerCurso(idCurso);
			if (course != null) {
				if (usuarioLogado != null) {
					TipoUsuario tipoUser = comprobarUsuario(usuarioLogado);
					if (accion != null && "deleteAlumno".equalsIgnoreCase(accion)) {
						String nombreAlumno = "";
						if (request.getParameter("target") != null
								&& !"".equalsIgnoreCase(request.getParameter("target"))) {
							nombreAlumno = request.getParameter("target");
							Alumno alumn = comprobarAlumno(nombreAlumno);
							if (alumn != null) {
								Curso matriculado = comprobarMatricula(alumn, course);
								if (matriculado == null)
									mensaje = "El alumno no está matriculado en este curso";

								if (mensaje == null) {
									for (int i = 0; i < alumnos.size(); i++) {
										if (alumnos.get(i).getUsername().getUsername()
												.equalsIgnoreCase(alumn.getUsername().getUsername())) {
											alumnos.get(i).setCurso_actual(null);
											this.getServletContext().setAttribute("alumnos", alumnos);
											mensaje = "El alumno se ha eliminado del curso";
										}
									}
								}
							} else {
								mensaje = "El alumno que desea eliminar no existe en el sistema";
							}
						} else {
							mensaje = "No ha seleccionado una alumno al que eliminar del curso";
						}
						forwardJSP = "/curso.jsp";
					} else if (accion != null && "modifyTem".equalsIgnoreCase(accion)) {

					} else if (accion != null && "deleteTem".equalsIgnoreCase(accion)) {

					} else if (accion != null && "deleteProfesor".equalsIgnoreCase(accion)) {
						String nombreProfesor = "";
						if (request.getParameter("target") != null
								&& !"".equalsIgnoreCase(request.getParameter("target"))) {
							nombreProfesor = request.getParameter("target");
							Profesor profe = comprobarExisteProfesor(nombreProfesor);
							if (profe != null) {
								boolean yaEnCurso = comprobarProfesorYaEnCurso(profe, course);
								if (yaEnCurso) {
									for (int i = 0; i < profesores.size(); i++) {
										if (course.getIdcurso() == profesores.get(i).getCurso_idcurso().getIdcurso()) {
											if (profe.getUsuario_username().getUsername().equalsIgnoreCase(
													profesores.get(i).getUsuario_username().getUsername())) {
												//un profesor no podria eliminar al profesor titular del curso salvo el administrador
												if (!profesores.get(i).isEsTitular()) {
													profesores.remove(i);
													mensaje = "El profesor ya se ha eliminado del curso";
													this.getServletContext().setAttribute("profesores", profesores);
												} else {
													if (tipoUser.getIdtipoUsuario() == 3) {
														profesores.remove(i);													
														for (int i1 = 0; i1 < cursos.size(); i1++) {
															if (cursos.get(i1).getIdcurso() == course.getIdcurso()) {
																cursos.get(i1).setProfesor_titular(null);
																this.getServletContext().setAttribute("cursos", cursos);
																mensaje = "El alumno se ha eliminado del curso";
																break;
															}
														}
														mensaje = "El profesor titular ya se ha eliminado del curso";
														this.getServletContext().setAttribute("profesores", profesores);
													}
													else
													{
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
							Alumno alumn = comprobarAlumno(usuarioLogado);
							if (alumn != null) {
								Curso cursado = comprobarCursado(alumn, course);
								Curso matriculado = comprobarMatricula(alumn, course);
								if (matriculado != null) {
									request.setAttribute("mensaje2", "El alumno esta matriculado en el curso");
									sesion.setAttribute("curso", course);
									forwardJSP = "/curso.jsp";
								} else if (cursado != null) {
									request.setAttribute("mensaje1", "El alumno ya ha realizado el curso");
									sesion.setAttribute("curso", course);
									forwardJSP = "/curso.jsp";
								} else {
									request.setAttribute("mensaje3", "El alumno no esta matriculado");
									sesion.setAttribute("curso", course);
									forwardJSP = "/curso.jsp";
								}
							}
						} else if (tipoUser.getIdtipoUsuario() == 2) {
							boolean esProfe = comprobarProfeCurso(usuarioLogado, course);
							if (esProfe) {
								request.setAttribute("mensaje4", "El usuario es profesor del curso");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
							&& !"".equalsIgnoreCase(request.getParameter("target"))) {
						nombreAlumno = request.getParameter("target");
						Alumno alumn = comprobarAlumno(nombreAlumno);
						if (alumn != null) {
							Curso cursado = comprobarCursado(alumn, course);
							if (cursado != null)
								mensaje = "El alumno ya ha cursado este curso";
							Curso matriculado = comprobarMatricula(alumn, course);
							if (matriculado != null)
								mensaje = "El alumno ya está matriculado en este curso";
							boolean yaEstaMatriculado = comprobarYaMatriculado(alumn);
							if (yaEstaMatriculado)
								mensaje = "El alumno ya está matriculado en otro curso";

							if (mensaje == null) {
								for (int i = 0; i < alumnos.size(); i++) {
									if (alumnos.get(i).getUsername().getUsername()
											.equalsIgnoreCase(alumn.getUsername().getUsername())) {
										alumnos.get(i).setCurso_actual(course);
										this.getServletContext().setAttribute("alumnos", alumnos);
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
				} else if (accion != null && "addProfesor".equalsIgnoreCase(accion)) {
					String nombreProfesor = "";
					if (request.getParameter("target") != null
							&& !"".equalsIgnoreCase(request.getParameter("target"))) {
						nombreProfesor = request.getParameter("target");
						Profesor profe = comprobarExisteProfesor(nombreProfesor);
						if (profe != null) {
							boolean yaEnCurso = comprobarProfesorYaEnCurso(profe, course);
							if (yaEnCurso)
								mensaje = "El profesor ya esta dado de alta en el curso";

							if (mensaje == null) {
								profe.setCurso_idcurso(course);
								profesores.add(profe);
								mensaje = "El profesor ya se ha añadido en el curso";
								this.getServletContext().setAttribute("cursos", cursos);
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
	protected void forward(HttpServletRequest request, HttpServletResponse response, String uri) {
		try {
			javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL(uri));
			dispatcher.forward(request, response);
			return;
		} catch (ServletException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private Curso obtenerCurso(String parametro) {
		Curso course = null;
		int intCurso = Integer.parseInt(parametro);
		for (Curso curso : cursos) {
			if (intCurso == curso.getIdcurso()) {
				course = new Curso();
				course = curso;
			}
		}
		return course;
	}

	private Alumno comprobarAlumno(Usuario usuario) {
		Alumno alumn = null;
		for (Alumno alumno : alumnos) {
			if (usuario.getUsername() == alumno.getUsername().getUsername()) {
				alumn = new Alumno();
				alumn = alumno;
			}
		}
		return alumn;
	}

	private Alumno comprobarAlumno(String userName) {
		Alumno alumn = null;
		for (Alumno alumno : alumnos) {
			if (userName.equalsIgnoreCase(alumno.getUsername().getUsername())) {
				alumn = new Alumno();
				alumn = alumno;
				break;
			}
		}
		return alumn;
	}

	private Curso comprobarCursado(Alumno alumno, Curso curso) {
		Curso cursoRealizado = null;
		if (alumno.getListado_cursos() != null) {
			for (Curso cursado : alumno.getListado_cursos()) {
				if (cursado.getIdcurso() == curso.getIdcurso()) {
					cursoRealizado = new Curso();
					cursoRealizado = curso;
					break;
				}
			}
		}
		return cursoRealizado;
	}

	private Curso comprobarMatricula(Alumno alumno, Curso curso) {
		Curso cursoMatriculado = null;
		if (alumno.getCurso_actual() != null) {
			if (curso.getIdcurso() == alumno.getCurso_actual().getIdcurso()) {
				cursoMatriculado = new Curso();
				cursoMatriculado = curso;
			}
		}
		return cursoMatriculado;
	}

	private boolean comprobarYaMatriculado(Alumno alumno) {
		boolean yaEstaMatriculado = false;
		if (alumno.getCurso_actual() != null) {
			yaEstaMatriculado = true;
		}
		return yaEstaMatriculado;
	}

	private Profesor comprobarExisteProfesor(String profesorUserName) {
		Profesor profe = null;
		for (Profesor profesor : profesores) {
			if (profesorUserName.equalsIgnoreCase(profesor.getUsuario_username().getUsername())) {
				profe = new Profesor();
				profe = profesor;
				profe.setCurso_idcurso(null);
			}
		}
		return profe;
	}

	private boolean comprobarProfesorYaEnCurso(Profesor profe, Curso curso) {
		boolean yaEstaComoProfe = false;
		for (Profesor profesor : profesores) {
			if (curso.getIdcurso() == profesor.getCurso_idcurso().getIdcurso()) {
				if (profe.getUsuario_username().getUsername()
						.equalsIgnoreCase(profesor.getUsuario_username().getUsername())) {
					yaEstaComoProfe = true;
					break;
				}
			}
		}

		return yaEstaComoProfe;
	}

	protected TipoUsuario comprobarUsuario(Usuario usuario) {
		TipoUsuario userType = null;
		for (TipoUsuario tipoUsuario : tipoUsuarios) {
			if (usuario.getTipoUsuario().getIdtipoUsuario() == tipoUsuario.getIdtipoUsuario()) {
				userType = new TipoUsuario();
				userType = tipoUsuario;
				break;
			}
		}
		return userType;
	}

	protected boolean comprobarProfeCurso(Usuario usuario, Curso curso) {
		boolean esProfe = false;
		for (Profesor profesor : profesores) {
			if (curso.getIdcurso() == profesor.getCurso_idcurso().getIdcurso()) {
				if (usuario.getUsername().equalsIgnoreCase(profesor.getUsuario_username().getUsername())) {
					esProfe = true;
					break;
				}
			}
		}
		return esProfe;
	}
}
