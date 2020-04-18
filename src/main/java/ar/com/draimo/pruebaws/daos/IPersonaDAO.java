/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.draimo.pruebaws.daos;

import ar.com.draimo.pruebaws.models.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agus
 */

// Dao es lo que se conecta con la base de datos
// Y va a llevar metodos los cuales no tienen cuerpo. Aunque aceptan parametros.
// En Integer va el tipo de dato de la id de la DB. La cual es de tipo int, pero al pasarle Integer le estamos pasando un objeto
// Y el segundo, va el nombre de la clase del modelo a la que se tiene que referenciar.
// En el DAO estableces tus propios metodos ademas de los que extiende gracias a JPA repository
@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Integer>{
    
    //Obtiene una persona por nombre
    public List<Persona> findByNombre(String nombre); // findByNombre puede anadirsele mas metodo metiendole al nombre, por ejemplo findByNombreAndApellidoOrderByDesc
    
}
