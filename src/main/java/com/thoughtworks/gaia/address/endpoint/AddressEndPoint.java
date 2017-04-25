package com.thoughtworks.gaia.address.endpoint;

import com.thoughtworks.gaia.address.service.AddressService;
import com.thoughtworks.gaia.address.entity.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
