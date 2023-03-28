package com.paquetesintad.restapiprueba.controller;

import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.service.ServiceEntidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {

  @Autowired
  private ServiceEntidad serviceEntidad;

  @GetMapping("")
  public List<Entidad> getAllEntidad() {
    return serviceEntidad.getAllEntidad();
  }

  @GetMapping("/page/{page}")
  public Page<Entidad> getAllEntidadPage(@PathVariable Integer page) {
    return serviceEntidad.getAllEntidadPage(page);
  }

  @GetMapping("/find/{id}")
  public Entidad getEntidadById(@PathVariable Integer id) {
    return serviceEntidad.getEntidadById(id);
  }

  @GetMapping("/find/documento/{nroDocumento}")
  public Entidad getTipoDocumentoByNroDocumento(@PathVariable String nroDocumento){
    return serviceEntidad.getEntidadByNroDocumento(nroDocumento);
  }

  @GetMapping("/find/information/{information}")
  public List<Entidad> getTipoDocumentoByInformation(@PathVariable String information){
    return serviceEntidad.getEntidadByInformation(information);
  }

  @PutMapping("/add")
  public Entidad saveEntidad(@RequestBody Entidad entidad) {
    return serviceEntidad.saveEntidad(entidad);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteEntidad(@PathVariable Integer id) {
    serviceEntidad.deleteEntidad(id);
  }

  @PostMapping("/update/{id}")
  public Entidad updateEntidad(@RequestBody Entidad entidad, @PathVariable Integer id) {
    return serviceEntidad.updateEntidad(id, entidad);
  }
}
