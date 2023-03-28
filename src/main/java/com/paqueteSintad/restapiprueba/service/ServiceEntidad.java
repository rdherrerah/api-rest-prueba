package com.paquetesintad.restapiprueba.service;

import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.model.request.EntidadRequest;
import com.paquetesintad.restapiprueba.model.request.EntidadRequestUpdate;
import com.paquetesintad.restapiprueba.model.response.EntidadResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ServiceEntidad {

  public List<EntidadResponse> getAllEntidad();

  public Page<EntidadResponse> getAllEntidadPage(Integer page);

  public EntidadResponse getEntidadById(Integer id);

  public EntidadResponse getEntidadByNroDocumento(String nroDocumento);

  public List<EntidadResponse> getEntidadByInformation(String information);

  public EntidadResponse saveEntidad(EntidadRequest entidadRequest);

  public EntidadResponse updateEntidad(Integer id, EntidadRequestUpdate entidadRequestUpdate);

  public void deleteEntidad(Integer id);
}
