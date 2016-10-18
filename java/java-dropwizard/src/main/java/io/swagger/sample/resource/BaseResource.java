package io.swagger.sample.resource;

import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.model.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//@Api(value = "/pet", description = "Operations about pets")
public interface BaseResource {

    @GET
    @Path("/{petId}")
    Response getPetById(
            @PathParam("petId") Long petId)
            throws NotFoundException;

    @POST
    Response addPet(
            Pet pet);

    @PUT
    Response updatePet(
            Pet pet);

    @GET
    @Path("/findByStatus")
    Response findPetsByStatus(
            String status);

    @GET
    @Path("/findByTags")
    Response findPetsByTags(
            String tags);
}
