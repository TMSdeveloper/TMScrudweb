package com.TMSolutions.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TMSolutions.dao.barraDAO;
import com.TMSolutions.model.Main;

/**
 * Servlet implementation class MainController
 */
@WebServlet(description = "gestiona peticiones a la tabla Main", urlPatterns = { "/barras" })
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		
		System.out.println(opcion);
		
		switch (opcion) {
		
		case "crear":
			System.out.println("Ud. ha presionado CREAR");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		break;
		
		case "listar":
			barraDAO barraDAO = new barraDAO();
			List<Main> lista = new ArrayList<>();
			
			try {
				lista = barraDAO.obtenerBarras();
				for (Main barra : lista) {
				System.out.println(barra);
				}
				
				// pasar la lista a la vista listar.jsp
				request.setAttribute("lista", lista);
				
				RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher1.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		break;
		
		case "meditar":
				int ID = Integer.parseInt(request.getParameter("ID"));

				barraDAO barraDAO1 = new barraDAO();
				Main b = new Main();
				
				try {
					b = barraDAO1.obtenerBarra(ID);
					System.out.println(b);
					request.setAttribute("barra", b);
					RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("/views/editar.jsp");
					requestDispatcher1.forward(request, response);
					System.out.println("Aquí llegamos");				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		break;

		case "eliminar":
			barraDAO barraDAO2 = new barraDAO();			
			int ID1 = Integer.parseInt(request.getParameter("ID"));
			try {
				barraDAO2.eliminar(ID1);
				System.out.println("Barra eliminada satisfactoriamente...");
				RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("/index.jsp");
				requestDispatcher1.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();
		
		switch(opcion) {
		
		case "guardar":
		
			barraDAO barraDAO = new barraDAO();
			
			Main barra = new Main();
			//barra.setIn_date(new java.sql.Date(fechaActual.getTime()));
			barra.setID_mineral((int) Double.parseDouble(request.getParameter("ID_mineral")));
			barra.setID_status((int) Double.parseDouble(request.getParameter("ID_status")));
			barra.setOr_weight(Double.parseDouble(request.getParameter("or_weight")));
			barra.setOr_purity(Double.parseDouble(request.getParameter("or_purity")));
			barra.setUp_date(new java.sql.Date(fechaActual.getTime()));
			
			try {
				barraDAO.guardar(barra);
				System.out.println("Barra registrada satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		break;
		
		case "editar":
			
			Main barra1 = new Main();
			barraDAO barraDAO1 = new barraDAO();
			
			barra1.setID(Integer.parseInt(request.getParameter("ID")));
			barra1.setID_mineral((int) Double.parseDouble(request.getParameter("ID_mineral")));
			barra1.setID_status((int) Double.parseDouble(request.getParameter("ID_status")));
			barra1.setOr_weight(Double.parseDouble(request.getParameter("or_weight")));
			barra1.setOr_purity(Double.parseDouble(request.getParameter("or_purity")));
			barra1.setUp_date(new java.sql.Date(fechaActual.getTime()));
			try {
				barraDAO1.editar(barra1);
				System.out.println("Barra editada satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		break;
		
		}
		
		
		//doGet(request, response);
		
	}

}
