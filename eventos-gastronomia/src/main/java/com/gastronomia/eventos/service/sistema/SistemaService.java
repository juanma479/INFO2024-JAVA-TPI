package com.gastronomia.eventos.service.sistema;

import java.util.List;
import java.util.Scanner;

import com.gastronomia.eventos.domain.Evento;

public interface SistemaService {

    void iniciarSistema();
    void agregarEvento(String nombreEvento,Evento evento);
    Evento obtenerEvento(String nombreEvento);
    void eliminarEvento(String nombreEvento);
    List<Evento> listarEventosDisponibles(Scanner scanner);
    List<Evento> listarEventosNoDisponibles(Scanner scanner);
}
