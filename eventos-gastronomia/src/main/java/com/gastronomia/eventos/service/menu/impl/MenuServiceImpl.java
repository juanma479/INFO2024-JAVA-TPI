package com.gastronomia.eventos.service.menu.impl;

import java.util.List;
import java.util.Scanner;

import com.gastronomia.eventos.domain.Chef;
import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.domain.Resena;
import com.gastronomia.eventos.service.chef.ChefService;
import com.gastronomia.eventos.service.evento.EventoService;
import com.gastronomia.eventos.service.export.ExportArchivoService;
import com.gastronomia.eventos.service.menu.MenuService;
import com.gastronomia.eventos.service.participante.ParticipanteService;
import com.gastronomia.eventos.service.resena.ResenaService;
import com.gastronomia.eventos.service.sistema.SistemaService;

public class MenuServiceImpl implements MenuService {

    private final SistemaService sistemaService;
    private final EventoService eventoService;
    private final ChefService chefService;
    private final ExportArchivoService exportArchivoService;
    private final ParticipanteService participanteService;
    private final ResenaService resenaService;
    private final Scanner scanner;

    public MenuServiceImpl(SistemaService sistemaService, EventoService eventoService,
            ChefService chefService, ParticipanteService participanteService,
            ExportArchivoService exportArchivoService, ResenaService resenaService,Scanner scanner) {

        this.sistemaService = sistemaService;
        this.eventoService = eventoService;
        this.chefService = chefService;
        this.exportArchivoService = exportArchivoService;
        this.participanteService = participanteService;
        this.resenaService = resenaService;
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
            case 2 -> asignarChef(scanner);
            case 3 -> inscribirParticipante(scanner);
            case 4 -> escribirResena(scanner);
            case 5 -> listarEventosDisponibles(scanner);
            case 6 -> exportarArchivo(scanner);
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


    private void asignarChef(Scanner scanner) {
        // Crear un nuevo chef
        Chef nuevoChef = chefService.crearChef(scanner);
    
        // Verificar si se creó correctamente el chef
        if (nuevoChef == null) {
            System.out.println("No se pudo crear el Chef. Operación cancelada.");
            return; // Salir del método si la creación del chef falló
        }
    
        // Solicitar el nombre del evento
        System.out.println("Ingrese el nombre del evento al que el Chef será asignado: ");
        String nombreEvento = scanner.nextLine().trim();
    
        // Obtener el evento del sistema
        Evento evento = sistemaService.obtenerEvento(nombreEvento);
    
        // Verificar si el evento existe
        if (evento == null) {
            System.out.println("El evento con el nombre '" + nombreEvento + "' no fue encontrado. Operación cancelada.");
            return; // Salir del método si el evento no existe
        }
    
        // Eliminar el evento del sistema antes de modificarlo
        sistemaService.eliminarEvento(nombreEvento);
    
        // Asignar el chef al evento
        eventoService.asignarChef(nuevoChef, evento);
    
        // Agregar nuevamente el evento modificado al sistema
        sistemaService.agregarEvento(nombreEvento, evento);
    
        System.out.println("El Chef " + nuevoChef.getNombreChef() + " ha sido asignado al evento " + nombreEvento + " exitosamente.");
    }

    
    private void inscribirParticipante(Scanner scanner) {
        // Crear un nuevo participante
        Participante nuevoParticipante = participanteService.crearParticipante(scanner);
    
        // Verificar si se creó correctamente el participante
        if (nuevoParticipante == null) {
            System.out.println("No se pudo crear el participante. Operación cancelada.");
            return; // Salir del método si la creación del participante falló
        }
    
        // Solicitar el nombre del evento
        System.out.println("Ingrese el nombre del evento al que desea inscribirse:");
        String nombreEvento = scanner.nextLine().trim();
    
        // Obtener el evento del sistema
        Evento evento = sistemaService.obtenerEvento(nombreEvento);
    
        // Verificar si el evento existe
        if (evento == null) {
            System.out.println("El evento con el nombre '" + nombreEvento + "' no fue encontrado. Operación cancelada.");
            return; // Salir del método si el evento no existe
        }
    
    
        // Eliminar el evento del sistema antes de modificarlo
        sistemaService.eliminarEvento(nombreEvento);
    
        // Inscribir el participante en el evento
        eventoService.inscribirParticipante(nuevoParticipante, evento);
    
        // Agregar nuevamente el evento modificado al sistema
        sistemaService.agregarEvento(nombreEvento, evento);
    
        System.out.println("Participante " + nuevoParticipante.getNombreParticipante() + " " + nuevoParticipante.getApellidoParticipante() + " inscrito exitosamente en el evento " + nombreEvento + ".");
    }
    

    private void escribirResena(Scanner scanner) {
        // Solicitar el nombre del autor de la reseña
        System.out.println("Escriba el nombre del autor de la reseña:");
        String nombreAutor = scanner.nextLine().trim();
    
        // Solicitar el nombre del evento
        System.out.println("Ingrese el nombre del evento sobre el que desea escribir:");
        String nombreEvento = scanner.nextLine().trim();
    
        // Obtener el evento del sistema
        Evento evento = sistemaService.obtenerEvento(nombreEvento);
    
        // Verificar si el evento existe
        if (evento == null) {
            System.out.println("El evento con el nombre '" + nombreEvento + "' no fue encontrado. Operación cancelada.");
            return; // Salir del método si el evento no existe
        }
    
        // Obtener al participante autor de la reseña
        Participante autor = eventoService.obtenerParticipante(nombreAutor, evento);
    
        // Verificar si el participante existe en el evento
        if (autor == null) {
            System.out.println("El participante con el nombre '" + nombreAutor + "' no fue encontrado en el evento '" + nombreEvento + "'. Operación cancelada.");
            return; // Salir del método si el participante no existe
        }
    
        // Crear la reseña usando el servicio correspondiente
        Resena nuevaResena = resenaService.crearResena(scanner, evento, autor);
    
        // Verificar si la reseña fue creada exitosamente
        if (nuevaResena == null) {
            System.out.println("No se pudo crear la reseña. Operación cancelada.");
            return; // Salir del método si la creación de la reseña falló
        }
    
        // Agregar la reseña al participante
        participanteService.agregarResena(autor, nuevaResena);
    
        System.out.println("Reseña agregada exitosamente para el evento '" + nombreEvento + "'.");
    }
    

    private void listarEventosDisponibles(Scanner scanner) {
        List<Evento> eventos = sistemaService.listarEventosDisponibles(scanner);
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("Eventos disponibles");
            eventos.forEach(evento -> {
                System.out.println("Nombre del Evento: " + evento.getNombreEvento() +
                        ", Descripción: " + evento.getDecripEvento());
                System.out.println("----------------------------------");
            });

        }
    }


    private void exportarArchivo(Scanner scanner) {
        List <Evento> eventos = sistemaService.listarEventosNoDisponibles(scanner);
        String rutaArchivo = System.getProperty("user.home") + "/Desktop";

        exportArchivoService.exportarEventos(eventos, rutaArchivo);

    }

}
