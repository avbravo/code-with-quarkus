package org.acme;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.acme.model.Persona;
import org.acme.repository.PersonaRepository;

@Path("/persona")
public class PersonaController {

    @Inject
    PersonaRepository personaRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @GET
    @Path("{idpersona}")
    public Persona queryById(@PathParam("idpersona") String idpersona) {
        return personaRepository.queryIdpersona(idpersona).orElseThrow(
                () -> new WebApplicationException("No hay persona con el id " + idpersona, Response.Status.NOT_FOUND));
    }
    
    @GET
    @Path("/find/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona findByNombre(@PathParam("nombre") String nombre ){
        return personaRepository.findByNombre(nombre).orElseThrow(
                () -> new WebApplicationException("No hay persona con el nombre " + nombre, Response.Status.NOT_FOUND));
    }

    @GET
    @Path("/ping")
    public Boolean ping() {
        return personaRepository.ping().booleanValue();
    }
    
    @POST
    public Response save(Persona persona) {
        return Response.status(Response.Status.CREATED).entity(personaRepository.save(persona)).build();
    }

    @DELETE
    @Path("{idpersona}")
    public Response delete(@PathParam("idpersona") String idpersona) {
      personaRepository.deleteByPk(idpersona);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
