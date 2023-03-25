package com.paquetesintad.restapiprueba.dao;

import com.paquetesintad.restapiprueba.entity.Entidad;
import org.springframework.data.repository.CrudRepository;

public interface EntidadDao extends CrudRepository<Entidad, Integer> {
}
