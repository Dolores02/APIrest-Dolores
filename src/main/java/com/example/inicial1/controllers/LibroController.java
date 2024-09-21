package com.example.inicial1.controllers;


import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Libro;
import com.example.inicial1.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(Libro libro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.save(libro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> update(Long id, Libro libro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.update(id,libro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(libroService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}