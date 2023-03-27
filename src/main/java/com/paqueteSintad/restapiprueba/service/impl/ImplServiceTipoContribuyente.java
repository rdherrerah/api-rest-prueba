package com.paquetesintad.restapiprueba.service.impl;

import com.paquetesintad.restapiprueba.dao.ITipoContribuyenteDAO;
import com.paquetesintad.restapiprueba.entity.TipoContribuyente;
import com.paquetesintad.restapiprueba.service.ServiceTipoContribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplServiceTipoContribuyente implements ServiceTipoContribuyente {

  @Autowired
  ITipoContribuyenteDAO iTipoContribuyenteDAO;

  @Override
  public List<TipoContribuyente> getAllTipoContribuyente() {
    return (List<TipoContribuyente>) iTipoContribuyenteDAO.findAll();
  }

  @Override
  public TipoContribuyente getTipoContribuyenteById(Integer id) {
    return (TipoContribuyente) iTipoContribuyenteDAO.findById(id).orElse(null);
  }

  @Override
  public TipoContribuyente saveTipoContribuyente(TipoContribuyente tipoContribuyente) {
    return (TipoContribuyente) iTipoContribuyenteDAO.save(tipoContribuyente);
  }

  @Override
  public TipoContribuyente updateTipoContribuyente(Integer id, TipoContribuyente tipoContribuyente) {

    TipoContribuyente newTipoContribuyente = iTipoContribuyenteDAO.findById(id).orElse(null);
    if (newTipoContribuyente != null) {
      newTipoContribuyente.setEstado(tipoContribuyente.getEstado() == null ? newTipoContribuyente.getEstado() : tipoContribuyente.getEstado());
      newTipoContribuyente.setNombre(tipoContribuyente.getNombre() == null ? newTipoContribuyente.getNombre() : tipoContribuyente.getNombre());
      iTipoContribuyenteDAO.updateTipoContribuyenteById(
        newTipoContribuyente.getNombre(),
        newTipoContribuyente.getEstado(),
        id);
      return newTipoContribuyente;
    } else return null;
  }

  @Override
  public void deleteTipoContribuyente(Integer id) {
    iTipoContribuyenteDAO.deleteById(id);
  }
}
