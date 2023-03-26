package com.paquetesintad.restapiprueba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_contribuyente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoContribuyente {
  @Id
  @Column(name = "id_tipo_contribuyente")
  private Integer idTipoContribuyente;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "estado")
  private Character estado;
}
