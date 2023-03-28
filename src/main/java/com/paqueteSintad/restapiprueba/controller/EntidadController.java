package com.paquetesintad.restapiprueba.controller;

import com.paquetesintad.restapiprueba.entity.Entidad;
import com.paquetesintad.restapiprueba.model.request.EntidadRequest;
import com.paquetesintad.restapiprueba.model.request.EntidadRequestUpdate;
import com.paquetesintad.restapiprueba.model.response.EntidadResponse;
import com.paquetesintad.restapiprueba.model.response.ResponseError;
import com.paquetesintad.restapiprueba.service.ServiceEntidad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {

  @Autowired
  private ServiceEntidad serviceEntidad;

  @GetMapping("")
  @ResponseStatus(HttpStatus.OK)
  public List<EntidadResponse> getAllEntidad() {
    return serviceEntidad.getAllEntidad();
  }

  @GetMapping("/page/{page}")
  @ResponseStatus(HttpStatus.OK)
  public Page<EntidadResponse> getAllEntidadPage(@PathVariable Integer page) {
    return serviceEntidad.getAllEntidadPage(page);
  }

  @GetMapping("/find/{id}")
  @ResponseStatus(HttpStatus.OK)
  public EntidadResponse getEntidadById(@PathVariable Integer id) {
    return serviceEntidad.getEntidadById(id);
  }

  @GetMapping("/find/documento/{nroDocumento}")
  @ResponseStatus(HttpStatus.OK)
  public EntidadResponse getTipoDocumentoByNroDocumento(@PathVariable String nroDocumento){
    return serviceEntidad.getEntidadByNroDocumento(nroDocumento);
  }

  @GetMapping("/find/information/{information}")
  @ResponseStatus(HttpStatus.OK)
  public List<EntidadResponse> getTipoDocumentoByInformation(@PathVariable String information){
    return serviceEntidad.getEntidadByInformation(information);
  }

  @PutMapping("/add")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Object> saveEntidad(@Valid @RequestBody EntidadRequest entidadRequest) {
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(serviceEntidad.saveEntidad(entidadRequest));
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEntidad(@PathVariable Integer id) {
    serviceEntidad.deleteEntidad(id);
  }

  @PostMapping("/update/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Object> updateEntidad(@Valid @RequestBody EntidadRequestUpdate entidadRequestUpdate, @PathVariable Integer id) {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(serviceEntidad.updateEntidad(id, entidadRequestUpdate));
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}
