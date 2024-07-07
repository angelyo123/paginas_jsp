package com.colegio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.colegio.entidad.Empleado;
import com.colegio.interfaces.EmpleadoDAO;
import com.colegio.utils.MySqlConexion;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;

public class MySqlEmpleadoDao implements EmpleadoDAO{

	@Override
	public int save(Empleado bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="insert into tb_empleado values (null,?,?,?,?,?,?,?)";
			pstm= cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getParterno());
			pstm.setString(3, bean.getMaterno());
			pstm.setString(4, bean.getSexo());
			pstm.setInt(5, bean.getHijos());
			pstm.setDouble(6, bean.getSueldo());
			pstm.setInt(7, bean.getCodigoTipoEmpleado());
			salida=pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();//Lanza traza de error en la consola
		} finally {
			try {
				if (pstm!=null) pstm.close();
				if (cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int update(Empleado bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="update tb_empleado set nom_emp=?, pat_emp=?, mat_emp=?, sexo_emp=?, hijos_emp=?, sue_emp=?, cod_tip_emp=? where cod_emp=?";
			pstm= cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getParterno());
			pstm.setString(3, bean.getMaterno());
			pstm.setString(4, bean.getSexo());
			pstm.setInt(5, bean.getHijos());
			pstm.setDouble(6, bean.getSueldo());
			pstm.setInt(7, bean.getCodigoTipoEmpleado());
			pstm.setInt(8, bean.getCodigo());
			salida=pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();//Lanza traza de error en la consola
		} finally {
			try {
				if (pstm!=null) pstm.close();
				if (cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int deleteById(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConectar();
			String sql="delete from tb_empleado where cod_emp=?";
			pstm= cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			salida=pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();//Lanza traza de error en la consola
		} finally {
			try {
				if (pstm!=null) pstm.close();
				if (cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public List<Empleado> finALL() {
		List<Empleado> data=new ArrayList<Empleado>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;//rs almacena los datos de un SELECT
		try {
			cn=MySqlConexion.getConectar();
			String sql="select * from tb_empleado";
			pstm=cn.prepareStatement(sql);
			
			rs=pstm.executeQuery();//metodo executeQuery() ejecuta el SELECT
			while(rs.next()) {
				Empleado emp=new Empleado();
				emp.setCodigo(rs.getInt(1));
				emp.setNombre(rs.getString(2));
				emp.setParterno(rs.getString(3));
				emp.setMaterno(rs.getString(4));
				emp.setSexo(rs.getString(5));
				emp.setHijos(rs.getInt(6));
				emp.setSueldo(rs.getDouble(7));
				emp.setCodigoTipoEmpleado(rs.getInt(8));
				data.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return data;
	}

	@Override
	public Empleado findById(int cod) {
		Empleado emp=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;//rs almacena los datos de un SELECT
		try {
			cn=MySqlConexion.getConectar();
			String sql="select * from tb_empleado where cod_emp=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();//metodo executeQuery() ejecuta el SELECT
			if(rs.next()) {
				emp=new Empleado();
				emp.setCodigo(rs.getInt(1));
				emp.setNombre(rs.getString(2));
				emp.setParterno(rs.getString(3));
				emp.setMaterno(rs.getString(4));
				emp.setSexo(rs.getString(5));
				emp.setHijos(rs.getInt(6));
				emp.setSueldo(rs.getDouble(7));
				emp.setCodigoTipoEmpleado(rs.getInt(8));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return emp;
	}
	
}
