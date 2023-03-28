package com.paquetesintad.restapiprueba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_documento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {
  @Id
  @Column(name = "id_tipo_documento")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTipoDocumento;
  @Column(name = "codigo")
  private String codigo;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "descripcion")
  private String descripcion;
  @Column(name = "estado")
  private Boolean estado;
}
