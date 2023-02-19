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
@Table(name = Constantes.ENCARGADOS_TABLE_NAME)
public class EncargadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String dni;

}
