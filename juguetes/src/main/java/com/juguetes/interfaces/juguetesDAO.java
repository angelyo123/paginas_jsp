package com.juguetes.interfaces;

import java.util.List;

import com.juguetes.entidad.Juguetes;

public interface juguetesDAO {
	
	int save(Juguetes bean);
	List<Juguetes> findAll();
	int deleteById(int cod);

}
