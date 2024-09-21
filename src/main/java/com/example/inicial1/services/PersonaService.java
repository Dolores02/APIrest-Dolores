package com.example.inicial1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

@Service //notacion para indicar que es un servicio
public class PersonaService implements BaseServices<Persona>{

    @Autowired
    private PersonaRepository personaRepository;

    // public PersonaService(PersonaRepository personaRepository){ //hace el constructor
    //  this.personaRepository = personaRepository;
    // } // Spring se encarga de encontrar por si solo las dependencias, nos solo lo declaramos, entonces usamos la notacion @AutoWired

    @Override
    @Transactional //con esto nos ahorramos hacer el em.GetTransaction().Begin() y el commit, etc....
    public List<Persona> findAll() throws Exception {

        try {
            List<Persona> entities = personaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entitiyOptional = personaRepository.findById(id); // Optional pq no sabemos si ese ID esta en la Base de Datos
            return entitiyOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona  = personaRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
