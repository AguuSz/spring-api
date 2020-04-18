/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.draimo.pruebaws.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Agus
 */

@Entity
@Table(name = "ciudad")
public class Ciudad extends ObjetoGenerico {
    
    //Define el nombre de la ciudad
    
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
    
