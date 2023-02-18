package com.jorgetargz.graphql_server.spring.controllers;

import com.jorgetargz.graphql_server.domain.modelo.Linea;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import com.jorgetargz.graphql_server.domain.services.LineaServices;
import com.jorgetargz.graphql_server.domain.services.ParadaServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LineaController {

    private final LineaServices lineaServices;
    private final ParadaServices paradaServices;

    public LineaController(LineaServices lineaServices, ParadaServices paradaServices) {
        this.lineaServices = lineaServices;
        this.paradaServices = paradaServices;
    }

    @QueryMapping
    public List<Linea> allLineas() {
        return lineaServices.getLineas();
    }

    @QueryMapping
    public Linea linea(@Argument int id) {
        return lineaServices.getLineaById(id);
    }

    @SchemaMapping
    public List<Parada> paradas(Linea linea) {
        return paradaServices.getParadasByLineaId(linea.getId());
    }

    @MutationMapping
    public Linea createLinea(@Argument int numero, @Argument String tipo) {
        Linea linea = new Linea();
        linea.setNumero(numero);
        linea.setTipo(tipo);
        return lineaServices.createLinea(linea);
    }

    @MutationMapping
    public Linea updateLinea(@Argument int id, @Argument int numero, @Argument String tipo) {
        Linea linea = new Linea();
        linea.setId(id);
        linea.setNumero(numero);
        linea.setTipo(tipo);
        return lineaServices.updateLinea(linea);
    }

    @MutationMapping
    public void deleteLinea(@Argument int id) {
        lineaServices.deleteLineaById(id);
    }

}
