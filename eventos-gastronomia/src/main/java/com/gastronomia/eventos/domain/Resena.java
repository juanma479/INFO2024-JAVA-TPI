package com.gastronomia.eventos.domain;

import java.util.UUID;

import com.gastronomia.eventos.enumeration.resena.CalificacionEnum;

public class Resena {
    private UUID idresena;
    private Evento evento;
    private Participante autor;
    private CalificacionEnum calificacion;
    private String comentario;
    
    

    //Constructor
    public Resena(Evento evento, Participante autor, CalificacionEnum calificacion, String comentario) {
        this.idresena = UUID.randomUUID();
        this.evento = evento;
        this.autor = autor;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }


    //Getters y Setters
    public UUID getIdresena() {
        return idresena;
    }

    public void setIdresena() {
        this.idresena = UUID.randomUUID();
    }


    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }


    public Participante getAutor() {
        return autor;
    }

    public void setAutor(Participante autor) {
        this.autor = autor;
    }


    public CalificacionEnum getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionEnum calificacion) {
        this.calificacion = calificacion;
    }


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    
}
