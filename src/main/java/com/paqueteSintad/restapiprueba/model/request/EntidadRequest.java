package com.paquetesintad.restapiprueba.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntidadRequest {
  @NotNull
  private Integer idTipoDocumento;
  @Size(min = 0,max = 25,message = "Debe tener entre 0 y 25 caracteres")
  private String nroDocumento;
  @Size(min = 0,max = 100,message = "Debe tener entre 0 y 100 caracteres")
  private String razonSocial;
  @Size(min = 0,max = 100,message = "Debe tener entre 0 y 100 caracteres")
  private String nombreComercial;
  @NotNull
  private Integer idTipoContribuyente;
  @Size(min = 0,max = 250,message = "Debe tener entre 0 y 100 caracteres")
  private String direccion;
  @Size(min = 0,max = 50,message = "Debe tener entre 0 y 100 caracteres")
  private String telefono;
  private Boolean estado;
}
