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
 * Servlet implementation class AlumnosServlet
 */
@WebServlet("/alumnos")
public class AlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnoCurso alumnoCurso;
    private Usuario usuario;
	
	List<AlumnoCurso> alumnosCurso = new ArrayList<AlumnoCurso>();
	
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private AlumnoCursoDao alumnoCursoDao;
	private UsuarioDao usuarioDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		usuarioDao = new UsuarioDaoImpl(em, ut);
		//alumnos = (ArrayList<Alumno>) this.getServletContext().getAttribute("alumnos");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(true);
		List<Usuario> usuarios = null;
		try {
			alumnosCurso = alumnoCursoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			alumnosCurso = null;
		}
		try {
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			usuarios = null;
		}
		request.setAttribute("usuarios", usuarios);
		String forwardJSP = "/listadoAlumnos.jsp";
		forward(request, response, forwardJSP);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

}
