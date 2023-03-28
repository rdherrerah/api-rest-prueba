package com.paquetesintad.restapiprueba.controller;

import com.paquetesintad.restapiprueba.entity.TipoContribuyente;
import com.paquetesintad.restapiprueba.service.ServiceTipoContribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoContribuyente")
public class TipoContribuyenteController {
  @Autowired
  private ServiceTipoContribuyente serviceTipoContribuyente;

  @GetMapping("")
  public List<TipoContribuyente> getAllTipoContribuyente(){
    return serviceTipoContribuyente.getAllTipoContribuyente();
  }

  @GetMapping("/find/{id}")
  public TipoContribuyente getTipoContribuyenteById(@PathVariable Integer id){
    return serviceTipoContribuyente.getTipoContribuyenteById(id);
  }

  @PutMapping("/add")
  public TipoContribuyente saveTipoContribuyente(@RequestBody TipoContribuyente entidad){
    return serviceTipoContribuyente.saveTipoContribuyente(entidad);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteTipoContribuyente(@PathVariable Integer id){
    serviceTipoContribuyente.deleteTipoContribuyente(id);
  }

  @PostMapping("/update/{id}")
  public TipoContribuyente updateTipoContribuyente(@RequestBody TipoContribuyente entidad,@PathVariable Integer id){
    return serviceTipoContribuyente.updateTipoContribuyente(id,entidad);
  }
}
