package com.gastronomia.eventos.service.participante.impl;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.domain.Resena;
import com.gastronomia.eventos.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService{

    @Override
    public Participante crearParticipante(Scanner scanner) {
        //Solicitamos nombre del participante
        System.out.println("Ingrese el nombre del Participante: ");
        String nombreParticipante= scanner.nextLine();

        //Solicitamos apellido del participante
        System.out.println("Ingrese el apellido del Participante: ");
        String apellidoParticipante = scanner.nextLine();

        //Creamos el nuevo participante
        Participante nuevoparticipante = new Participante(nombreParticipante, apellidoParticipante);


        //Logica para agregar intereses del participante
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

        //Terminamos y retornamos el nuevo participante
        return nuevoparticipante;
    
        
    }

    @Override
    //Método para agregar reseñas a la lista del participante
    public void agregarResena(Participante participante, Resena resena) {
        participante.getResenas().add(resena);
    }
    
}
