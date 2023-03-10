package com.jorgetargz.graphql_server.spring.controllers;

import com.jorgetargz.graphql_server.domain.modelo.Encargado;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import com.jorgetargz.graphql_server.domain.services.EncargadoServices;
import com.jorgetargz.graphql_server.domain.services.ParadaServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EncargadoController {

    private final ParadaServices paradaServices;
    private final EncargadoServices encargadoServices;

    public EncargadoController(ParadaServices paradaServices, EncargadoServices encargadoServices) {
        this.paradaServices = paradaServices;
        this.encargadoServices = encargadoServices;
    }

    @SchemaMapping
    public Parada parada(Encargado encargado) {
        return paradaServices.getParadaByEncargadoId(encargado.getId());
    }

    @QueryMapping
    public List<Encargado> allEncargados() {
        return encargadoServices.getEncargados();
    }

    @QueryMapping
    public Encargado encargado(@Argument int id) {
        return encargadoServices.getEncargadoById(id);
    }

    @MutationMapping
    public Encargado createEncargado(@Argument String nombre, @Argument String dni) {
        Encargado encargado = new Encargado();
        encargado.setNombre(nombre);
        encargado.setDni(dni);
        return encargadoServices.createEncargado(encargado);
    }

    @MutationMapping
    public Encargado updateEncargado(@Argument Integer id, @Argument String nombre, @Argument String dni) {
        Encargado encargado = new Encargado();
        encargado.setId(id);
        encargado.setNombre(nombre);
        encargado.setDni(dni);
        return encargadoServices.updateEncargado(encargado);
    }

    @MutationMapping
    public void deleteEncargado(@Argument int id) {
        encargadoServices.deleteEncargadoById(id);
    }
}
