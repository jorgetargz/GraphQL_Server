package com.jorgetargz.graphql_server.dao;

import com.jorgetargz.graphql_server.dao.modelo.EncargadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargadoRepository extends JpaRepository<EncargadoEntity, Integer> {
}
