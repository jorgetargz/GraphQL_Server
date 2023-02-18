package com.jorgetargz.graphql_server.domain.modelo;

import lombok.Data;

@Data
public class Parada {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer idEncargado;
    private Integer idLinea;
}
