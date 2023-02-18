package com.jorgetargz.graphql_server.dao.mappers;

import com.jorgetargz.graphql_server.dao.modelo.EncargadoEntity;
import com.jorgetargz.graphql_server.domain.modelo.Encargado;
import org.springframework.stereotype.Component;

@Component
public class EncargadoMapper {

    public Encargado toEncargado(EncargadoEntity encargadoEntity) {
        Encargado encargado = new Encargado();
        encargado.setId(encargadoEntity.getId());
        encargado.setNombre(encargadoEntity.getNombre());
        encargado.setDni(encargadoEntity.getDni());
        return encargado;
    }

    public EncargadoEntity toEncargadoEntity(Encargado encargado) {
        EncargadoEntity encargadoEntity = new EncargadoEntity();
        encargadoEntity.setId(encargado.getId());
        encargadoEntity.setNombre(encargado.getNombre());
        encargadoEntity.setDni(encargado.getDni());
        return encargadoEntity;
    }
}
