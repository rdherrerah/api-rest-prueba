package com.paquetesintad.restapiprueba.model;

import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.model.request.EntidadRequest;
import com.paquetesintad.restapiprueba.model.request.EntidadRequestUpdate;
import com.paquetesintad.restapiprueba.model.response.EntidadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EntidadMapper {
  public Entidad entidadRequestToEntidad(EntidadRequest entidadRequest);
  public EntidadResponse entidadToEntidadResponse(Entidad entidad);
  public void updateEntidadRequestUpdateFromEntidad(EntidadRequestUpdate entidadRequest, @MappingTarget Entidad entidad);
}
