package views.web.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.IdentificadorAutorizacion;
import models.utils.NivelEstudios;
import views.web.beans.AniadirTemaBean;
import views.web.beans.EliminarTemaBean;
import views.web.beans.HomeBean;
import views.web.beans.VerVotacionesBean;
import views.web.beans.VotarBean;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/jspFiles/";

	private VotarBean votarBean;
	private AniadirTemaBean aniadirTemaBean;
	private VerVotacionesBean verVotacionesBean;
	private EliminarTemaBean eliminarTemaBean;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);
		String view;
		switch (action) {
		case "votar":
			votarBean = new VotarBean();
			view = votarBean.processMostrarVotacion();
			request.setAttribute(action, votarBean);
			break;
		case "verVotaciones":
			verVotacionesBean = new VerVotacionesBean();
			view = verVotacionesBean.processverVotaciones();
			request.setAttribute(action, verVotacionesBean);
			break;
		case "aniadirTema":
			view = action;
			break;
		case "eliminarTema":
			eliminarTemaBean = new EliminarTemaBean();
			eliminarTemaBean
					.setIdentificadorAutorizacion(new IdentificadorAutorizacion(
							Integer.parseInt(request
									.getParameter("identificadorAutorizacion"))));
			view = eliminarTemaBean.processAutenticacion();
			request.setAttribute(action, eliminarTemaBean);
			break;

		default:
			view = "home";
		}
		System.out.println("Redireccionando a " + PATH_ROOT_VIEW + view
				+ ".jsp");
		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		switch (action) {
		case "votar":
			votarBean = new VotarBean();
			votarBean.setValoracion(Integer.parseInt(request.getParameter("valoracion")));
			votarBean.setNivelEstudios(NivelEstudios.valueOf(request.getParameter("nivelEstudios")));
			votarBean.setNombreTema(request.getParameter("nombreTema"));
			votarBean.setIp(request.getRemoteAddr());	
			view = votarBean.processGuardarVoto();

			break;
		case "verVotaciones":
			break;

		case "aniadirTema":
			Tema tema = new Tema(request.getParameter("nombre"),
					request.getParameter("pregunta"));
			aniadirTemaBean = new AniadirTemaBean();
			aniadirTemaBean.setTema(tema);
			view = aniadirTemaBean.process();
			request.setAttribute(action, aniadirTemaBean);
			break;
		case "eliminarTema":
			eliminarTemaBean = new EliminarTemaBean();
			eliminarTemaBean.setTemaEliminar(request.getParameter("nivelEstudios"));
			view = eliminarTemaBean.processEliminarTema();
			
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
