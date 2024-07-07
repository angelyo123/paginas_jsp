package com.juguetes.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.juguetes.dao.MySqlJuguetesDAO;
import com.juguetes.entidad.Juguetes;

/**
 * Servlet implementation class ServletJuguetesJSON
 */
public class ServletJuguetesJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJuguetesJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Juguetes> lista= new MySqlJuguetesDAO().findAll();
		Gson gson= new Gson();
		
		String json= gson.toJson(lista);
		response.setContentType("application/json");
		PrintWriter salida= response.getWriter();
		salida.println(json);
	}

}
