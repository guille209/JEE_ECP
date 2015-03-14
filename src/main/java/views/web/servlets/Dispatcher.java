package views.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.entities.Tema;
import views.web.beans.AñadirTemaViewBean;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/jspFiles/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch (action) {
		case "aniadirTema":
			AñadirTemaViewBean añadirTemaView = new AñadirTemaViewBean();
			añadirTemaView.setTema(new Tema());
			request.setAttribute(action, añadirTemaView);
			view = action;
			break;

		default:
			view = "home";
		}

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
		case "aniadirTema":
			Tema tema = new Tema(request.getParameter("nombre"),
					request.getParameter("pregunta"));
			AñadirTemaViewBean añadirTemaView = new AñadirTemaViewBean();
			añadirTemaView.setTema(tema);
			request.setAttribute(action, añadirTemaView);
			view = añadirTemaView.process();
			break;
		case "rol":
			// RolView rolView = new RolView();
			// rolView.setRol(request.getParameter("rol"));
			// request.setAttribute(action, rolView);
			// view = rolView.process();
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
