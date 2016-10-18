/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.swagger.sample.resource;

import io.swagger.sample.data.PetData;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.model.Pet;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/pet")
//@Api(value = "/pet", description = "Operations about pets")
@Produces({"application/json"})
public class PetResource extends Abstract2PetResource {
	static PetData petData = new PetData();

//	@GET
//	@Path("/{petId}")
	public Response getPetById(
//			@PathParam("petId")
					Long petId)
			throws NotFoundException {
		test();
		Pet pet = petData.getPetById(petId);
		if (null != pet) {
			return Response.ok().entity(pet).build();
		} else {
			throw new NotFoundException(404, "Pet not found");
		}
	}

//	@POST
	public Response addPet(
			Pet pet) {
		petData.addPet(pet);
		return Response.ok().entity("SUCCESS").build();
	}

//	@PUT
	public Response updatePet(
			Pet pet) {
		petData.addPet(pet);
		return Response.ok().entity("SUCCESS").build();
	}

//	@GET
//	@Path("/findByStatus")
	public Response findPetsByStatus(
			String status) {
		return Response.ok(petData.findPetByStatus(status)).build();
	}

//	@GET
//	@Path("/findByTags")
	public Response findPetsByTags(
			String tags) {
		return Response.ok(petData.findPetByTags(tags)).build();
	}
}
