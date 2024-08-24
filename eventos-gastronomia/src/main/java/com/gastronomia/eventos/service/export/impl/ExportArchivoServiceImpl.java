package com.gastronomia.eventos.service.export.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.service.export.ExportArchivoService;

public class ExportArchivoServiceImpl implements  ExportArchivoService{

    @Override
    public void exportarEventos(List<Evento> eventos, String rutaArchivo) {
    
        StringBuilder contenido = new StringBuilder();
        contenido.append("Listado de Eventos\n");
        contenido.append("====================\n\n");

        for (Evento evento : eventos) {
            contenido.append("Nombre del Evento: ").append(evento.getNombreEvento()).append("\n");
            contenido.append("Descripción: ").append(evento.getDecripEvento()).append("\n");
            contenido.append("Fecha y Hora: ").append(evento.getFechaHora()).append("\n");
            contenido.append("Ubicación: ").append(evento.getUbicacion()).append("\n");
            contenido.append("Participantes inscriptos: ").append(evento.getCapacidad()).append("\n");
            contenido.append("\n-----------------------\n\n");
        }

        try {
            Path path = Paths.get(rutaArchivo);
            Files.write(path, contenido.toString().getBytes());
            System.out.println("Archivo exportado exitosamente a: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    

}
