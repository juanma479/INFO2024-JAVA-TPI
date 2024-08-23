package com.gastronomia.eventos.service.participante.impl;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.domain.Resena;
import com.gastronomia.eventos.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService{

    @Override
    public Participante crearParticipante(Scanner scanner) {
        System.out.println("Ingrese el nombre del Participante: ");
        String nombreParticipante= scanner.nextLine();

        System.out.println("Ingrese el apellido del evento: ");
        String apellidoParticipante = scanner.nextLine();

        Participante nuevoparticipante = new Participante(nombreParticipante, apellidoParticipante);

        System.out.println("Ingrese los intereses del participante (escriba 'fin' para terminar):");
        
        while (true) {
            String interes = scanner.nextLine();
            if (interes.equalsIgnoreCase("fin")) {
                break;
            }
            nuevoparticipante.getIntereses().add(interes);
            System.out.println("Interés '" + interes + "' agregado.");
        }

        System.out.println("Intereses registrados: ");
        System.out.println("Participante creado.");

        return nuevoparticipante;
    
        
    }

    @Override
    public void agregarResena(Participante participante, Resena resena) {
        participante.getResenas().add(resena);
    }
    
}
