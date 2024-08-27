package com.gastronomia.eventos.service.resena;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Evento;
import com.gastronomia.eventos.domain.Participante;
import com.gastronomia.eventos.domain.Resena;

public interface ResenaService {

    Resena crearResena(Scanner scanner, Evento evento, Participante autor);
}
