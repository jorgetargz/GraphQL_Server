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
@Table(name = Constantes.LINEAS_TABLE_NAME)
public class LineaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String tipo;
}
