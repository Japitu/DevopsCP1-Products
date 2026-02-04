package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.ServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/cliente")

public class ClienteResouce {
    private ClienteBO clienteBO = new ClienteBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ClienteTO cliente) {
        try {
            ClienteTO result = clienteBO.save(cliente);
            Response.ResponseBuilder responseBuilder = null;
            if (result != null) {
                responseBuilder = Response.created(null);
            } else {
                responseBuilder = Response.status(400);
            }
            responseBuilder.entity(result);
            return responseBuilder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update (@Valid ClienteTO cliente, @PathParam("id") Long id) {
        try {
            cliente.setId(id);
            ClienteTO result = clienteBO.update(cliente);
            Response.ResponseBuilder responseBuilder = null;
            if (result!= null) {
                responseBuilder = Response.created(null);
            } else {
                responseBuilder = Response.status(400);
            }
            responseBuilder.entity(result);
            return responseBuilder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder responseBuilder = null;
        if(clienteBO.delete(id)) {
            responseBuilder = Response.status(204);
        } else {
            responseBuilder = Response.status(404);
        }
        return responseBuilder.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ClienteTO> resultado = clienteBO.findAll();
        Response.ResponseBuilder responseBuilder = null;
        if(resultado != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(resultado);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        ClienteTO result = clienteBO.findById(id);
        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

}
