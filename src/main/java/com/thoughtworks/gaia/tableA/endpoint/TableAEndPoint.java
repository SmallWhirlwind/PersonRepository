package com.thoughtworks.gaia.tableA.endpoint;

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

    @Path("/{tableA_id}")
    @ApiOperation(value = "Delete tableA by id", response = TableA.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete TableA successfully"),
            @ApiResponse(code = 404, message = "No TableA matches given id")
    })
    @DELETE
    public void deleteTableA(@PathParam("tableA_id") Long tableA_Id) {
        tableAService.deleteTableA(tableA_Id);

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
}
