package views.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;
import models.utils.IdentificadorAutorizacion;
import views.web.beans.AniadirTemaViewBean;
import views.web.beans.HomeViewBean;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/jspFiles/";
	
	private HomeViewBean homeViewBean;
	private AniadirTemaViewBean aniadirTemaViewBean;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch (action) {
		case "aniadirTema":
			view = action;
			break;
		case "eliminarTema":
			//El get lo procesa el bean principal,porque la autenticacion es en el main
			//Pero el post el bean de eliminar
			homeViewBean = new HomeViewBean();
			homeViewBean.setIdentificadorAutorizacion(new IdentificadorAutorizacion(Integer.parseInt(request.getParameter("identificadorAutorizacion"))));
			view = homeViewBean.process();
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
			aniadirTemaViewBean = new AniadirTemaViewBean();
			aniadirTemaViewBean.setTema(tema);
			request.setAttribute(action, aniadirTemaViewBean);
			view = aniadirTemaViewBean.process();
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
