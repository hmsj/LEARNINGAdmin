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
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Curso curso;
	private AlumnoCurso alumnoCurso;
	private Usuario usuario;
	private Banco banco;
	private Direccion direccion;
	private Logro logro;
	private Dificultad dificultad;

	List<Curso> cursos = new ArrayList<Curso>();
	List<AlumnoCurso> alumnosCurso = new ArrayList<AlumnoCurso>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	List<Banco> bancos = new ArrayList<Banco>();
	List<Direccion> direcciones = new ArrayList<Direccion>();
	List<Logro> logros = new ArrayList<Logro>();
	List<Dificultad> dificultades = new ArrayList<Dificultad>();

	List<AlumnoCurso> alumnoEnCurso = new ArrayList<AlumnoCurso>();
	List<AlumnoCurso> alumnoCursados = new ArrayList<AlumnoCurso>(); 
	
	List<ProfesorCurso> profesorTitular = new ArrayList<ProfesorCurso>();
	
	@PersistenceContext(unitName = "administracion-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	private CursoDao cursoDao;
	private AlumnoCursoDao alumnoCursoDao;
	private UsuarioDao usuarioDao;
	private BancoDao bancoDao;
	private DireccionDao direccionDao;
	private LogroDao logroDao;
	private DificultadDao dificultadDao;
	private ProfesorCursoDao profesorCursoDao;

	String forwardJSP = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuariosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig contexto) throws ServletException {
		// TODO Auto-generated method stub
		super.init(contexto);
		cursoDao = new CursoDaoImpl(em, ut);
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		usuarioDao = new UsuarioDaoImpl(em, ut);
		logroDao = new LogroDaoImpl(em, ut);
		dificultadDao = new DificultadDaoImpl(em, ut);
		profesorCursoDao = new ProfesorCursoDaoImpl(em, ut);
		try {
			cursos = cursoDao.findAll();
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
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			logros = logroDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dificultades = dificultadDao.findAll();
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
		String username = request.getParameter("username");
		String mensajeOK = "";
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String accion=request.getParameter("accion");
		String mensajeError = "";
		usuario = null;
		if (usuarioLogado != null && usuarioLogado.isAdmin()) {
			if (accion==null || "".equalsIgnoreCase(accion)){
				if(request.getParameter("idUsuario")!=null && !"".equalsIgnoreCase(request.getParameter("idUsuario"))){
				try {
					usuario = usuarioDao.findById(Long.parseLong(request.getParameter("idUsuario")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (usuario!=null) {
					try {
						alumnoEnCurso = alumnoCursoDao.listadoAlumnosEnCursoById(usuario.getIdUsuario());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						alumnoCursados = alumnoCursoDao.listadoAlumnosCursadoById(usuario.getIdUsuario());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						profesorTitular = profesorCursoDao.listadoTitularById(usuario.getIdUsuario());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("usuario", usuario);
					request.setAttribute("alumnoEnCurso", alumnoEnCurso);
					request.setAttribute("alumnoCursados", alumnoCursados);
					request.setAttribute("profesorTitular", profesorTitular);
					forwardJSP = "/editUser.jsp";
				}else {
					mensajeError="Se ha producido un error al acceder a los datos";
					request.setAttribute("mensajeError", mensajeError);
					forwardJSP = "/listadoAlumnos.jsp";
				}
				}	

			}else if(accion=="deleteUser"){
				if(request.getParameter("idUsuario")!=null && !"".equalsIgnoreCase(request.getParameter("idUsuario"))){
					Usuario usuarioDelete = null;
					try {
						usuarioDelete = usuarioDao.findById(Long.parseLong(request.getParameter("idUsuario")));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						usuarioDao.removeUsuario(usuarioDelete);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else {
			mensajeError = "No tiene permiso para acceder a estos datos";
			request.setAttribute("mensajeError", mensajeError);
			forwardJSP = "/login.jsp";
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
		String username = request.getParameter("username");
		String mensajeOK = "";
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String accion=request.getParameter("accion");
		String mensajeError = "";
		Usuario usuarioAntiguo = null;
		Direccion direccionAntigua = null;
		try {
			usuarioAntiguo = usuarioDao.findById(Long.parseLong(request.getParameter("idUsuario")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			direccionAntigua = direccionDao.findById(usuarioAntiguo.getIdDireccion().getIdDireccion());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario usuarioModificado = null;
		Direccion direccionModificada = null;
		Usuario usuarioNuevo = new Usuario();
		if(usuarioLogado != null && usuarioLogado.isAdmin()){
			if(accion!=null && !"".equalsIgnoreCase(accion) && accion=="modifyUser"){
				if(request.getParameter("idUsuario")!=null && !"".equals(request.getParameter("idUsuario"))){
					if(request.getParameter("nombreEdit")!=null && !"".equalsIgnoreCase(request.getParameter("nombreEdit")) && !request.getParameter("nombreEdit").equalsIgnoreCase(usuarioAntiguo.getNombre())){
						usuarioModificado.setNombre(request.getParameter("nombreEdit"));
					}else{
						usuarioModificado.setNombre(usuarioAntiguo.getNombre());
					}
					if(request.getParameter("apellidoEdit")!=null && !"".equalsIgnoreCase(request.getParameter("apellidoEdit")) && !request.getParameter("apellidoEdit").equalsIgnoreCase(usuarioAntiguo.getApellido())){
						usuarioModificado.setApellido(request.getParameter("apellidoEdit"));
					}else{
						usuarioModificado.setApellido(usuarioAntiguo.getApellido());
					}
					if(request.getParameter("usernameEdit")!=null && !"".equalsIgnoreCase(request.getParameter("usernameEdit")) && !request.getParameter("usernameEdit").equalsIgnoreCase(usuarioAntiguo.getUsername())){
						usuarioModificado.setUsername(request.getParameter("usernameEdit"));
					}else{
						usuarioModificado.setUsername(usuarioAntiguo.getUsername());
					}
					if(request.getParameter("passwordEdit")!=null && !"".equalsIgnoreCase(request.getParameter("passwordEdit")) && !request.getParameter("passwordEdit").equalsIgnoreCase(usuarioAntiguo.getPassword())){
						usuarioModificado.setPassword(request.getParameter("passwordEdit"));
					}else{
						usuarioModificado.setPassword(usuarioAntiguo.getPassword());
					}
					if(request.getParameter("emailEdit")!=null && !"".equalsIgnoreCase(request.getParameter("emailEdit")) && !request.getParameter("emailEdit").equalsIgnoreCase(usuarioAntiguo.getCorreo())){
						usuarioModificado.setCorreo(request.getParameter("emailEdit"));
					}else{
						usuarioModificado.setCorreo(usuarioAntiguo.getCorreo());
					}
					if(!request.getParameter("edadEdit").equals(usuarioAntiguo.getEdad())){
						usuarioModificado.setEdad(Integer.parseInt(request.getParameter("edadEdit")));
					}else{
						usuarioModificado.setEdad(usuarioAntiguo.getEdad());
					}
					if(!request.getParameter("phoneEdit").equalsIgnoreCase(direccionAntigua.getTelefono())){
						direccionModificada.setTelefono(request.getParameter("phoneEdit"));
					}else{
						direccionModificada.setTelefono(direccionAntigua.getTelefono());
					}
					if(!request.getParameter("paisEdit").equalsIgnoreCase(direccionAntigua.getPais())){
						direccionModificada.setPais(request.getParameter("paisEdit"));
					}else{
						direccionModificada.setPais(direccionAntigua.getPais());
					}
					if(!request.getParameter("ciudadEdit").equalsIgnoreCase(direccionAntigua.getCiudad())){
						direccionModificada.setCiudad(request.getParameter("ciudadEdit"));
					}else{
						direccionModificada.setCiudad(direccionAntigua.getCiudad());
					}
					if(!request.getParameter("calleEdit").equalsIgnoreCase(direccionAntigua.getCalle())){
						direccionModificada.setCalle(request.getParameter("calleEdit"));
					}else{
						direccionModificada.setCalle(direccionAntigua.getCalle());
					}
					if(!request.getParameter("numeroEdit").equals(direccionAntigua.getNumero())){
						direccionModificada.setNumero(Integer.parseInt(request.getParameter("numeroEdit")));
					}else{
						direccionModificada.setNumero(direccionAntigua.getNumero());
					}
					if(!request.getParameter("pisoEdit").equalsIgnoreCase(direccionAntigua.getPiso())){
						direccionModificada.setPiso(request.getParameter("pisoEdit"));
					}else{
						direccionModificada.setPiso(direccionAntigua.getPiso());
					}
					if(!request.getParameter("codigoPostalEdit").equalsIgnoreCase(direccionAntigua.getCodigoPostal())){
						direccionModificada.setCodigoPostal(request.getParameter("codigoPostalEdit"));
					}else{
						direccionModificada.setCodigoPostal(direccionAntigua.getCodigoPostal());
					}
					if(!direccionModificada.equals(direccionAntigua)){
						usuarioModificado.setIdDireccion(direccionModificada);
					}else{
						usuarioModificado.setIdDireccion(direccionAntigua);
					}
					if(!usuarioAntiguo.isAdmin()){
						usuarioModificado.setAdmin(false);
					}else{
						usuarioModificado.setAdmin(true);
					}
					
					try {
						usuarioNuevo = usuarioDao.modifyUsuario(usuarioModificado);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mensajeOK = "Datos modificados correctamente";
					request.setAttribute("usuario", usuarioNuevo);
					request.setAttribute("mensajeOK", mensajeOK);
					forwardJSP = "/editUser.jsp";
				}else{
					mensajeError = "No ha seleccionado ningun usuario";
					request.setAttribute("mensajeError", mensajeError);
					forwardJSP = "/editUser.jsp";
				}
			}else{
				mensajeError = "No ha seleccionado ninguna accion";
				request.setAttribute("mensajeError", mensajeError);
				forwardJSP = "/editUser.jsp";
			}
			
		}else {
			mensajeError = "No tiene permiso para realizar esta accion";
			request.setAttribute("mensajeError", mensajeError);
			forwardJSP = "/login.jsp";
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
