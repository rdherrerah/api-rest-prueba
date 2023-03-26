package com.paquetesintad.restapiprueba.service;

import com.paquetesintad.restapiprueba.entity.TipoDocumento;

import java.util.List;

public interface ServiceTipoDocumento {
  public List<TipoDocumento> getAllTipoDocumento();

  public TipoDocumento getTipoDocumentoById(Integer id);

  public TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento);

  public TipoDocumento updateTipoDocumento(Integer id, TipoDocumento tipoDocumento);

  public void deleteTipoDocumento(Integer id);
}
