package com.jorgetargz.graphql_server.dao.common;

public class Constantes {

    public static final String ENCARGADOS_TABLE_NAME = "encargados";
    public static final String LINEAS_TABLE_NAME = "lineas";
    public static final String PARADAS_TABLE_NAME = "paradas";
    public static final String SELECT_PARADAS_BY_LINEA_QUERY = "SELECT p FROM ParadaEntity p WHERE p.idLinea = ?1";
    public static final String SELECT_ENCARGADO_BY_LINEA_QUERY = "SELECT p FROM ParadaEntity p WHERE p.idEncargado = ?1";

    private Constantes() {
    }
}
