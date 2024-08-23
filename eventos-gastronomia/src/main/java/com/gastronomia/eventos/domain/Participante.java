package com.gastronomia.eventos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {

    // Atributos
    private UUID idParticipante;
    private String nombreParticipante;
    private String apellidoParticipante;
    private List<String> intereses;
    private List<Evento> historial;
    private List<Resena> resenas;

    // Constructor
    public Participante(String nombreParticipante, String apellidoParticipante) {
        this.idParticipante = UUID.randomUUID();
        this.nombreParticipante = nombreParticipante;
        this.apellidoParticipante = apellidoParticipante;
        this.intereses = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.resenas = new ArrayList<>();
}

    // Getters y Setters
    public UUID getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante() {
        this.idParticipante = UUID.randomUUID();
    }


    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }


    public String getApellidoParticipante() {
        return apellidoParticipante;
    }

    public void setApellidoParticipante(String apellidoParticipante) {
        this.apellidoParticipante = apellidoParticipante;
    }


    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses() {
        this.intereses = new ArrayList<>();
    }


    public List<Evento> getHistorial() {
        return historial;
    }

    public void setHistorial() {
        this.historial = new ArrayList<>();
    }


    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas() {
        this.resenas = new ArrayList<>();
    }

    
    

}
