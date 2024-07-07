package com.colegio.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.colegio.dao.MySqlEmpleadoDao;
import com.colegio.entidad.Empleado;
import com.google.gson.Gson;


public class ServletEmpleadoJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEmpleadoJSON() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Invocar al metodo FindAll
		List<Empleado> lista=new MySqlEmpleadoDao().finALL();
		//Paso 1: crear un objeto de la clase Gson
		Gson gson=new Gson();
		//Paso 2: guardar el json generado en una variable de tipo String
		//usar el metodo toJosn
		String json=gson.toJson(lista);
		//Paso 3: convertir el valor de la variable "json" en JSON verdadero
		response.setContentType("application/json");
		//Paso 4: mostrar el valor de la variable "json" en el navegador
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}
