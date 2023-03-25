package com.paquetesintad.restapiprueba.controller;

import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.service.ServiceEntidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {

  @Autowired
  private ServiceEntidad serviceEntidad;

  @GetMapping("")
  public List<Entidad> getAllEntidad() {
    return serviceEntidad.getAllEntidad();
  }

  @GetMapping("/find/{id}")
  public Entidad getEntidadById(@PathVariable Integer id) {
    return serviceEntidad.getEntidadById(id);
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
