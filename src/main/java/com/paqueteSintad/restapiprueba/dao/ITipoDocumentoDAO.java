package com.paquetesintad.restapiprueba.dao;

import com.paquetesintad.restapiprueba.entity.TipoDocumento;
import org.springframework.data.repository.CrudRepository;

public interface ITipoDocumentoDAO extends CrudRepository<TipoDocumento,Integer> {
}
