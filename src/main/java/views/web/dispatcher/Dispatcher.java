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
import views.web.beans.VerVotacionesBean;
import views.web.beans.VotarBean;
import views.web.beans.VoteSubmitView;
import controllers.ejbs.ControllerFactory;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/jspFiles/";

	private ControllerFactory controllerFactory;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializo controllerfactory");
		controllerFactory = new ControllerFactory();

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);
		String view;
		switch (action) {
		case "votar":
			VoteSubmitView voteSubmitView= new VoteSubmitView();
			voteSubmitView.setControllerFactory(controllerFactory);

			request.setAttribute(action, voteSubmitView);
			view = action;
			break;
		case "verVotaciones":
			VerVotacionesBean verVotacionesBean = new VerVotacionesBean();
			verVotacionesBean.setControllerFactory(controllerFactory);
			request.setAttribute(action, verVotacionesBean);
			view = action;
			break;
		case "aniadirTema":
			view = action;
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
			VotarBean votarBean = new VotarBean();
			votarBean.setControllerFactory(controllerFactory);

			votarBean.setNombreTema(request.getParameter("nombreTema"));
			Voto voto = new Voto();
			voto.setValoracion(Integer.parseInt(request
					.getParameter("valoracion")));
			voto.setNivelEstudios(NivelEstudios.valueOf(request
					.getParameter("nivelEstudios")));
			voto.setIp(request.getRemoteAddr());
			voto.setValoracion(Integer.parseInt(request
					.getParameter("valoracion")));
			votarBean.setVoto(voto);
			System.out.println(voto);
			view = votarBean.processGuardarVoto();

			break;
		case "verVotaciones":
			break;

		case "aniadirTema":
			Tema tema = new Tema(request.getParameter("nombre"),
					request.getParameter("pregunta"));
			AniadirTemaBean aniadirTemaBean = new AniadirTemaBean();
			aniadirTemaBean.setControllerFactory(controllerFactory);
			aniadirTemaBean.setTema(tema);
			view = aniadirTemaBean.process();
			request.setAttribute(action, aniadirTemaBean);
			break;
		case "eliminarTema":
			EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
			eliminarTemaBean.setControllerFactory(controllerFactory);
			eliminarTemaBean.setIdTemaEliminar(Integer.parseInt(request
					.getParameter("nivelEstudios")));
			view = eliminarTemaBean.processEliminarTema();
			break;
		case "identificarEliminar":
			EliminarTemaBean eliminarTemaBean2 = new EliminarTemaBean();
			eliminarTemaBean2.setControllerFactory(controllerFactory);
			eliminarTemaBean2.setIdentificador(Integer.parseInt((request
									.getParameter("identificadorAutorizacion"))));
			view = eliminarTemaBean2.processIdentificar();
			request.setAttribute(action, eliminarTemaBean2);
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
