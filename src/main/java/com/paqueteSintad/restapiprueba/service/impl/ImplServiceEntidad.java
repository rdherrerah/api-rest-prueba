package com.paquetesintad.restapiprueba.service.impl;

import com.paquetesintad.restapiprueba.dao.EntidadDao;
import com.paquetesintad.restapiprueba.dao.EntidadPaginableDao;
import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.model.EntidadMapper;
import com.paquetesintad.restapiprueba.model.request.EntidadRequest;
import com.paquetesintad.restapiprueba.model.request.EntidadRequestUpdate;
import com.paquetesintad.restapiprueba.model.response.EntidadResponse;
import com.paquetesintad.restapiprueba.service.ServiceEntidad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;

@Service
public class ImplServiceEntidad implements ServiceEntidad {
  @Autowired
  EntidadDao entidadDao;
  @Autowired
  EntidadPaginableDao entidadPaginableDao;
  @Autowired
  EntidadMapper entidadMapper;

  @Override
  public List<EntidadResponse> getAllEntidad() {
    List<EntidadResponse> response = new ArrayList<>();
    entidadDao.findAll().forEach(
      entidad -> response.add(entidadMapper.entidadToEntidadResponse(entidad))
    );
    return response;
  }

  @Override
  public Page<EntidadResponse> getAllEntidadPage(Integer page) {
    Pageable numberPage = PageRequest.of(page-1,8);
    return entidadPaginableDao.findAll(numberPage).map(
      entidadMapper::entidadToEntidadResponse
    );
  }

  @Override
  public EntidadResponse getEntidadById(Integer id) {
    return (EntidadResponse) entidadDao.findById(id).map(entidadMapper::entidadToEntidadResponse).orElse(null);
  }

  @Override
  public EntidadResponse saveEntidad(EntidadRequest entidadRequest) {
    return entidadMapper.entidadToEntidadResponse(
      entidadDao.save(entidadMapper.entidadRequestToEntidad(entidadRequest))
    );
  }

  @Override
  public EntidadResponse getEntidadByNroDocumento(String nroDocumento) {
    return entidadDao.findByNroDocumento(nroDocumento).map(entidadMapper::entidadToEntidadResponse).orElse(null);
  }

  public List<EntidadResponse> getEntidadByInformation(String information) {
    return entidadDao.findByInformation(
      information,
      information,
      information,
      information,
      information
    ).stream().map(entidadMapper::entidadToEntidadResponse).collect(Collectors.toUnmodifiableList());
  }

  @Override
  public EntidadResponse updateEntidad(Integer id, EntidadRequestUpdate entidadRequestUpdate) {
    Entidad newEntidad = entidadDao.findById(id).orElse(null);
    if (newEntidad != null) {
      entidadMapper.updateEntidadRequestUpdateFromEntidad(entidadRequestUpdate,newEntidad);
      entidadDao.deleteById(id);
      return entidadMapper.entidadToEntidadResponse(entidadDao.save(newEntidad));
    } else return null;
  }

  @Override
  public void deleteEntidad(Integer id) {
    entidadDao.deleteById(id);
  }
}
