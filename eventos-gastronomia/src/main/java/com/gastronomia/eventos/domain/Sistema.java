package com.gastronomia.eventos.domain;

import java.util.HashMap;
import java.util.Map;

public class Sistema {
    //Atributo para almacenar eventos
    private final Map<String, Evento> eventos;

    //Constructor
    public Sistema() {
        eventos = new HashMap<>();
    }

    // Métodos para manejar eventos (añadir, eliminar, etc.)
    public void agregarEvento(String nombreEvento, Evento evento) {
        eventos.put(nombreEvento, evento);
    }

    public Evento obtenerEvento(String nombreEvento) {
        return eventos.get(nombreEvento);
    }

    public void eliminarEvento(String nombreEvento) {
        eventos.remove(nombreEvento);
    }


    //Getter
    public Map<String, Evento> getEventos() {
        return eventos;
    }

}
