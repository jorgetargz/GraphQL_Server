package com.jorgetargz.graphql_server.dao;

import com.jorgetargz.graphql_server.dao.common.Constantes;
import com.jorgetargz.graphql_server.dao.modelo.ParadaEntity;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParadaRepository extends JpaRepository<ParadaEntity, Integer> {

    @Query(Constantes.SELECT_PARADAS_BY_LINEA_QUERY)
    List<ParadaEntity> findAllByLineaId(int idLinea);

    @Query(Constantes.SELECT_ENCARGADO_BY_LINEA_QUERY)
    Parada findByEncargadoId(Integer id);
}
