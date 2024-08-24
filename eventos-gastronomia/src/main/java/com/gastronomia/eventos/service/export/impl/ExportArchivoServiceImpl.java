package com.gastronomia.eventos.service.export.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.service.export.ExportArchivoService;
import com.opencsv.CSVWriter;

public class ExportArchivoServiceImpl implements ExportArchivoService {

    // Definir la ubicación del archivo como el escritorio del usuario
    private final String UBICACION_DESKTOP = System.getProperty("user.home") + "\\Desktop\\";

    private CSVWriter csvWriter;

    @Override
    public void exportarEventos(List<Evento> eventos) {

        // Generar la ruta completa del archivo
        String ruta = Paths.get(UBICACION_DESKTOP, "eventos_exportados.csv").toString();

        try {
            this.csvWriter = new CSVWriter(new FileWriter(ruta));

            // Agregar un encabezado o mensaje informativo inicial
            String[] mensajeInicial = {"*** Folleto Informativo de Eventos ***"};
            this.csvWriter.writeNext(mensajeInicial);

            // Crear el encabezado de las columnas
            String[] encabezado = {"ID", "Nombre", "Fecha y Hora", "Capacidad", "Descripción"};
            this.csvWriter.writeNext(encabezado);

            // Escribir cada evento en una línea del archivo CSV
            for (Evento evento : eventos) {
                String[] datos = {
                    evento.getIdEvento().toString(),
                    evento.getNombreEvento(),
                    evento.getFechaHora().toString(),
                    String.valueOf(evento.getCapacidad()),
                    evento.getDecripEvento()
                };
                this.csvWriter.writeNext(datos);
            }

            // Confirmar la exportación exitosa
            System.out.println("Exportación exitosa. Archivo guardado en: " + ruta);

        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage().concat(" Ubicación archivo: " + ruta));
        } finally {
            cerrarWriter();
        }
    }


    @Override
    public void cerrarWriter() {
        if (this.csvWriter != null) {
            try {
                this.csvWriter.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el CSVWriter: " + e.getMessage());
            }
        }
    }

}
