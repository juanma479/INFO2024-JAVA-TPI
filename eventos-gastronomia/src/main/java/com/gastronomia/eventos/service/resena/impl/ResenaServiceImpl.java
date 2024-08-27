package com.gastronomia.eventos.service.resena.impl;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.domain.Resena;
import com.gastronomia.eventos.enumeration.resena.CalificacionEnum;
import com.gastronomia.eventos.service.resena.ResenaService;

public class ResenaServiceImpl implements ResenaService {

    @Override
    public Resena crearResena(Scanner scanner, Evento evento, Participante autor) {

        //Solicitamos el comentario que va en la reseña
        System.out.println("Deje un comentario sobre el evento.");
        String comentario = scanner.nextLine();

        //Creamos la nueva reseña
        Resena nuevaResena = new Resena(evento, autor, comentario);

        // Lógica para establecer calificación con enum.
        System.out.print("Califique el evento " + evento.getNombreEvento() + " del 1 al 5: ");
        int opcionSeleccionada = scanner.nextInt();

        scanner.nextLine();

        // Usar switch para determinar el valor del enum según la opción seleccionada
        nuevaResena.setCalificacion(
                switch (opcionSeleccionada){
                    case 1 -> CalificacionEnum.UNO;
                    case 2 -> CalificacionEnum.DOS;
                    case 3 -> CalificacionEnum.TRES;
                    case 4 -> CalificacionEnum.CUATRO;
                    case 5 -> CalificacionEnum.CINCO;
                    default -> null;
                }
        );
        //Terminamos y devolvemos la nueva reseña
        return nuevaResena ;
    }

}
