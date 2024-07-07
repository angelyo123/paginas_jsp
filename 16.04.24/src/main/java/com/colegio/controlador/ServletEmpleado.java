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

public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEmpleado() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperar atributo accion que viene del cliente
		String tipo = request.getParameter("accion");
		
		// validar tipo
		if (tipo.equals("grabar"))
			grabarEmpleado(request, response);
		else if(tipo.equals("eliminar"))
			eliminarEmpleado(request, response);
		else if(tipo.equals("listar"))
			listarEmpleados(request, response);
		else if(tipo.equals("buscarPorId"))
			buscarEmpleadoPorCodigo(request, response);
	}

	private void buscarEmpleadoPorCodigo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Recuperar el parametro codigo que viene de la pagina empleado.jsp "boton editar"
		String cod=request.getParameter("codigo");
		//invocar al metodo findById
		Empleado e=new MySqlEmpleadoDao().findById(Integer.parseInt(cod));
		Gson gson=new Gson();
		String json=gson.toJson(e);
		response.setContentType("application/json");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//traer la lista de todos los empleados que se encuentran en el metodo findAll
		List<Empleado> info=new MySqlEmpleadoDao().finALL();
		//respuesta del Servlet (response) "enviar un atributo y guardar en el info"
		request.setAttribute("listaEmpleados", info);
		//Direccionar a la pagina Empleado.jsp para que reciba el atributo listaEmpleados
		request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
	}

	private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer codigo
		String cod;
		cod= request.getParameter("codigo");
		//invocar metodo "deleteById" y enviar la variable "cod"
		int estado=new MySqlEmpleadoDao().deleteById(Integer.parseInt(cod));
		//validar estado
		if(estado>0){
			//crear un atributo de tipo sesion que guarde el mensaje de eliminacion OK
			request.getSession().setAttribute("MENSAJE", "Empleado eliminado correctamente");
		}
		else {
			request.getSession().setAttribute("MENSAJE", "Error en la eliminacion del Empleado");
		}
		//response
		response.sendRedirect("Empleado.jsp");
	}

	private void grabarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// recuperar valores del url (atributo name de los controles)
		// variables
		String nom, pat, mat, sexo, hijos, sue, tipo, cod;
		// recuperar
		nom = request.getParameter("nombre");
		pat = request.getParameter("paterno");
		mat = request.getParameter("materno");
		sexo = request.getParameter("sexo");
		hijos = request.getParameter("hijos");
		sue = request.getParameter("sueldo");
		tipo = request.getParameter("tipo");
		cod= request.getParameter("codigo");
		
		// crear objeto de la clase empleado
		Empleado emp = new Empleado();

		emp.setNombre(nom);
		emp.setParterno(pat);
		emp.setMaterno(mat);
		emp.setSexo(sexo);
		emp.setHijos(Integer.parseInt(hijos));
		emp.setSueldo(Double.parseDouble(sue));
		emp.setCodigoTipoEmpleado(Integer.parseInt(tipo));
		
		//validar codigo
		if(Integer.parseInt(cod)==0) {
			
		// invcocar al metodo save y enviar el objeto "emp"
		int estado=new MySqlEmpleadoDao().save(emp);
		if(estado>0){
			//crear un atributo de tipo sesion que guarde el mensaje de eliminacion OK
			request.getSession().setAttribute("MENSAJE", "Empleado registrado correctamente");
		}
		else {
			request.getSession().setAttribute("MENSAJE", "Error en el registro del Empleado");
		}
		//response
		response.sendRedirect("Empleado.jsp");
		}
		else {
			emp.setCodigo(Integer.parseInt(cod));
			int estado=new MySqlEmpleadoDao().update(emp);
			if(estado>0){
				//crear un atributo de tipo sesion que guarde el mensaje de eliminacion OK
				request.getSession().setAttribute("MENSAJE", "Empleado actualizado correctamente");
			}
			else {
				request.getSession().setAttribute("MENSAJE", "Error en la actualizacion del Empleado");
			}
			//response
			response.sendRedirect("Empleado.jsp");
		}
	}

}
