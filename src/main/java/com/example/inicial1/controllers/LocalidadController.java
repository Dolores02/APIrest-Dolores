package com.example.inicial1.controllers;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Localidad;
import com.example.inicial1.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController {
    @Autowired
    private LocalidadService localidadService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(Localidad localidad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.save(localidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> update(Long id, Localidad localidad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.update(id,localidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(localidadService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

}
