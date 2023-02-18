package com.jorgetargz.graphql_server.spring.controllers;

import com.jorgetargz.graphql_server.domain.modelo.Encargado;
import com.jorgetargz.graphql_server.domain.modelo.Linea;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import com.jorgetargz.graphql_server.domain.services.EncargadoServices;
import com.jorgetargz.graphql_server.domain.services.LineaServices;
import com.jorgetargz.graphql_server.domain.services.ParadaServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ParadaController {

    private final ParadaServices paradaServices;
    private final LineaServices lineaServices;
    private final EncargadoServices encargadoServices;

    public ParadaController(ParadaServices paradaServices, LineaServices lineaServices, EncargadoServices encargadoServices) {
        this.paradaServices = paradaServices;
        this.lineaServices = lineaServices;
        this.encargadoServices = encargadoServices;
    }

    @SchemaMapping
    public Linea linea(Parada parada) {
        return lineaServices.getLineaById(parada.getIdLinea());
    }

    @SchemaMapping
    public Encargado encargado(Parada parada) {
        return encargadoServices.getEncargadoById(parada.getIdEncargado());
    }

    @QueryMapping
    public List<Parada> allParadas() {
        return paradaServices.getParadas();
    }

    @QueryMapping
    public Parada parada(@Argument int id) {
        return paradaServices.getParadaById(id);
    }

    @MutationMapping
    public Parada createParada(@Argument String nombre, @Argument String direccion,
                               @Argument int encargadoId, @Argument int lineaId) {
        Parada parada = new Parada();
        parada.setNombre(nombre);
        parada.setDireccion(direccion);
        parada.setIdEncargado(encargadoId);
        parada.setIdLinea(lineaId);
        return paradaServices.createParada(parada);
    }

    @MutationMapping
    public Parada updateParada(@Argument Integer id, @Argument String nombre, @Argument String direccion,
                               @Argument int encargadoId, @Argument int lineaId) {
        Parada parada = new Parada();
        parada.setId(id);
        parada.setNombre(nombre);
        parada.setDireccion(direccion);
        parada.setIdEncargado(encargadoId);
        parada.setIdLinea(lineaId);
        return paradaServices.updateParada(parada);
    }

    @MutationMapping
    public void deleteParada(@Argument int id) {
        paradaServices.deleteParadaById(id);
    }

}