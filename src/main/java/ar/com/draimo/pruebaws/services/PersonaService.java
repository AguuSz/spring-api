/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.draimo.pruebaws.services;

import ar.com.draimo.pruebaws.daos.IPersonaDAO;
import ar.com.draimo.pruebaws.models.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agus
 */
// El service es el encargado de toda la business logic que sean necesarias antes de retornar algo
@Service
public class PersonaService {
    
    @Autowired
    // Instancia de IPersonaDAO -- y se hace porque no te deja hacer new de una interfaz.
    IPersonaDAO personaDAO;
    
    //Obtiene una persona por nombre
    public List<Persona> obtenerPorNombre(String nombre) {
        return personaDAO.findByNombre(nombre);
    }
    
    //Obtiene la lista completa de registros
    public List<Persona> listar() {
        return personaDAO.findAll();
    }
    
    //Agrega una persona
    @Transactional(rollbackFor = Exception.class) // Lo prepara en caso de que haya un error para manejarlo.
    public Persona agregar(Persona persona) {
        return personaDAO.saveAndFlush(persona);
    }
    
    //Actualiza un registro
    // Si bien es lo mismo que en el metodo agregar, la diferencia radica que cuando se llame el PostMapping
    // Este va a pasar tambien una ID, que Spring al verlo sabe que tiene que actualizar un registro y no anadir uno.
    @Transactional(rollbackFor = Exception.class)
    public Persona actualizar(Persona persona) {
        return personaDAO.saveAndFlush(persona);
    }
    
    //Elimina un registro
    @Transactional(rollbackFor = Exception.class)
    public void eliminar (int id) {
        // Persona persona - personaDAO.findById(id).get();  -- El .get() es importante, ya que sino nos retornaria un optional.
        personaDAO.deleteById(id);
    }
}
