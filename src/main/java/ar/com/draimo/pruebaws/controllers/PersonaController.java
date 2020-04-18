/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.draimo.pruebaws.controllers;

import ar.com.draimo.pruebaws.models.Persona;
import ar.com.draimo.pruebaws.services.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agus
 */
@RestController
public class PersonaController {
    
    // Para hacerlo constante ponemos final
    private final String URL = "/pruebaws/persona";
    
    @Autowired
    PersonaService personaService;
    
    @GetMapping(value = URL + "/obtenerPorNombre/{nombre}")
    @ResponseBody
    public List<Persona> obtenerPorNombre(@PathVariable String nombre) {
        return personaService.obtenerPorNombre(nombre);
    }
    
    @GetMapping(value = URL + "/listar")
    @ResponseBody
    public List<Persona> listar() {
        return personaService.listar();
    }
    
    // Agrega una persona
    @PostMapping(value = URL + "/agregar")
    //RequestBody dice que el parametro que le vamos a pasar viene en el cuerpo de la peticion
    public ResponseEntity<?> agregar(@RequestBody Persona persona){
        try {
            Persona nuevaPersona = personaService.agregar(persona);
            // Primer parametro recibe cualquier cosa (cualquier tipo de dato) y el 2do parametro es el codigo de respuesta. De la clase HTTP status
           return new ResponseEntity(nuevaPersona, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity("No agregado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Actualiza una persona
    @PutMapping(value = URL + "/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Persona persona) {
        try {
            Persona nuevaPersona = personaService.actualizar(persona);
            return new ResponseEntity(nuevaPersona, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity("No actualizado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Elimina una persona por id
    @DeleteMapping(value = URL + "/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        try {
            personaService.eliminar(id);
            return new ResponseEntity("Eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No eliminado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
