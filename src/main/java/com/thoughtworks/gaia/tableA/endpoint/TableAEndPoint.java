package com.thoughtworks.gaia.tableA.endpoint;

import com.thoughtworks.gaia.tableA.entity.Address;
import com.thoughtworks.gaia.tableA.entity.TableA;
import com.thoughtworks.gaia.tableA.service.TableAService;
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
 * Created by haoyuze on 2017/4/24.
 */
@Component
@Path("tableA")
@Api(value = "tableA", description = "Access to table_A resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TableAEndPoint {
    @Autowired
    private TableAService tableAService;

    @Path("/{tableA_id}")
    @ApiOperation(value = "Get tableA by id", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches given id")
    })
    @GET
    public Response getTableA(@PathParam("tableA_id") Long tableA_Id) {

        TableA tableA = tableAService.getTableA(tableA_Id);
        return Response.ok().entity(tableA).build();
    }

    @Path("/{tableA_id}/address/{address_id}")
    @ApiOperation(value = "Get tableA by id", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Address successfully"),
            @ApiResponse(code = 404, message = "No Address matches given id")
    })
    @GET
    public Response getAddressFromTableA(@PathParam("tableA_id") Long tableA_Id, @PathParam("address_id") Long address_Id) {

        Address address = tableAService.getAddressFromTableA(tableA_Id, address_Id);
        return Response.ok().entity(address).build();
    }

    @Path("/{tableA_id}")
    @ApiOperation(value = "Delete tableA by id", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Delete TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches given id")
    })
    @DELETE
    public void deleteTableA(@PathParam("tableA_id") Long tableA_Id) {
        tableAService.deleteTableA(tableA_Id);

    }

    @Path("/{tableA_id}/address/{address_id}")
    @ApiOperation(value = "upData tableA", response = Address.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "upData TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches")
    })
    @DELETE
    public void deleteTableA(@PathParam("tableA_id") Long tableAId, @PathParam("address_id") Long addressId) {
        Address address = tableAService.getAddressFromTableA(tableAId, addressId);
        if (address == null) {
            throw new NotFoundException();
        }
        tableAService.deleteAddress(addressId);
    }

    @Path("/")
    @ApiOperation(value = "Add tableA", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches")
    })
    @POST
    public Response addTableA(TableA tableA) {
        return Response.ok().entity(tableAService.addTableA(tableA)).build();
    }

    @Path("/{tableA_id}/address/")
    @ApiOperation(value = "Get tableA by id", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches given id")
    })
    @POST
    public Response addAddressFromTableA(@PathParam("tableA_id") Long tableA_Id, Address address) {

        return Response.ok().entity(tableAService.addAddressFromTableA(tableA_Id, address)).build();
    }

    @Path("/{tableA_id}")
    @ApiOperation(value = "upData tableA", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "upData TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches")
    })
    @PUT
    public Response upDataTableA(@PathParam("tableA_id") Long tableA_Id, TableA tableA) {
        tableA.setId(tableA_Id);
        return Response.ok().entity(tableAService.upDataTableA(tableA)).build();
    }

    @Path("/{table_id}/address/{address_id}")
    @ApiOperation(value = "upData tableA", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "upData TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches")
    })
    @PUT
    public Response upDataAddress(@PathParam("table_id") Long tableAId, @PathParam("address_id") Long addressId, Address address) {
        address.setId(addressId);
        address.setAid(tableAId);
        return Response.ok().entity(tableAService.upDataAddress(address)).build();
    }

}
