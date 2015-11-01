package es.uc3m.tiw.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.dominios.Alumno;
import es.uc3m.tiw.dominios.Calificacion;
import es.uc3m.tiw.dominios.Categoria;
import es.uc3m.tiw.dominios.Curso;
import es.uc3m.tiw.dominios.DatosBancarios;
import es.uc3m.tiw.dominios.Direccion;
import es.uc3m.tiw.dominios.Leccion;
import es.uc3m.tiw.dominios.Material;
import es.uc3m.tiw.dominios.Oferta;
import es.uc3m.tiw.dominios.Profesor;
import es.uc3m.tiw.dominios.Seccion;
import es.uc3m.tiw.dominios.TipoDificultad;
import es.uc3m.tiw.dominios.TipoLogro;
import es.uc3m.tiw.dominios.TipoMaterial;
import es.uc3m.tiw.dominios.TipoOferta;
import es.uc3m.tiw.dominios.TipoUsuario;
import es.uc3m.tiw.dominios.Usuario;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet(value="/inicio")
public class InicioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static final int destacado = 1;
    private static final int nodestacado = 0;
    private static final int validado = 1;
    private static final int novalidado = 0;

    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	private ArrayList<DatosBancarios> datosBancarios = new ArrayList<DatosBancarios>();
	private ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
	private ArrayList<Leccion> lecciones = new ArrayList<Leccion>();
	private ArrayList<Material> materiales = new ArrayList<Material>();
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	private ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	private ArrayList<Seccion> secciones = new ArrayList<Seccion>();
    private ArrayList<TipoDificultad> tipoDificultades = new ArrayList<TipoDificultad>();
    private ArrayList<TipoLogro> tipoLogros = new ArrayList<TipoLogro>();
    private ArrayList<TipoMaterial> tipoMateriales = new ArrayList<TipoMaterial>();
    private ArrayList<TipoOferta> tipoOfertas = new ArrayList<TipoOferta>();
    private ArrayList<TipoUsuario> tipoUsuarios = new ArrayList<TipoUsuario>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    

	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(javax.servlet.ServletConfig contexto) throws ServletException {
    	TipoUsuario tipoUsuario1 = new TipoUsuario(1, "alumno");
		TipoUsuario tipoUsuario2 = new TipoUsuario(2, "profesor");
		TipoUsuario tipoUsuario3 = new TipoUsuario(3, "administrador");
		tipoUsuarios.add(tipoUsuario1);
		tipoUsuarios.add(tipoUsuario2);
		tipoUsuarios.add(tipoUsuario3);
		
		TipoOferta tipoOferta1 = new TipoOferta(1, "Fijo");
		TipoOferta tipoOferta2 = new TipoOferta(2, "Porcentaje");		
		tipoOfertas.add(tipoOferta1);
		tipoOfertas.add(tipoOferta2);
		
		TipoMaterial tipoMaterial1 = new TipoMaterial(1, "txt");
		TipoMaterial tipoMaterial2 = new TipoMaterial(2, "pdf");
		TipoMaterial tipoMaterial3 = new TipoMaterial(3, "doc");
		TipoMaterial tipoMaterial4 = new TipoMaterial(4, "excel");
		TipoMaterial tipoMaterial5 = new TipoMaterial(5, "video");
		TipoMaterial tipoMaterial6 = new TipoMaterial(6, "audio");
		tipoMateriales.add(tipoMaterial1);
		tipoMateriales.add(tipoMaterial2);
		tipoMateriales.add(tipoMaterial3);
		tipoMateriales.add(tipoMaterial4);
		tipoMateriales.add(tipoMaterial5);
		tipoMateriales.add(tipoMaterial6);
		
		TipoLogro tipoLogro1 = new TipoLogro(1, "novato");
		TipoLogro tipoLogro2 = new TipoLogro(2, "iniciado");
		TipoLogro tipoLogro3 = new TipoLogro(3, "padaguan");
		TipoLogro tipoLogro4 = new TipoLogro(4, "jedi");
		TipoLogro tipoLogro5 = new TipoLogro(5, "experto");
		tipoLogros.add(tipoLogro1);
		tipoLogros.add(tipoLogro2);
		tipoLogros.add(tipoLogro3);
		tipoLogros.add(tipoLogro4);
		tipoLogros.add(tipoLogro5);
		
		TipoDificultad tipoDificultad1 = new TipoDificultad(1, "basico");
		TipoDificultad tipoDificultad2 = new TipoDificultad(2, "intermedio");
		TipoDificultad tipoDificultad3 = new TipoDificultad(3, "avanzado");
		tipoDificultades.add(tipoDificultad1);
		tipoDificultades.add(tipoDificultad2);
		tipoDificultades.add(tipoDificultad3);
		
		Categoria categoria1 = new Categoria(1, "Programacion");
		Categoria categoria2 = new Categoria(2, "Fotografia");
		Categoria categoria3 = new Categoria(3, "Marketing");
		Categoria categoria4 = new Categoria(4, "Diseño");
		Categoria categoria5 = new Categoria(5, "Idiomas");
		Categoria categoria6 = new Categoria(6, "Negocios");
		Categoria categoria7 = new Categoria(7, "Otros");	
		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
		categorias.add(categoria4);
		categorias.add(categoria5);
		categorias.add(categoria6);
		categorias.add(categoria7);
		
		Direccion direccion1 = new Direccion(1, "calle 1", 1, "Madrid", "Colmenarejo", "28000", "España");
		Direccion direccion2 = new Direccion(2, "calle 2", 2, "Madrid", "Colmenarejo", "28000", "España");
		Direccion direccion3 = new Direccion(3, "calle 3", 3, "Madrid", "Colmenarejo", "28000", "España");
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		direcciones.add(direccion3);
		
		DatosBancarios banco1 = new DatosBancarios(1, "1245413235", "12/12/2020", 123);
		DatosBancarios banco2 = new DatosBancarios(2, "5875467868", "1/2/2020", 321);
		DatosBancarios banco3 = new DatosBancarios(3, "5832147868", "5/3/2018", 321);
		datosBancarios.add(banco1);
		datosBancarios.add(banco2);
		datosBancarios.add(banco3);
		
		Usuario usuario1 = new Usuario("alumno1", "Pepito", "Registrado", "alumno1@dokulearning.es","123456", "", "123456987", "", "", 20, tipoUsuario1, direccion1, banco1);
		Usuario usuario2 = new Usuario("alumno2", "Juanito", "Registrado", "alumno2@dokulearning.es","123456", "", "123456987", "", "", 20, tipoUsuario1, direccion1, banco1);
		Usuario usuario3 = new Usuario("alumno3", "Jorgito", "Registrado", "alumno3@dokulearning.es","123456", "", "123456987", "", "", 20, tipoUsuario1, direccion1, banco1);
		Usuario usuario4 = new Usuario(	"profeUser", "Sita Carapapel", "Registrado", "profesor1@dokulearning.es", "123456", "", "987456213", "", "", 58, tipoUsuario2, direccion2, banco2);
		Usuario usuario5 = new Usuario(	"profeUser2", "Señorita Pepis", "Invitado", "profesor2@dokulearning.es", "123456", "", "987456951", "", "", 38, tipoUsuario2, direccion3, banco2);
		Usuario usuario6 = new Usuario(	"adminUser", "Administrador", "Registrado", "admin@dokulearning.es", "123456", "", "541664884", "", "", 35, tipoUsuario3, direccion3, banco3);
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);
		usuarios.add(usuario6);
		
		Oferta oferta1 = new Oferta(1, tipoOferta2, 30, "31/10/2015");
		ofertas.add(oferta1);
		
		double precioInicial = 50;
		double preciofinal = calcularPrecio(precioInicial, oferta1);	
		
		Curso curso1 = new Curso(1, "Curso de diseño photoshop", "Aprende el manejo basico de Photoshop", 25, null, "", destacado, validado, precioInicial, preciofinal, oferta1, categoria4, tipoDificultad1, "profeUser");
		Curso curso2 = new Curso(2, "Curso de diseño de videojuegos", "Diseño de juegos y simulacion con 3d Unity", 25, "img/courses/DiseñoVideojuegos.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria4, tipoDificultad1, "profeUser2");
		Curso curso3 = new Curso(3, "Curso de fotografia: el enfoque", "Sacale el maximo partido a tu camara", 25, "img/courses/FotografiaEnfocar.jpg", "", nodestacado, validado, precioInicial, preciofinal, oferta1, categoria2, tipoDificultad1);
		Curso curso4 = new Curso(4, "Curso de fotografia nocturna", "Fotografia nocturna con tu camara digital", 25, "img/courses/FotografiaNocturna.jpg", "", destacado, novalidado, precioInicial, preciofinal, oferta1, categoria2, tipoDificultad1);
		Curso curso5 = new Curso(5, "Curso de idiomas: Aleman", "Nivel intermedio de aleman con profesores nativos", 25, "img/courses/IdiomaAleman.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria5, tipoDificultad1);
		Curso curso6 = new Curso(6, "Curso de idiomas: Ingles", "Aprende ingles con 1000 palabras, metodo mejorado", 25, "img/courses/IdiomaIngles.jpg", "", nodestacado, validado, precioInicial, preciofinal, oferta1, categoria5, tipoDificultad1);
		Curso curso7 = new Curso(7, "Curso de marketing digital", "Marketing basado en conocimiento de community manager", 25, "img/courses/MarketingDigital.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria3, tipoDificultad1);
		Curso curso8 = new Curso(8, "Curso de marketing directo", "Como conseguir la mejor impresion en las personas", 25, "img/courses/MarketingDirecto.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria3, tipoDificultad1);
		Curso curso9 = new Curso(9, "Curso de negocios: inversion de bolsa", "Aprende  invertir en funcion de tu perfil de riesgo", 25, "img/courses/NegocioBolsa.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria6, tipoDificultad1);
		Curso curso10 = new Curso(10, "Curso de negocios: estrategia", "Toma de decisiones en diferentes aspectos de mercado", 25, "img/courses/NegociosEstrategia.jpg", "", nodestacado, validado, precioInicial, preciofinal, oferta1, categoria6, tipoDificultad1);
		Curso curso11 = new Curso(11, "Curso para emprendedores", "Como hacer un plan de empresa desde cero", 25, "img/courses/OtrosEmprendimiento.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria7, tipoDificultad1);
		Curso curso12 = new Curso(12, "Curso de ofimatica Microsoft", "Curso rapido de Word, Excell, Power Point", 25, "img/courses/OtrosMicrosoft.jpg", "", destacado, novalidado, precioInicial, preciofinal, oferta1, categoria7, tipoDificultad1);
		Curso curso13 = new Curso(13, "Curso de programacion en Android", "Crea tu propia aplicacion en menos de una semana", 25, "img/courses/ProgramacionAndroid.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria1, tipoDificultad1);
		Curso curso14 = new Curso(14, "Curso de programacion web: HTML5", "Conceptos basicos e intermedios de programacion web", 25, "img/courses/ProgramacionHtml5.jpg", "", destacado, validado, precioInicial, preciofinal, oferta1, categoria1, tipoDificultad1);
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		cursos.add(curso5);
		cursos.add(curso6);
		cursos.add(curso7);
		cursos.add(curso8);
		cursos.add(curso9);
		cursos.add(curso10);
		cursos.add(curso11);
		cursos.add(curso12);
		cursos.add(curso13);
		cursos.add(curso14);	
		
		Alumno alumno1 = new Alumno(usuario1, null, cursos);
		Alumno alumno2 = new Alumno(usuario2, curso1, null);
		Alumno alumno3 = new Alumno(usuario3, null, null);
		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
				
		Profesor profesor = new Profesor(usuario4, curso1);
		Profesor profesor2 = new Profesor(usuario5, curso2);
		profesores.add(profesor);
		profesores.add(profesor2);	
		
		
		Calificacion calificacion1 = new Calificacion(alumno1, curso1, 6.5, tipoLogro1);
		calificaciones.add(calificacion1);
		
		Seccion seccion1 = new Seccion(1, "Seccion1", curso1);
		secciones.add(seccion1);
		
		Leccion leccion1 = new Leccion(1, "Leccion1", curso1, "Descripcion leccion 1", seccion1); 
		lecciones.add(leccion1);
		
		Material material1 = new Material(1, tipoMaterial1, leccion1, "", "material 1"); 
		materiales.add(material1);
		
		
		
		contexto.getServletContext().setAttribute("alumnos", alumnos);
		contexto.getServletContext().setAttribute("calificaciones", calificaciones);
		contexto.getServletContext().setAttribute("categorias", categorias);
		contexto.getServletContext().setAttribute("cursos", cursos);
		contexto.getServletContext().setAttribute("datosBancarios", datosBancarios);
		contexto.getServletContext().setAttribute("direcciones", direcciones);
		contexto.getServletContext().setAttribute("lecciones", lecciones);
		contexto.getServletContext().setAttribute("materiales", materiales);
		contexto.getServletContext().setAttribute("ofertas", ofertas);
		contexto.getServletContext().setAttribute("profesores",profesores);
		contexto.getServletContext().setAttribute("secciones", secciones);
		contexto.getServletContext().setAttribute("tipoDificultades", tipoDificultades);
		contexto.getServletContext().setAttribute("tipoLogros", tipoLogros);
		contexto.getServletContext().setAttribute("tipoMateriales", tipoMateriales);
		contexto.getServletContext().setAttribute("tipoOfertas", tipoOfertas);
		contexto.getServletContext().setAttribute("tipoUsuarios", tipoUsuarios);
		contexto.getServletContext().setAttribute("usuarios", usuarios);
	};

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String forwardJSP = "/principal.jsp";
		forward(request, response, forwardJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		
	}
	
	protected double calcularPrecio(double precioInicial, Oferta oferta) {
		double precioFinal = 0;
		int tipoOfer = oferta.getTipoOferta().getIdtipoOferta();
		double valorOfer = oferta.getValor();
		if(tipoOfer==1){
			precioFinal = precioInicial - valorOfer;
		}else if(tipoOfer==2){
			precioFinal = (1-(valorOfer/100))*precioInicial;
		}
		return precioFinal;
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
