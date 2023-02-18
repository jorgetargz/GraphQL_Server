package com.jorgetargz.graphql_server.dao;

import com.jorgetargz.graphql_server.dao.modelo.ParadaEntity;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParadaRepository extends JpaRepository<ParadaEntity, Integer> {

    @Query("SELECT p FROM ParadaEntity p WHERE p.idLinea = ?1")
    List<ParadaEntity> findAllByLineaId(int idLinea);

    @Query("SELECT p FROM ParadaEntity p WHERE p.idEncargado = ?1")
    Parada findByEncargadoId(Integer id);
}
