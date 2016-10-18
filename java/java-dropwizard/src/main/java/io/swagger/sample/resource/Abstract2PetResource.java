package io.swagger.sample.resource;

import io.swagger.annotations.*;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.model.Pet;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Api(value = "/pet", description = "Operations about pets")
public abstract class Abstract2PetResource extends AbstractPetResource implements BaseResource {

    @ApiOperation(
            value = "Find pet by ID",
            notes = "Returns a pet when 0 < ID <= 10. ID > 10 or nonintegers will simulate API error conditions",
            response = Pet.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Pet not found") })
    public abstract Response getPetById(
            @ApiParam(value = "ID of pet that needs to be fetched", allowableValues = "range[1,10]", required = true) Long petId)
            throws NotFoundException;


    @ApiOperation(value = "Add a new pet to the store")
    @ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
    public abstract Response addPet(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true) Pet pet);



    @ApiOperation(value = "Update an existing pet")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Pet not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    public abstract Response updatePet(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true) Pet pet);


    @ApiOperation(
            value = "Finds Pets by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = Pet.class,
            responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid status value") })
    public abstract Response findPetsByStatus(
            @ApiParam(value = "Status values that need to be considered for filter", required = true, defaultValue = "available", allowableValues = "available,pending,sold", allowMultiple = true) @QueryParam("status") String status);



    @ApiOperation(
            value = "Finds Pets by tags",
            notes = "Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.",
            response = Pet.class,
            responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid tag value") })
    @Deprecated
    public abstract Response findPetsByTags(
            @ApiParam(value = "Tags to filter by", required = true, allowMultiple = true) @QueryParam("tags") String tags);
}
