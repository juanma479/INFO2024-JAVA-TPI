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
        
        System.out.println("Gestión de Eventos de Cocina y Gastronomía");
        System.out.println("1. Crear Evento");
        System.out.println("2. Asignar Chef");
        System.out.println("3. Inscribir Participante");
        System.out.println("4. Escribir una Reseña");
        System.out.println("5. Consultar Eventos Disponibles");
        System.out.println("6. Exportar info de Eventos sin cupo.");
        System.out.println("7. Salir");
    }

    @Override
    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearEvento(scanner);
            case 2 -> asignarChef();
            case 3 -> incribirParticipante();
            case 4 -> escribirResena();
            case 5 -> listarEventosDisponibles(scanner);
            case 6 -> exportarArchivo();
            case 7 -> {
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

    private Object asignarChef() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarChef'");
    }


    private Object incribirParticipante() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incribirParticipante'");
    }


    private Object escribirResena() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'escribirResena'");
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

    private Object exportarArchivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarArchivo'");
    }

}
