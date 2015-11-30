package es.uc3m.tiw.controladores;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.tiw.model.Usuario;


/**
 * Servlet implementation class PromocionServlet
 */
@WebServlet("/promocion")
public class PromocionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromocionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(true);
		Usuario usuarioLogado = (Usuario) sesion.getAttribute("usuario");
		String forwardJSP = "/promocion.jsp";
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
