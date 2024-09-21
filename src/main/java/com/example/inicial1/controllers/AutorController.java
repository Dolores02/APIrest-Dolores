package com.example.inicial1.controllers;


import com.example.inicial1.entities.Autor;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(Autor autor){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.save(autor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> update(Long id, Autor autor){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.update(id,autor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

}
