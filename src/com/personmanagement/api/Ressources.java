package com.personmanagement.api;

import com.personmanagement.entities.Person;
import com.personmanagement.service.Service;
import javax.ws.rs.core.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Ressources {

    private Service service = new Service();

    @GET
    public List<Person> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Person getById(@PathParam("id") int id) {
        return service.getById(id);
    }

    @POST
    public Response create(Person p) {
        try {
            System.out.println("Received person: " + p);
            service.create(p);
            return Response.status(Response.Status.CREATED).entity(p).build();

        } catch (Exception e) {
            e.printStackTrace(); // <-- THIS prints the real reason
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, Person p) {
        p.setId(id);
        service.update(p);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        service.delete(id);
    }

    @OPTIONS
    @Path("/{id}")
    public Response options(@PathParam("id") int id) {
        return Response.ok().build();
    }

    @OPTIONS
    public Response options() {
        return Response.ok().build();
    }
}