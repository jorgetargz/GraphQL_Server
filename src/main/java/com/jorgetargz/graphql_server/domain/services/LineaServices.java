package com.jorgetargz.graphql_server.domain.services;

import com.jorgetargz.graphql_server.dao.LineaRepository;
import com.jorgetargz.graphql_server.dao.mappers.LineaMapper;
import com.jorgetargz.graphql_server.domain.excepciones.NotFoundException;
import com.jorgetargz.graphql_server.domain.modelo.Linea;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaServices {

    private final LineaRepository lineaRepository;
    private final LineaMapper lineaMapper;

    public LineaServices(LineaRepository lineaRepository, LineaMapper lineaMapper) {
        this.lineaRepository = lineaRepository;
        this.lineaMapper = lineaMapper;
    }

    public List<Linea> getLineas() {
        List<Linea> lineas = lineaRepository.findAll().stream()
                .map(lineaMapper::toLinea)
                .toList();
        if (lineas.isEmpty()) {
            throw new NotFoundException("No hay lineas");
        }
        return lineas;
    }

    public Linea getLineaById(int id) {
        return lineaMapper.toLinea(lineaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Linea no encontrada")));
    }

    public Linea createLinea(Linea linea) {
        return lineaMapper.toLinea(lineaRepository.save(lineaMapper.toLineaEntity(linea)));
    }

    public Linea updateLinea(Linea linea) {
        return lineaMapper.toLinea(lineaRepository.save(lineaMapper.toLineaEntity(linea)));
    }

    public void deleteLineaById(int id) {
        lineaRepository.deleteById(id);
    }
}
