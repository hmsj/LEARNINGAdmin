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

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/nuevoCurso")
public class RegistroCursoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3114864424385386858L;
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<Curso> cursos = new ArrayList<Curso>();
	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	ArrayList<Seccion> secciones = new ArrayList<Seccion>();
	ArrayList<Leccion> lecciones = new ArrayList<Leccion>();
	ArrayList<Material> materiales = new ArrayList<Material>();
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();

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
		alumnos = (ArrayList<Alumno>) this.getServletContext().getAttribute(
				"alumnos");
		cursos = (ArrayList<Curso>) this.getServletContext().getAttribute(
				"curos");
		profesores = (ArrayList<Profesor>) this.getServletContext()
				.getAttribute("profesores");
		secciones = (ArrayList<Seccion>) this.getServletContext().getAttribute(
				"secciones");
		lecciones = (ArrayList<Leccion>) this.getServletContext().getAttribute(
				"lecciones");
		materiales = (ArrayList<Material>) this.getServletContext()
				.getAttribute("materiales");
		categorias = (ArrayList<Categoria>) this.getServletContext()
				.getAttribute("categorias");

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
		Seccion nuevaSeccion = new Seccion();
		Leccion nuevaLeccion = new Leccion();
		Material nuevoMaterial = new Material();
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
						nuevaCategoria.setDescripcion_categoria("programacion");
						nuevaCategoria.setIdcategoria(1);
						categorias.add(nuevaCategoria);

					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("fotografia")) {
						nuevaCategoria.setDescripcion_categoria("fotografia");
						nuevaCategoria.setIdcategoria(2);
						categorias.add(nuevaCategoria);
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("marketing")) {
						nuevaCategoria.setDescripcion_categoria("marketing");
						nuevaCategoria.setIdcategoria(3);
						categorias.add(nuevaCategoria);
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("diseño")) {
						nuevaCategoria.setDescripcion_categoria("diseño");
						nuevaCategoria.setIdcategoria(4);
						categorias.add(nuevaCategoria);
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("idiomas")) {
						nuevaCategoria.setDescripcion_categoria("idiomas");
						nuevaCategoria.setIdcategoria(5);
						categorias.add(nuevaCategoria);
					} else if (request.getParameter("categoriaCurso")
							.equalsIgnoreCase("negocios")) {
						nuevaCategoria.setDescripcion_categoria("negocios");
						nuevaCategoria.setIdcategoria(6);
						categorias.add(nuevaCategoria);
					} else {
						nuevaCategoria.setDescripcion_categoria("otros");
						nuevaCategoria.setIdcategoria(7);
						categorias.add(nuevaCategoria);
					}
					nuevoCurso.setCategoria(nuevaCategoria);
					cursos.add(nuevoCurso);

					if (request.getParameter("tituloSeccion") != null
							&& !"".equalsIgnoreCase(request
									.getParameter("tituloSeccion"))) {
						nuevaSeccion.setTitulo(request
								.getParameter("tituloSeccion"));
						nuevaSeccion.setCurso(nuevoCurso);
						secciones.add(nuevaSeccion);

						if (request.getParameter("tituloLeccion") != null
								&& !"".equalsIgnoreCase(request
										.getParameter("tituloLeccion"))) {
							if (request.getParameter("descripcionLeccion") != null
									&& !"".equalsIgnoreCase(request
											.getParameter("descripcionLeccion"))) {
								nuevaLeccion.setTitulo(request
										.getParameter("tituloLeccion"));
								nuevaLeccion.setDescripcion(request
										.getParameter("descripcionLeccion"));
								nuevaLeccion.setSeccion(nuevaSeccion);
								lecciones.add(nuevaLeccion);

								if (request.getParameter("file") != null
										&& !"".equalsIgnoreCase(request
												.getParameter("file"))) {
									if (request.getParameter("tituloMaterial") != null
											&& !"".equalsIgnoreCase(request
													.getParameter("tituloMaterial"))) {
										nuevoMaterial.setArchivo(request
												.getParameter("file"));
										nuevoMaterial
												.setTitulo(request
														.getParameter("tituloMaterial"));
										nuevoMaterial.setLeccion(nuevaLeccion);
										secciones.add(nuevaSeccion);
										forwardJSP = "/principal.jsp";
										String mensaje = "Ha creado un nuevo curso";
										sesion.setAttribute("mensaje", mensaje);
										forward(request, response, forwardJSP);
									}
								}
							}
						}
					}
				}
			}
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
