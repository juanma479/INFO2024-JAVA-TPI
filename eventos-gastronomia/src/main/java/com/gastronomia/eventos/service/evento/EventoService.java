package com.gastronomia.eventos.service.evento;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Participante;

public interface EventoService {
    Evento crearEvento(Scanner scanner);
    void inscribirParticipante(Participante participante, Evento evento);

}
