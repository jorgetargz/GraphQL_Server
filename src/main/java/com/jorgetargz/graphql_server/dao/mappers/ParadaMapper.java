package com.jorgetargz.graphql_server.dao.mappers;

import com.jorgetargz.graphql_server.dao.modelo.ParadaEntity;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import org.springframework.stereotype.Component;

@Component
public class ParadaMapper {

    public Parada toParada(ParadaEntity paradaEntity) {
        Parada parada = new Parada();
        parada.setId(paradaEntity.getId());
        parada.setNombre(paradaEntity.getNombre());
        parada.setDireccion(paradaEntity.getDireccion());
        parada.setIdEncargado(paradaEntity.getIdEncargado());
        parada.setIdLinea(paradaEntity.getIdLinea());
        return parada;
    }

    public ParadaEntity toParadaEntity(Parada parada) {
        ParadaEntity paradaEntity = new ParadaEntity();
        paradaEntity.setId(parada.getId());
        paradaEntity.setNombre(parada.getNombre());
        paradaEntity.setDireccion(parada.getDireccion());
        paradaEntity.setIdEncargado(parada.getIdEncargado());
        paradaEntity.setIdLinea(parada.getIdLinea());
        return paradaEntity;
    }
}
