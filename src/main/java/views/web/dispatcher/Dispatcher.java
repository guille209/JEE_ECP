package views.web.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;
import models.utils.IdentificadorAutorizacion;
import views.web.beans.AniadirTemaBean;
import views.web.beans.HomeBean;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/jspFiles/";

	private HomeBean homeBean;
	private AniadirTemaBean aniadirTemaBean;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch (action) {
		case "votar":
			view = "votar";
			break;
		case "verVotaciones":
			view = "verVotaciones";
			break;
		case "aniadirTema":
			view = action;
			break;
		case "eliminarTema":
			// El get lo procesa el bean principal,porque la autenticacion es en
			// el main
			// Pero el post el bean de eliminar
			homeBean = new HomeBean();
			homeBean.setIdentificadorAutorizacion(new IdentificadorAutorizacion(
					Integer.parseInt(request
							.getParameter("identificadorAutorizacion"))));
			view = homeBean.process();
			request.setAttribute("HomeView", homeBean);
			break;

		default:
			view = "home";
		}
		System.out.println("Redireccionando a " + PATH_ROOT_VIEW + view + ".jsp");
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
			System.out.println("[POST]LLevo a elimnar tema");
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
