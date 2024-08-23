package com.gastronomia.eventos.service.sistema.impl;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Sistema;
import com.gastronomia.eventos.service.sistema.SistemaService;

public class SistemaServiceImpl implements SistemaService {

    // Instancia de la clase Sistema
    private Sistema sistema;

    
    //Getter para sistema
    public Sistema getSistema() {
        return sistema;
    }

    @Override
    public void iniciarSistema() {
        // Inicializar el sistema
        sistema = new Sistema();

        // Mensaje de confirmación
        System.out.println("Sistema de Gestión de Eventos de Cocina y Gastronomía iniciado correctamente.");
    }

    @Override
    public void agregarEvento(String nombreEvento, Evento evento) {
        sistema.agregarEvento(nombreEvento, evento);
    }

    @Override
    public List<Evento> listarEventosDisponibles(Scanner scanner) {
        //Solicitamos una fecha de refrencia
        System.out.println("Ingrese una fecha en formato (dd-MM-yyyy):");
        String fechaStr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaStr, formatter);
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido. Por favor use el formato (dd-MM-yyyy).");
            return List.of(); // Devuelve una lista vacía en caso de error
        }

        // Filtra los eventos según la fecha y la capacidad
        return sistema.getEventos().values().stream()
            .filter(evento -> evento.getFechaHora().toLocalDate().isEqual(fecha) &&
                evento.getParticipantes().size() < evento.getCapacidad())
            .collect(Collectors.toList());
    
    }

    @Override
    public List<Evento> listarEventosNoDisponibles(Scanner scanner) {
        //Solicitamos una fecha de refrencia
        System.out.println("Ingrese una fecha en formato (dd-MM-yyyy):");
        String fechaStr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaStr, formatter);
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido. Por favor use el formato (dd-MM-yyyy).");
            return List.of(); // Devuelve una lista vacía en caso de error
        }

        // Filtra los eventos según la fecha y la capacidad
        return sistema.getEventos().values().stream()
            .filter(evento -> evento.getFechaHora().toLocalDate().isEqual(fecha) &&
                evento.getParticipantes().size() == evento.getCapacidad())
            .collect(Collectors.toList());
    }


    

}


    // public List<Evento> listarEventos() {
    //     // Convierte el mapa de eventos a una lista de eventos
    //     return sistema.getEventos().values().stream().collect(Collectors.toList());
    // }

   