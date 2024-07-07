package com.juguetes.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.juguetes.dao.MySqlJuguetesDAO;
import com.juguetes.entidad.Juguetes;
import com.juguetes.utils.MySqlConexion;


public class ServletJuguetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletJuguetes() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo= request.getParameter("accion");
		
		if(tipo.equals("grabar"))
			grabarJuguete(request,response);
		else if(tipo.equals("listar"))
			listarJuguetes(request, response);
		else if(tipo.equals("eliminar"))
			eliminarJuguete(request,response);
	}

	private void eliminarJuguete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		String cod;
		cod=request.getParameter("codigo");
		new MySqlJuguetesDAO().deleteById(Integer.parseInt(cod));
		
		listarJuguetes(request, response);
		
	}

	private void listarJuguetes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Juguetes> info= new ArrayList<Juguetes>();
		request.setAttribute("listaJuguetes", info);
		request.getRequestDispatcher("/juguetes.jsp").forward(request, response);
		
		
	}

	private void grabarJuguete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nom, pre, cant;
		

		nom= request.getParameter("nombre");
		pre= request.getParameter("precio");
		cant= request.getParameter("cantidad");
		
		Juguetes ju= new Juguetes();
		

		ju.setNombre(nom);
		ju.setPrecio(Double.parseDouble(pre));
		ju.setCantidad(Integer.parseInt(cant));
		
		new MySqlJuguetesDAO().save(ju);
		response.sendRedirect("juguetes.jsp");
	}

}
