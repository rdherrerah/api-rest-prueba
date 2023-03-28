package com.paquetesintad.restapiprueba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_contribuyente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoContribuyente {
  @Id
  @Column(name = "id_tipo_contribuyente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTipoContribuyente;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "estado")
  private Boolean estado;
}
