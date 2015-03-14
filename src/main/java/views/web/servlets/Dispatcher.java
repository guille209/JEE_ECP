package views.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.entities.Tema;
import views.web.beans.A�adirTemaViewBean;

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
			A�adirTemaViewBean a�adirTemaView = new A�adirTemaViewBean();
			a�adirTemaView.setTema(new Tema());
			request.setAttribute(action, a�adirTemaView);
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
			A�adirTemaViewBean a�adirTemaView = new A�adirTemaViewBean();
			a�adirTemaView.setTema(tema);
			request.setAttribute(action, a�adirTemaView);
			view = a�adirTemaView.process();
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
