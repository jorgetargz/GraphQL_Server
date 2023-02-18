package com.jorgetargz.graphql_server.dao.mappers;

import com.jorgetargz.graphql_server.dao.modelo.LineaEntity;
import com.jorgetargz.graphql_server.domain.modelo.Linea;
import org.springframework.stereotype.Component;

@Component
public class LineaMapper {

    public Linea toLinea(LineaEntity lineaEntity) {
        Linea linea = new Linea();
        linea.setId(lineaEntity.getId());
        linea.setNumero(lineaEntity.getNumero());
        linea.setTipo(lineaEntity.getTipo());
        return linea;
    }

    public LineaEntity toLineaEntity(Linea linea) {
        LineaEntity lineaEntity = new LineaEntity();
        lineaEntity.setId(linea.getId());
        lineaEntity.setNumero(linea.getNumero());
        lineaEntity.setTipo(linea.getTipo());
        return lineaEntity;
    }
}
