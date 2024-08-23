package com.gastronomia.eventos.service.participante;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.domain.Resena;

public interface ParticipanteService {

    Participante crearParticipante(Scanner scanner);
    void agregarResena(Participante participante, Resena resena);

}
