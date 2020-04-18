/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.draimo.pruebaws.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Agus
 */

// A traves del model se establece un modelo de la base de datos. Tiene que ser mirrored a la DB.
@Entity
@Table(name="persona")
public class Persona extends ObjetoGenerico {
    
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
    
    // Referencia a la clase ciudad
    //Cascada es como se van a hacer las insersiones 
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCiudad", nullable = false)
    private Ciudad ciudad;
    
    // Metodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
