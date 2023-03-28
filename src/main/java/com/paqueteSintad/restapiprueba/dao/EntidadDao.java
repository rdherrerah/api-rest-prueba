package com.paquetesintad.restapiprueba.dao;

import com.paquetesintad.restapiprueba.entity.Entidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EntidadDao extends CrudRepository<Entidad, Integer> {
  public Optional<Entidad> findByNroDocumento(String nroDocumento);

  @Query("select e from Entidad e " +
    "where e.nroDocumento like %?#{escape([0])}% " +
    "or e.razonSocial like %?#{escape([1])}% "+
    "or e.nombreComercial like %?#{escape([2])}% "+
    "or e.direccion like %?#{escape([3])}% "+
    "or e.telefono like %?#{escape([4])}% ")
  public List<Entidad> findByInformation(String nroDocumento,
                                         String razonSocial,
                                         String nombreComercial,
                                         String direccion,
                                         String telefono);
}
