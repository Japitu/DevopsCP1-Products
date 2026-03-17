package br.com.fiap.resource;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/produto")

public class ProdutoResource {
    private ProdutoBO produtoBO = new ProdutoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ProdutoTO> resultado = produtoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        ProdutoTO resultado = produtoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ProdutoTO produto) {
        ProdutoTO result = produtoBO.save(produto);
        Response.ResponseBuilder responseBuilder = null;
        if (result != null) {
            responseBuilder = Response.created(null);
        } else {
            responseBuilder = Response.status(400);
        }
        responseBuilder.entity(result);
        return  responseBuilder.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (produtoBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@Valid ProdutoTO produto, @PathParam("id") Long id) {
        produto.setId(id);
        ProdutoTO result = produtoBO.update(produto);
        Response.ResponseBuilder response = null;
        if (result != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(result);
        return response.build();
    }

}
