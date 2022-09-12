/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import java.util.Optional;
import org.acme.model.Persona;

/**
 *
 * @author avbravo
 */
@Repository(entity = Persona.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PersonaRepository extends CrudRepository<Persona, String> {

    @Query(where = "idpersona .eq. @idpersona")
    public Optional<Persona> queryIdpersona(String idpersona);

    @Ping
    public Boolean ping();
    
    @Find
    public Optional<Persona> findByNombre(String nombre);
}
