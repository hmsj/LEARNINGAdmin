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
import es.uc3m.tiw.dominios.Profesor;
import es.uc3m.tiw.dominios.TipoUsuario;
import es.uc3m.tiw.dominios.Usuario;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	ArrayList<TipoUsuario> tipoUsuarios = new ArrayList<TipoUsuario>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	@Override
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		alumnos = (ArrayList<Alumno>) this.getServletContext().getAttribute(
				"alumnos");
		usuarios = (ArrayList<Usuario>) this.getServletContext().getAttribute(
				"usuarios");
		tipoUsuarios = (ArrayList<TipoUsuario>) this.getServletContext()
				.getAttribute("tipoUsuarios");
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardJSP = "/signup.jsp";
		forward(request, response, forwardJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario nuevoUsuario = new Usuario();
		boolean estaVacio = false;
		String forwardJSP = "";
		HttpSession sesion = request.getSession(true);
		if (request.getParameter("tipouser") != null
				&& !"".equals(request.getParameter("tipouser"))) {
			if (request.getParameter("tipouser").equalsIgnoreCase("alumno")) {
				nuevoUsuario.setTipoUsuario(new TipoUsuario(1, "alumno"));
			} else if (request.getParameter("tipouser").equalsIgnoreCase("profesor")) {
				nuevoUsuario.setTipoUsuario(new TipoUsuario(2, "profesor"));
			} else {
				estaVacio = true;
			}
			if (request.getParameter("nombre") != null && !"".equalsIgnoreCase(request.getParameter("nombre"))) {
				nuevoUsuario.setNombre(request.getParameter("nombre"));
				if (request.getParameter("apellidos") != null && !"".equalsIgnoreCase(request.getParameter("apellidos"))) {
					nuevoUsuario.setApellidos(request.getParameter("apellidos"));
					if (request.getParameter("username") != null && !"".equalsIgnoreCase(request.getParameter("username"))) {
						nuevoUsuario.setUsername(request.getParameter("username"));
						if (request.getParameter("email") != null && !"".equalsIgnoreCase(request.getParameter("email"))) {
								nuevoUsuario.setEmail(request.getParameter("email"));
								if (request.getParameter("password") != null && !"".equalsIgnoreCase(request.getParameter("password"))) {
									nuevoUsuario.setPassword(request.getParameter("password"));
								}else {
									estaVacio = true;
								}
						}else {
							estaVacio = true;
						}
					}else {
						estaVacio = true;
					}
				}else {
					estaVacio = true;
				}
			}else {
				estaVacio = true;
			}

		}else {
			estaVacio = true;
		}
		if (estaVacio) {
			forwardJSP = "/signup.jsp";
			String mensaje = "Debe rellenar los datos marcados con *";
			request.setAttribute("mensaje", mensaje);
			forward(request, response, forwardJSP);
		}else {
			if(request.getParameter("edad")!=null && !"".equalsIgnoreCase(request.getParameter("edad"))){
				int nuevaEdad = Integer.parseInt(request.getParameter("edad"));
				nuevoUsuario.setEdad(nuevaEdad);
			}
			if (request.getParameter("intereses")!=null && !"".equalsIgnoreCase(request.getParameter("intereses"))) {
				nuevoUsuario.setIntereses(request.getParameter("intereses"));
			}
			if(request.getParameter("descripcion")!=null && !"".equalsIgnoreCase(request.getParameter("descripcion"))){
				nuevoUsuario.setDescripcion(request.getParameter("descripcion"));
			}
			if (request.getParameter("telefono")!=null && !"".equalsIgnoreCase(request.getParameter("telefono"))) {
				nuevoUsuario.setTelefono(request.getParameter("telefono"));
			}
			usuarios.add(nuevoUsuario);
			if(nuevoUsuario.getTipoUsuario().getIdtipoUsuario()==1){
				Alumno nuevoAlumno = new Alumno(nuevoUsuario, null, null);
				alumnos.add(nuevoAlumno);
				forwardJSP = "/principal.jsp";	
				sesion.setAttribute("usuario", nuevoUsuario);
				sesion.setAttribute("acceso", "ok");
				forward(request, response, forwardJSP);
			}
			else if (nuevoUsuario.getTipoUsuario().getIdtipoUsuario()==2)
			{
				Profesor nuevoProfesor = new Profesor(nuevoUsuario, null);
				profesores.add(nuevoProfesor);
				forwardJSP = "/principal.jsp";	
				sesion.setAttribute("usuario", nuevoUsuario);
				sesion.setAttribute("acceso", "ok");
				forward(request, response, forwardJSP);
			}
		}
		
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
