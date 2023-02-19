package com.jorgetargz.graphql_server.dao.modelo;

import com.jorgetargz.graphql_server.dao.common.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

@Entity
@Table(name = Constantes.PARADAS_TABLE_NAME)
public class ParadaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Integer idEncargado;

    @Column(nullable = false)
    private Integer idLinea;

}