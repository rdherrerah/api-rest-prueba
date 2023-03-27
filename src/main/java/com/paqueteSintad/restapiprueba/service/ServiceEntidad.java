package com.paquetesintad.restapiprueba.service;

import com.paquetesintad.restapiprueba.entity.Entidad;
import java.util.List;

public interface ServiceEntidad {

  public List<Entidad> getAllEntidad();

  public Entidad getEntidadById(Integer id);

  public Entidad getEntidadByNroDocumento(String nroDocumento);

  public List<Entidad> getEntidadByInformation(String information);

  public Entidad saveEntidad(Entidad entidad);

  public Entidad updateEntidad(Integer id, Entidad entidad);

  public void deleteEntidad(Integer id);
}
