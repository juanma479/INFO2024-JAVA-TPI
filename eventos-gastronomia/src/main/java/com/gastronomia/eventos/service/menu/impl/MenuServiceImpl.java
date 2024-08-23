package com.gastronomia.eventos.service.menu.impl;

import java.util.List;
import java.util.Scanner;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.service.evento.EventoService;
import com.gastronomia.eventos.service.menu.MenuService;
import com.gastronomia.eventos.service.sistema.SistemaService;

public class MenuServiceImpl implements MenuService{

    private final SistemaService sistemaService;
    private final EventoService eventoService; 
    private final Scanner scanner;

    public MenuServiceImpl(SistemaService sistemaService, EventoService eventoService, Scanner scanner) {
        this.sistemaService = sistemaService;
        this.eventoService = eventoService;
        this.scanner = scanner;
    }

    @Override
    public void mostrarMenu() {
        
        System.out.println("Sistema de Gestión de Eventos de Cocina y Gastronomía");
        System.out.println("1. Crear Evento");
        System.out.println("2. Listar Eventos");
        System.out.println("3. Salir");
    }

    @Override
    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearEvento(scanner);
            case 2 -> listarEventosDisponibles(scanner);
            case 3 -> {
                System.out.println("Saliendo del sistema.");
                System.exit(0);
            }
            default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    private void crearEvento(Scanner scanner) {
        Evento nuevoEvento = eventoService.crearEvento(scanner);
        String nombreEvento = nuevoEvento.getNombreEvento();
        sistemaService.agregarEvento(nombreEvento, nuevoEvento);

    }

    private void listarEventosDisponibles(Scanner scanner){
        List<Evento> eventos = sistemaService.listarEventosDisponibles(scanner);
    if (eventos.isEmpty()) {
        System.out.println("No hay eventos registrados.");
    } else { System.out.println("Eventos disponibles");
        eventos.forEach(evento -> {
            System.out.println("Nombre del Evento: " + evento.getNombreEvento() +
                               ", Descripción: " + evento.getDecripEvento());
            System.out.println("----------------------------------");
        });
        
    }
    }

}
