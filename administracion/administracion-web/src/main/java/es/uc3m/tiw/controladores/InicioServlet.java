package es.uc3m.tiw.controladores;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.AlumnoCursoDaoImpl;
import es.uc3m.tiw.daos.AlumnoLeccionDaoImpl;
import es.uc3m.tiw.daos.BancoDaoImpl;
import es.uc3m.tiw.daos.CategoriaDaoImpl;
import es.uc3m.tiw.daos.CursoDaoImpl;
import es.uc3m.tiw.daos.DificultadDaoImpl;
import es.uc3m.tiw.daos.DireccionDaoImpl;
import es.uc3m.tiw.daos.LeccionCursoDaoImpl;
import es.uc3m.tiw.daos.ListaDeseosDaoImpl;
import es.uc3m.tiw.daos.LogroDaoImpl;
import es.uc3m.tiw.daos.MaterialLeccionDaoImpl;
import es.uc3m.tiw.daos.OfertaDaoImpl;
import es.uc3m.tiw.daos.ProfesorCursoDaoImpl;
import es.uc3m.tiw.daos.SeccionCursoDaoImpl;
import es.uc3m.tiw.daos.TipoOfertaDaoImpl;
import es.uc3m.tiw.daos.UsuarioDaoImpl;
import es.uc3m.tiw.model.AlumnoCurso;
import es.uc3m.tiw.model.Banco;
import es.uc3m.tiw.model.Categoria;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Dificultad;
import es.uc3m.tiw.model.Direccion;
import es.uc3m.tiw.model.LeccionCurso;
import es.uc3m.tiw.model.Logro;
import es.uc3m.tiw.model.MaterialLeccion;
import es.uc3m.tiw.model.Oferta;
import es.uc3m.tiw.model.ProfesorCurso;
import es.uc3m.tiw.model.SeccionCurso;
import es.uc3m.tiw.model.TipoOferta;
import es.uc3m.tiw.model.Usuario;


/**
 * Servlet implementation class InicioServlet
 */
