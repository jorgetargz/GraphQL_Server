package com.jorgetargz.graphql_server.domain.services;

import com.jorgetargz.graphql_server.dao.ParadaRepository;
import com.jorgetargz.graphql_server.dao.mappers.ParadaMapper;
import com.jorgetargz.graphql_server.domain.excepciones.NotFoundException;
import com.jorgetargz.graphql_server.domain.modelo.Parada;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParadaServices {

    private final ParadaRepository paradaRepository;
    private final ParadaMapper paradaMapper;

    public ParadaServices(ParadaRepository paradaRepository, ParadaMapper paradaMapper) {
        this.paradaRepository = paradaRepository;
        this.paradaMapper = paradaMapper;
    }

    public List<Parada> getParadas() {
        List<Parada> paradas = paradaRepository.findAll().stream()
                .map(paradaMapper::toParada)
                .toList();
        if (paradas.isEmpty()) {
            throw new NotFoundException("No hay paradas");
        }
        return paradas;
    }

    public List<Parada> getParadasByLineaId(Integer id) {
        return paradaRepository.findAllByLineaId(id).stream()
                .map(paradaMapper::toParada)
                .toList();
    }

    public Parada getParadaByEncargadoId(Integer id) {
        return paradaRepository.findByEncargadoId(id);
    }

    public Parada getParadaById(int id) {
        return paradaMapper.toParada(paradaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Parada no encontrada")));
    }

    public Parada createParada(Parada parada) {
        return paradaMapper.toParada(paradaRepository.save(paradaMapper.toParadaEntity(parada)));
    }

    public Parada updateParada(Parada parada) {
        return paradaMapper.toParada(paradaRepository.save(paradaMapper.toParadaEntity(parada)));
    }

    public void deleteParadaById(int id) {
        paradaRepository.deleteById(id);
    }
}
