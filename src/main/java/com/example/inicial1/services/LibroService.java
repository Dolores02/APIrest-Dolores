package com.example.inicial1.services;
import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Libro;
import com.example.inicial1.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements BaseServices<Libro> {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() throws Exception {
        try{
            List<Libro> libros = libroRepository.findAll();
            return libros;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Libro findById(Long id) throws Exception {
        try{
            Optional<Libro> libroOptional = libroRepository.findById(id);
            return libroOptional.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Libro save(Libro entity) throws Exception {
        try{
            entity = libroRepository.save(entity);
            return entity;

        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Libro update(Long id, Libro entity) throws Exception {
        try{
            Optional<Libro> libroOptional = libroRepository.findById(id);
            Libro libro = libroOptional.get();
            libro = libroRepository.save(entity);
            return libro;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
                return true;
            } else { return false; }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
