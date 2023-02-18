package com.jorgetargz.graphql_server.domain.services;

import com.jorgetargz.graphql_server.dao.EncargadoRepository;
import com.jorgetargz.graphql_server.dao.mappers.EncargadoMapper;
import com.jorgetargz.graphql_server.domain.excepciones.NotFoundException;
import com.jorgetargz.graphql_server.domain.modelo.Encargado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncargadoServices {

    private final EncargadoRepository encargadoRepository;
    private final EncargadoMapper encargadoMapper;

    public EncargadoServices(EncargadoRepository encargadoRepository, EncargadoMapper encargadoMapper) {
        this.encargadoRepository = encargadoRepository;
        this.encargadoMapper = encargadoMapper;
    }

    public List<Encargado> getEncargados() {
        List<Encargado> encargados = encargadoRepository.findAll().stream()
                .map(encargadoMapper::toEncargado)
                .toList();
        if (encargados.isEmpty()) {
            throw new NotFoundException("No hay encargados");
        }
        return encargados;
    }

    public Encargado getEncargadoById(int id) {
        return encargadoMapper.toEncargado(encargadoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Encargado no encontrado")));
    }

    public Encargado createEncargado(Encargado encargado) {
        return encargadoMapper.toEncargado(encargadoRepository.save(encargadoMapper.toEncargadoEntity(encargado)));
    }

    public Encargado updateEncargado(Encargado encargado) {
        return encargadoMapper.toEncargado(encargadoRepository.save(encargadoMapper.toEncargadoEntity(encargado)));
    }

    public void deleteEncargadoById(int id) {
        encargadoRepository.deleteById(id);
    }
}
