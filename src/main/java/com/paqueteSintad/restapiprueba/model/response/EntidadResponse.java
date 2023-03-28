package com.paquetesintad.restapiprueba.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntidadResponse {
  private Integer idEntidad;
  private Integer idTipoDocumento;
  private String nroDocumento;
  private String razonSocial;
  private String nombreComercial;
  private Integer idTipoContribuyente;
  private String direccion;
  private String telefono;
  private Boolean estado;
}
