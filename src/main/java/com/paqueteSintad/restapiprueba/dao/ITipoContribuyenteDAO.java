package com.paquetesintad.restapiprueba.dao;

import com.paquetesintad.restapiprueba.entity.TipoContribuyente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ITipoContribuyenteDAO extends CrudRepository<TipoContribuyente,Integer> {

  @Transactional
  @Modifying
  @Query("update TipoContribuyente tc " +
    "set tc.nombre = ?1, " +
    "tc.estado = ?2 " +
    "where tc.idTipoContribuyente = ?3")
  public int updateTipoContribuyenteById(String nombre,
                                         Boolean estado,
                                         Integer idTipoContribuyente);
}