@WebServlet(value="/inicio")
public class InicioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios;
	private List<Curso> cursos;
	
	@PersistenceContext(unitName="administracion-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	
	AlumnoCursoDaoImpl alumnoCursoDao;
	AlumnoLeccionDaoImpl alumnoLeccionDao;
	BancoDaoImpl bancoDao;
	CategoriaDaoImpl categoriaDao;
	CursoDaoImpl cursoDao;
	DificultadDaoImpl dificultadDao;
	DireccionDaoImpl direccionDao;
	LeccionCursoDaoImpl leccionCursoDao;
	ListaDeseosDaoImpl listaDeseosDao;
	LogroDaoImpl logroDao;
	MaterialLeccionDaoImpl materialLeccionDao;
	OfertaDaoImpl ofertaDao;
	ProfesorCursoDaoImpl profesorCursoDao;
	SeccionCursoDaoImpl seccionCursoDao;
	TipoOfertaDaoImpl tipoOfertaDao;
	UsuarioDaoImpl usuarioDao;
	
    private static final boolean DESTACADO = true;
    private static final boolean NODESTACADO = false;
    private static final boolean VALIDADO = true;;
    private static final boolean NOVALIDADO = false;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		alumnoCursoDao = new AlumnoCursoDaoImpl(em, ut);
		alumnoLeccionDao = new AlumnoLeccionDaoImpl(em, ut);
		bancoDao = new BancoDaoImpl(em, ut);
		categoriaDao = new CategoriaDaoImpl(em, ut);
		cursoDao = new CursoDaoImpl(em, ut);
		dificultadDao = new DificultadDaoImpl(em, ut);
		direccionDao = new DireccionDaoImpl(em, ut);
		leccionCursoDao = new LeccionCursoDaoImpl(em, ut);
		listaDeseosDao = new ListaDeseosDaoImpl(em, ut);
		logroDao = new LogroDaoImpl(em, ut);
		materialLeccionDao = new MaterialLeccionDaoImpl(em, ut);
		ofertaDao = new OfertaDaoImpl(em, ut);
		profesorCursoDao = new ProfesorCursoDaoImpl(em, ut);
		seccionCursoDao = new SeccionCursoDaoImpl(em, ut);
		tipoOfertaDao = new TipoOfertaDaoImpl(em, ut);
		usuarioDao = new UsuarioDaoImpl(em, ut);
    	
    	TipoOferta tipoOferta1 = new TipoOferta(1, "Fijo");
		TipoOferta tipoOferta2 = new TipoOferta(2, "Porcentaje");
		try {
			tipoOfertaDao.createTipoOferta(tipoOferta1);
			tipoOfertaDao.createTipoOferta(tipoOferta2);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Logro logro1 = new Logro(1, "novato");
		Logro logro2 = new Logro(2, "iniciado");
		Logro logro3 = new Logro(3, "padaguan");
		Logro logro4 = new Logro(4, "jedi");
		Logro logro5 = new Logro(5, "experto");
		try {
			logroDao.createLogro(logro1);
			logroDao.createLogro(logro2);
			logroDao.createLogro(logro3);
			logroDao.createLogro(logro4);
			logroDao.createLogro(logro5);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Dificultad dificultad1 = new Dificultad(1, "basico");
		Dificultad dificultad2 = new Dificultad(2, "intermedio");
		Dificultad dificultad3 = new Dificultad(3, "avanzado");
		try {
			dificultadDao.createDificultad(dificultad1);
			dificultadDao.createDificultad(dificultad2);
			dificultadDao.createDificultad(dificultad3);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Categoria categoria1 = new Categoria(1, "Programacion");
		Categoria categoria2 = new Categoria(2, "Fotografia");
		Categoria categoria3 = new Categoria(3, "Marketing");
		Categoria categoria4 = new Categoria(4, "Diseño");
		Categoria categoria5 = new Categoria(5, "Idiomas");
		Categoria categoria6 = new Categoria(6, "Negocios");
		Categoria categoria7 = new Categoria(7, "Otros");	
		try {
			categoriaDao.createCategoria(categoria1);
			categoriaDao.createCategoria(categoria2);
			categoriaDao.createCategoria(categoria3);
			categoriaDao.createCategoria(categoria4);
			categoriaDao.createCategoria(categoria5);
			categoriaDao.createCategoria(categoria6);
			categoriaDao.createCategoria(categoria7);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Direccion direccion1 = new Direccion("España", "Madrid", "calle 1", 1, "1ºA", null, "28200");
		Direccion direccion2 = new Direccion("España", "Barcelona", "calle 2", 1, "2ºB", null, "27200");
		Direccion direccion3 = new Direccion("España", "Bilbao", "calle 3", 1, "3ºC", null, "28900");
		try {
			direccionDao.createDireccion(direccion1);
			direccionDao.createDireccion(direccion2);
			direccionDao.createDireccion(direccion3);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Banco banco1 = new Banco("545413441054", "Paquito");
		Banco banco2 = new Banco("587546786548", "Luisito");
		Banco banco3 = new Banco("583214647868", "Maria");
		try {
			bancoDao.createBanco(banco1);
			bancoDao.createBanco(banco2);
			bancoDao.createBanco(banco3);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		Usuario usuario1 = new Usuario();
		usuario1.setUsername("alumno1");
		usuario1.setPassword("123456");
		usuario1.setNombre("Pepito");
		usuario1.setApellido("Registrado");
		usuario1.setCorreo("alumno2@dokulearning.es");
		usuario1.setIdDireccion(direccion1);
		
		Usuario usuario2 = new Usuario("alumno2", "123456", "Juanito", "Registrado",  null, null, null, 25, "alumno2@dokulearning.es", direccion1);
		Usuario usuario3 = new Usuario("alumno3", "123456", "Jorgito", "Registrado", null, null, null, 30, "alumno3@dokulearning.es", direccion1);
		Usuario usuario4 = new Usuario(	"profeUser", "123456", "Sita Carapapel", "Registrado", null, null, null, 20, "profesor1@dokulearning.es", direccion2);
		Usuario usuario5 = new Usuario(	"profeUser2", "123456", "Señorita Pepis", "Invitado", null, null, null, 20, "profesor2@dokulearning.es",  direccion3);
		Usuario usuario6 = new Usuario(	"adminUser", "123456", "Administrador", "Registrado", null, null, null, 25, "admin@dokulearning.es", direccion3);
		try {
			usuarioDao.createUsuario(usuario1);
			usuarioDao.createUsuario(usuario2);
			usuarioDao.createUsuario(usuario3);
			usuarioDao.createUsuario(usuario4);
			usuarioDao.createUsuario(usuario5);
			usuarioDao.createUsuario(usuario6);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		Oferta oferta1 = new Oferta(30.0,"31/12/2015", tipoOferta1);
		try {
			ofertaDao.createOferta(oferta1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		Curso curso1 = new Curso("Curso de diseño photoshop", "Aprende el manejo basico de Photoshop", 100, VALIDADO, DESTACADO, null, oferta1, categoria4, dificultad1);
		Curso curso2 = new Curso("Curso de diseño de videojuegos", "Diseño de juegos y simulacion con 3d Unity", 250.0, VALIDADO, NODESTACADO, "img/courses/DiseñoVideojuegos.jpg", null, categoria4, dificultad1);
		Curso curso3 = new Curso("Curso de fotografia: el enfoque", "Sacale el maximo partido a tu camara", 50.0, NOVALIDADO, NODESTACADO, "img/courses/FotografiaEnfocar.jpg", null, categoria2, dificultad1);
		Curso curso4 = new Curso("Curso de fotografia nocturna", "Fotografia nocturna con tu camara digital", 100.0, VALIDADO, DESTACADO, "img/courses/FotografiaNocturna.jpg", null, categoria2, dificultad1);
		Curso curso5 = new Curso("Curso de idiomas: Aleman", "Nivel intermedio de aleman con profesores nativos", 75.5, VALIDADO, DESTACADO, "img/courses/IdiomaAleman.jpg", oferta1, categoria5, dificultad1);
		Curso curso6 = new Curso("Curso de idiomas: Ingles", "Aprende ingles con 1000 palabras, metodo mejorado", 25, VALIDADO, NODESTACADO,"img/courses/IdiomaIngles.jpg", oferta1, categoria5, dificultad1);
		Curso curso7 = new Curso("Curso de marketing digital", "Marketing basado en conocimiento de community manager", 25, VALIDADO, DESTACADO, "img/courses/MarketingDigital.jpg", null,  categoria3, dificultad1);
		Curso curso8 = new Curso("Curso de marketing directo", "Como conseguir la mejor impresion en las personas", 25, VALIDADO, DESTACADO, "img/courses/MarketingDirecto.jpg", oferta1, categoria3, dificultad1);
		Curso curso9 = new Curso("Curso de negocios: inversion de bolsa", "Aprende  invertir en funcion de tu perfil de riesgo", 25, VALIDADO, DESTACADO, "img/courses/NegocioBolsa.jpg", oferta1, categoria6, dificultad1);
		Curso curso10 = new Curso("Curso de negocios: estrategia", "Toma de decisiones en diferentes aspectos de mercado", 25, VALIDADO, NODESTACADO, "img/courses/NegociosEstrategia.jpg", null, categoria6, dificultad1);
		Curso curso11 = new Curso("Curso para emprendedores", "Como hacer un plan de empresa desde cero", 25, VALIDADO, DESTACADO, "img/courses/OtrosEmprendimiento.jpg", oferta1, categoria7, dificultad1);
		Curso curso12 = new Curso("Curso de ofimatica Microsoft", "Curso rapido de Word, Excell, Power Point", 25, NOVALIDADO, NODESTACADO, "img/courses/OtrosMicrosoft.jpg", null, categoria7, dificultad1);
		Curso curso13 = new Curso("Curso de programacion en Android", "Crea tu propia aplicacion en menos de una semana", 25, VALIDADO, DESTACADO, "img/courses/ProgramacionAndroid.jpg", oferta1, categoria1, dificultad1);
		Curso curso14 = new Curso("Curso de programacion web: HTML5", "Conceptos basicos e intermedios de programacion web", 25, NOVALIDADO, NODESTACADO, "img/courses/ProgramacionHtml5.jpg", null, categoria1, dificultad1);
		try {
			cursoDao.createCurso(curso1);
			cursoDao.createCurso(curso2);
			cursoDao.createCurso(curso3);
			cursoDao.createCurso(curso4);
			cursoDao.createCurso(curso5);
			cursoDao.createCurso(curso6);
			cursoDao.createCurso(curso7);
			cursoDao.createCurso(curso8);
			cursoDao.createCurso(curso9);
			cursoDao.createCurso(curso10);
			cursoDao.createCurso(curso11);
			cursoDao.createCurso(curso12);
			cursoDao.createCurso(curso13);
			cursoDao.createCurso(curso14);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		AlumnoCurso alumno1 = new AlumnoCurso(0, true, usuario1, curso1, null);
		AlumnoCurso alumno2 = new AlumnoCurso(6.5, false, usuario2, curso1, logro3);
		AlumnoCurso alumno3 = new AlumnoCurso(8, false, usuario3, curso2, logro4);
		try {
			alumnoCursoDao.createAlumnoCurso(alumno1);
			alumnoCursoDao.createAlumnoCurso(alumno2);
			alumnoCursoDao.createAlumnoCurso(alumno3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ProfesorCurso profesor = new ProfesorCurso(true, usuario4, curso1, banco1);
		ProfesorCurso profesor2 = new ProfesorCurso(false, usuario5, curso1, banco2);
		try {
			profesorCursoDao.createProfesorCurso(profesor);
			profesorCursoDao.createProfesorCurso(profesor2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		SeccionCurso seccion1 = new SeccionCurso("Seccion1", "Descripcion seccion1", curso1);
		try {
			seccionCursoDao.createSeccionCurso(seccion1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LeccionCurso leccion1 = new LeccionCurso("Leccion1", "Descripcion leccion 1", seccion1); 
		try {
			leccionCursoDao.createLeccionCurso(leccion1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MaterialLeccion material1 = new MaterialLeccion("Material1", "Descripcion material 1", "/", leccion1); 
		try {
			materialLeccionDao.createMaterialLeccion(material1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cursos = cursoDao.findAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			usuarios = usuarioDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//double preciofinal = calcularPrecio(precioInicial, oferta1);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String forwardJSP = "/login.jsp";
		forward(request, response, forwardJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		
	}
	
	/*protected double calcularPrecio(double precioInicial, Oferta oferta) {
		double precioFinal = 0;
		int tipoOfer = oferta.getTipoOferta().getIdtipoOferta();
		double valorOfer = oferta.getValor();
		if(tipoOfer==1){
			precioFinal = precioInicial - valorOfer;
		}else if(tipoOfer==2){
			precioFinal = (1-(valorOfer/100))*precioInicial;
		}
		return precioFinal;
	}*/
	
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
