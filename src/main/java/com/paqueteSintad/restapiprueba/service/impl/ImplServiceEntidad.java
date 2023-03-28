package com.paquetesintad.restapiprueba.service.impl;

import com.paquetesintad.restapiprueba.dao.EntidadDao;
import com.paquetesintad.restapiprueba.dao.EntidadPaginableDao;
import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.service.ServiceEntidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImplServiceEntidad implements ServiceEntidad {
  @Autowired
  EntidadDao entidadDao;
  @Autowired
  EntidadPaginableDao entidadPaginableDao;

  @Override
  public List<Entidad> getAllEntidad() {
    return (List<Entidad>) entidadDao.findAll();
  }

  @Override
  public Page<Entidad> getAllEntidadPage(Integer page) {
    Pageable numberPage = PageRequest.of(page-1,8);
    return entidadPaginableDao.findAll(numberPage);
  }

  @Override
  public Entidad getEntidadById(Integer id) {
    return (Entidad) entidadDao.findById(id).orElse(null);
  }

  @Override
  public Entidad saveEntidad(Entidad entidad) {
    return entidadDao.save(entidad);
  }

  @Override
  public Entidad getEntidadByNroDocumento(String nroDocumento) {
    return entidadDao.findByNroDocumento(nroDocumento).orElse(null);
  }

  public List<Entidad> getEntidadByInformation(String information) {
    return (List<Entidad>) entidadDao.findByInformation(
      information,
      information,
      information,
      information,
      information
    );
  }

  @Override
  public Entidad updateEntidad(Integer id, Entidad entidad) {
    Entidad newEntidad = entidadDao.findById(id).orElse(null);
    if (newEntidad != null) {
      newEntidad.setEstado(entidad.getEstado() == null ? newEntidad.getEstado() : entidad.getEstado());
      newEntidad.setDireccion(entidad.getDireccion() == null ? newEntidad.getDireccion() : entidad.getDireccion());
      newEntidad.setIdTipoContribuyente(entidad.getIdTipoContribuyente() == null ? newEntidad.getIdTipoContribuyente() : entidad.getIdTipoContribuyente());
      newEntidad.setTelefono(entidad.getTelefono() == null ? newEntidad.getTelefono() : entidad.getTelefono());
      newEntidad.setNombreComercial(entidad.getNombreComercial() == null ? newEntidad.getNombreComercial() : entidad.getNombreComercial());
      newEntidad.setNroDocumento(entidad.getNroDocumento() == null ? newEntidad.getNroDocumento() : entidad.getNroDocumento());
      newEntidad.setRazonSocial(entidad.getRazonSocial() == null ? newEntidad.getRazonSocial() : entidad.getRazonSocial());
      newEntidad.setIdTipoDocumento(entidad.getIdTipoDocumento() == null ? newEntidad.getIdTipoDocumento() : entidad.getIdTipoDocumento());
      entidadDao.deleteById(id);
      return entidadDao.save(newEntidad);
    } else return null;
  }

  @Override
  public void deleteEntidad(Integer id) {
    entidadDao.deleteById(id);
  }
}
