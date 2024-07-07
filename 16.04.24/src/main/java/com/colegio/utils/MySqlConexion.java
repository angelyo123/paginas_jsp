package com.colegio.utils;

//Paquete del API JDBC
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {
	//Metodo estatico que retorna la conexion con la base datos colegio_2024_grupo2
	public static Connection getConectar() {
		Connection cn=null;
		//ACCEDER A LA CLASE DRIVER QUE SE ENCUENTRA EN EL JAR
		//Controlar errores
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url,user,pass;
			user="root";
			pass="mysql";
			url="jdbc:mysql://localhost:3306/colegio_2024_grupo2?serverTimezone=UTC";
			//crear objeto "cn"
			cn=DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			e.printStackTrace();//lanzar traza de error en la consola
		}
		
		return cn;
	}
}
