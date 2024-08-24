package com.gastronomia.eventos.service.evento;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Chef;
import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Participante;

public interface EventoService {
    Evento crearEvento(Scanner scanner);
    void asignarChef(Chef chef, Evento evento);
    void inscribirParticipante(Participante participante, Evento evento);
    Participante obtenerParticipante(String nombreParticipante, Evento evento);

}
