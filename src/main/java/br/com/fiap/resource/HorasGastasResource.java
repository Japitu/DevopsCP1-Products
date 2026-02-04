package br.com.fiap.resource;

import br.com.fiap.bo.HorasGastasBO;
import br.com.fiap.to.HorasGastasTO;
import br.com.fiap.to.ServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/horas")

public class HorasGastasResource {
    private HorasGastasBO horasGastasBO = new HorasGastasBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (@Valid HorasGastasTO horario) {
        try {
            HorasGastasTO result = horasGastasBO.save(horario);
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
    public Response update (@Valid HorasGastasTO horario, @PathParam("id") Long id) {
        try {
            horario.setId(id);
            HorasGastasTO result = horasGastasBO.update(horario);
            Response.ResponseBuilder responseBuilder = null;
            if(result != null) {
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
        if(horasGastasBO.delete(id)) {
            responseBuilder = Response.status(204);
        } else {
            responseBuilder = Response.status(404);
        }
        return responseBuilder.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<HorasGastasTO> result = horasGastasBO.findAll();
        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        HorasGastasTO result = horasGastasBO.findById(id);
        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

    @GET
    @Path("/servico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByServico(@PathParam("id") Long id) {
        ArrayList<HorasGastasTO> result = horasGastasBO.findByServico(id);
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
