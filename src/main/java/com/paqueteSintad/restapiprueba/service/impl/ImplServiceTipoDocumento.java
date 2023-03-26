package com.paquetesintad.restapiprueba.service.impl;

import com.paquetesintad.restapiprueba.dao.ITipoDocumentoDAO;
import com.paquetesintad.restapiprueba.entity.TipoDocumento;
import com.paquetesintad.restapiprueba.service.ServiceTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplServiceTipoDocumento implements ServiceTipoDocumento {
  @Autowired
  ITipoDocumentoDAO iTipoDocumentoDAO;

  @Override
  public List<TipoDocumento> getAllTipoDocumento() {
    return (List<TipoDocumento>) iTipoDocumentoDAO.findAll();
  }

  @Override
  public TipoDocumento getTipoDocumentoById(Integer id) {
    return (TipoDocumento) iTipoDocumentoDAO.findById(id).orElse(null);
  }

  @Override
  public TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento) {
    return (TipoDocumento) iTipoDocumentoDAO.save(tipoDocumento);
  }

  @Override
  public TipoDocumento updateTipoDocumento(Integer id, TipoDocumento tipoDocumento) {
    TipoDocumento newTipoDocumento = iTipoDocumentoDAO.findById(id).orElse(null);
    if(newTipoDocumento!= null){
      newTipoDocumento.setCodigo(tipoDocumento.getCodigo()==null? newTipoDocumento.getCodigo() : tipoDocumento.getCodigo());
      newTipoDocumento.setDescripcion(tipoDocumento.getDescripcion()==null?newTipoDocumento.getDescripcion():tipoDocumento.getDescripcion());
      newTipoDocumento.setEstado(tipoDocumento.getEstado()==null?newTipoDocumento.getEstado():tipoDocumento.getEstado());
      newTipoDocumento.setNombre(tipoDocumento.getNombre()==null?newTipoDocumento.getNombre():tipoDocumento.getNombre());
      iTipoDocumentoDAO.deleteById(id);
      return iTipoDocumentoDAO.save(newTipoDocumento);
    }
    else return null;
  }

  @Override
  public void deleteTipoDocumento(Integer id) {
    iTipoDocumentoDAO.deleteById(id);
  }
}
