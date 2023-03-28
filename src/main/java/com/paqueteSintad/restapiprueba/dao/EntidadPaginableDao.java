package com.paquetesintad.restapiprueba.dao;

import com.paquetesintad.restapiprueba.entity.Entidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EntidadPaginableDao extends PagingAndSortingRepository<Entidad, String> {
  public Page<Entidad> findAll(Pageable pageable);

}
