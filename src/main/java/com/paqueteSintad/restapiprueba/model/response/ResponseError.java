package com.paquetesintad.restapiprueba.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
  private Integer status;
  private String generalMessage;
  private Map<String,String> listErrors;
}
