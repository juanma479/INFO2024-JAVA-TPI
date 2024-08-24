package com.gastronomia.eventos.service.export;

import java.util.List;

import com.gastronomia.eventos.domain.Evento;

public interface ExportArchivoService {

    void exportarEventos(List<Evento> eventos, String rutaArchivo);
}
