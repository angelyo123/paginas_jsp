package com.juguetes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.juguetes.entidad.Juguetes;
import com.juguetes.interfaces.juguetesDAO;
import com.juguetes.utils.MySqlConexion;

public class MySqlJuguetesDAO implements juguetesDAO{

	@Override
	public int save(Juguetes bean) {
		
		int salida= -1;
		Connection cn= null;
		PreparedStatement pstm= null;
		
		try {
			
			cn= MySqlConexion.getConexion();
			String sql="insert into tb_juguetes values(null, ?,?,?)";
			pstm= cn.prepareStatement(sql);
			
			pstm.setString(1, bean.getNombre());
			pstm.setDouble(2, bean.getPrecio());
			pstm.setInt(3, bean.getCantidad());
			
			salida= pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(cn!=null) cn.close();
				if(pstm!=null) pstm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public List<Juguetes> findAll() {
		List<Juguetes> data= new ArrayList<Juguetes>();
		Connection cn= null;
		PreparedStatement pstm= null;
		ResultSet rs= null;
		
		try {
			
			cn= MySqlConexion.getConexion();
			String sql= "select * from tb_juguetes";
			pstm= cn.prepareStatement(sql);
			rs= pstm.executeQuery();
			
			while (rs.next()) {
				
				Juguetes ju= new Juguetes();
				
				ju.setCodigo(rs.getInt(1));
				ju.setNombre(rs.getString(2));
				ju.setPrecio(rs.getDouble(3));
				ju.setCantidad(rs.getInt(4));
				
				data.add(ju);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(cn!=null) cn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return data;
	}

	@Override
	public int deleteById(int cod) {
		

		int salida= -1;
		Connection cn= null;
		PreparedStatement pstm= null;
		
		try {
			
			cn= MySqlConexion.getConexion();
			String sql="delete *from tb_juguetes where codigo=?";
			pstm= cn.prepareStatement(sql);
			
			pstm.setInt(1, cod);
			
			salida= pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(cn!=null) cn.close();
				if(pstm!=null)pstm.close();
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	

}
