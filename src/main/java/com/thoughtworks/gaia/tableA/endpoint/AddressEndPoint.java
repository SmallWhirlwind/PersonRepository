package com.thoughtworks.gaia.tableA.endpoint;

import com.thoughtworks.gaia.tableA.service.AddressService;
import com.thoughtworks.gaia.tableA.entity.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by haoyuze on 2017/4/25.
 */
@Component
@Path("address")
@Api(value = "address", description = "Access to address resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressEndPoint {
    @Autowired
    private AddressService addressService;

    @Path("/")
    @ApiOperation(value = "Add Address", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add Address successfully"),
            @ApiResponse(code = 404, message = "No Address matches")
    })
    @POST
    public Response addAddress(Address address) {
        return Response.ok().entity(addressService.addAddress(address)).build();
    }

    @Path("/{address_id}")
    @ApiOperation(value = "Add Address", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add Address successfully"),
            @ApiResponse(code = 404, message = "No Address matches")
    })
    @GET
    public Response getAddress(@PathParam("address_id") Long address_Id) {
        return Response.ok().entity(addressService.getAddress(address_Id)).build();
    }

    @Path("/{address_id}")
    @ApiOperation(value = "Delete tableA by id", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches given id")
    })
    @DELETE
    public void deleteTableA(@PathParam("address_id") Long address_Id) {
        addressService.deleteAddress(address_Id);
    }

    @Path("/{address_id}")
    @ApiOperation(value = "upData tableA", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "upData TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches")
    })
    @PUT
    public Response upDataTableA(@PathParam("address_id") Long address_Id, Address address) {
        address.setId(address_Id);
        return Response.ok().entity(addressService.upDataAddress(address)).build();
    }

}
