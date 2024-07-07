package com.colegio.interfaces;

import java.util.List;

import com.colegio.entidad.Empleado;

public interface EmpleadoDAO {
	int save(Empleado bean);
	int update(Empleado bean);
	int deleteById(int cod);
	List<Empleado> finALL();
	Empleado findById(int cod);
}
