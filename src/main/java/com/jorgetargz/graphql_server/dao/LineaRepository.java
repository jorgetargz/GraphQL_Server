package com.jorgetargz.graphql_server.dao;

import com.jorgetargz.graphql_server.dao.modelo.LineaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaRepository extends JpaRepository<LineaEntity, Integer> {
}
