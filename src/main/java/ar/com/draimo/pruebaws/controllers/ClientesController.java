/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.draimo.pruebaws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agus
 */
@RestController
public class ClientesController {
    // Recibe la ruta y retorna algo -- Template basica
    @GetMapping(value = "/test/obtenerClientes")
    @ResponseBody
    public String obtenerNombre() {
        return "En esta direccion se retorna a Juan";
    }
    
}
