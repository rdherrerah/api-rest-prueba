package com.paquetesintad.restapiprueba.dao;

import com.paquetesintad.restapiprueba.entity.TipoDocumento;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ITipoDocumentoDAO extends CrudRepository<TipoDocumento,Integer> {

  @Transactional
  @Modifying
  @Query("update TipoDocumento td " +
    "set td.codigo = ?1, " +
    "td.nombre = ?2, " +
    "td.descripcion = ?3," +
    "td.estado = ?4 " +
    "where td.idTipoDocumento = ?5")
  public int updateTipoDocumentoById(String codigo,
                                         String nombre,
                                         String descripcion,
                                         Boolean estado,
                                         Integer idTipoContribuyente);
}
