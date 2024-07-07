package com.colegio.entidad;

public class Empleado {
	private int codigo,hijos,codigoTipoEmpleado;
	private String nombre,parterno,materno,sexo;
	private double sueldo;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getHijos() {
		return hijos;
	}
	public void setHijos(int hijos) {
		this.hijos = hijos;
	}
	public int getCodigoTipoEmpleado() {
		return codigoTipoEmpleado;
	}
	public void setCodigoTipoEmpleado(int codigoTipoEmpleado) {
		this.codigoTipoEmpleado = codigoTipoEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getParterno() {
		return parterno;
	}
	public void setParterno(String parterno) {
		this.parterno = parterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
}
