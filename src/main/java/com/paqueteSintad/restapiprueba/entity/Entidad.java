package com.paquetesintad.restapiprueba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_entidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entidad {
  @Id
  @Column(name = "id_entidad")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEntidad;
  @Column(name = "id_tipo_documento")
  private Integer idTipoDocumento;
  @Column(name = "nro_documento")
  private String nroDocumento;
  @Column(name = "razon_social")
  private String razonSocial;
  @Column(name = "nombre_comercial")
  private String nombreComercial;
  @Column(name = "id_tipo_contribuyente")
  private Integer idTipoContribuyente;
  @Column(name = "direccion")
  private String direccion;
  @Column(name = "telefono")
  private String telefono;
  @Column(name = "estado")
  private Byte estado;

}
