package com.gastronomia.eventos.service.evento.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.gastronomia.eventos.domain.Chef;
import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.service.evento.EventoService;

public class EventoServiceImpl implements EventoService {

    @Override
    public Evento crearEvento(Scanner scanner) {
        System.out.println("Ingrese el nombre del evento: ");
        String nombreEvento = scanner.nextLine();

        System.out.println("Ingrese una descripción del evento: ");
        String descripEvento = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime fechaHora = null;
        boolean fechaHoraValida = false;

        // Solicitar y validar la fecha y hora del evento
        while (!fechaHoraValida) {
            System.out.println("Ingrese la fecha y hora del evento (dd-MM-yyyy HH:mm): ");
            String fechaHoraStr = scanner.nextLine();

            try {
                fechaHora = LocalDateTime.parse(fechaHoraStr, formatter);
                fechaHoraValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha y hora incorrecto. Por favor, intente nuevamente.");
            }
        }

        System.out.println("Ingrese donde se realizará el evento: ");
        String ubicacion = scanner.nextLine();

        System.out.println("Ingrese capacidad máxima del evento: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        Evento nuevoEvento = new Evento(nombreEvento, descripEvento, fechaHora, ubicacion, capacidad);
        System.out.println("Evento creado exitosamente");
        return nuevoEvento;

    }

    @Override
    public void asignarChef(Chef chef, Evento evento) {
        if (chef == null || evento == null) {
            System.out.println("El Chef o evento no puede ser nulo.");
            return;
        }

        // Manejo de participante ya inscripto y evento a capacidad máxima
        if (evento.getChefACargo() == null) {
            evento.setChefACargo(chef);
            chef.getEventosAsig().add(evento);
            System.out.println("Chef " + chef.getNombreChef() + " asignado al evento exitosamente.");
        } else {
            System.out.println("El evento " + evento.getNombreEvento() + " ya tiene un chef asignado.");
        }
    }

    @Override
    public void inscribirParticipante(Participante participante, Evento evento) {
        if (participante == null || evento == null) {
            System.out.println("Participante o evento no puede ser nulo.");
            return;
        }

        String nombreCompletoPart = participante.getNombreParticipante() + " " + participante.getApellidoParticipante();

        // Manejo de participante ya inscripto y evento a capacidad máxima
        if (evento.getParticipantes().containsKey(nombreCompletoPart)) {
            System.out.println("El participante " + nombreCompletoPart + " ya está inscrito en este evento.");
        } else if (evento.getParticipantes().size() == evento.getCapacidad()) {
            System.out.println("El evento " + evento.getNombreEvento() + " ha alcanzado su capacidad máxima.");
        } else {
            evento.getParticipantes().put(nombreCompletoPart, participante);
            System.out.println("Participante " + nombreCompletoPart + " inscrito exitosamente.");
        }
    }

}
