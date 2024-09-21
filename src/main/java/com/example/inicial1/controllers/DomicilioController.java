package com.example.inicial1.controllers;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.DomicilioRepository;
import com.example.inicial1.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(Domicilio domicilio){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.save(domicilio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> update(Long id, Domicilio domicilio){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.update(id,domicilio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(domicilioService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
