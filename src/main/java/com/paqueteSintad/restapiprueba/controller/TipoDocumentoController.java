package com.paquetesintad.restapiprueba.controller;

import com.paquetesintad.restapiprueba.entity.TipoDocumento;
import com.paquetesintad.restapiprueba.service.ServiceTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoController {
  @Autowired
  ServiceTipoDocumento serviceTipoDocumento;

  @GetMapping("")
  public List<TipoDocumento> getAllTipoDocumento(){
    return serviceTipoDocumento.getAllTipoDocumento();
  }

  @GetMapping("/find/{id}")
  public TipoDocumento getTipoDocumentoById(@PathVariable Integer id){
    return serviceTipoDocumento.getTipoDocumentoById(id);
  }

  @PutMapping("/add")
  public TipoDocumento saveTipoDocumento(@RequestBody TipoDocumento tipoDocumento){
    return serviceTipoDocumento.saveTipoDocumento(tipoDocumento);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteTipoDocumento(@PathVariable Integer id){
    serviceTipoDocumento.deleteTipoDocumento(id);
  }

  @PostMapping("/update/{id}")
  public TipoDocumento updateTipoDocumento(@RequestBody TipoDocumento tipoDocumento,@PathVariable Integer id){
    return serviceTipoDocumento.updateTipoDocumento(id,tipoDocumento);
  }
}
