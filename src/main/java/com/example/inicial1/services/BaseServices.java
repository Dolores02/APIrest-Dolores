package com.example.inicial1.services;

import java.util.List;

public interface BaseServices<E>{
    public List<E> findAll() throws Exception; //lista de todas las E en base de datos
    public E findById(Long id) throws Exception; //buscar por ID
    public E save(E entity) throws Exception; //crear nueva entidad
    public E update(Long id, E entity) throws Exception; //actualizar entidad
    public boolean delete(Long id) throws Exception; //eliminar registro de la base de datos
}
