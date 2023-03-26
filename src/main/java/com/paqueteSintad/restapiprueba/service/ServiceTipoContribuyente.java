package com.paquetesintad.restapiprueba.service;

import com.paquetesintad.restapiprueba.entity.TipoContribuyente;

import java.util.List;

public interface ServiceTipoContribuyente {
  public List<TipoContribuyente> getAllTipoContribuyente();

  public TipoContribuyente getTipoContribuyenteById(Integer id);

  public TipoContribuyente saveTipoContribuyente(TipoContribuyente tipoContribuyente);

  public TipoContribuyente updateTipoContribuyente(Integer id, TipoContribuyente tipoContribuyente);

  public void deleteTipoContribuyente(Integer id);
}
