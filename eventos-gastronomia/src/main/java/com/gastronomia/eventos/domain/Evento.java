package com.gastronomia.eventos.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Evento {

    //Atributos
    private UUID idEvento;
    private String nombreEvento;
    private String descripEvento;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private int capacidad;
    private Chef chefACargo;

    private Map<String, Participante> participantes;

    //Constructor
    public Evento( String nombreEvento, String descripEvento, LocalDateTime fechaHora, String ubicacion,
            int capacidad) {
        this.idEvento = UUID.randomUUID();
        this.nombreEvento = nombreEvento;
        this.descripEvento = descripEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.chefACargo = null;
        this.participantes = new HashMap<>();
    }
    
    //Getters y Setters
    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento() {
        this.idEvento = UUID.randomUUID();
    }


    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }


    public String getDecripEvento() {
        return descripEvento;
    }

    public void setDecripEvento(String descripEvento) {
        this.descripEvento = descripEvento;
    }


    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }


    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    public Chef getChefACargo() {
        return chefACargo;
    }

    public void setChefACargo(Chef chefACargo) {
        this.chefACargo = chefACargo;
    }


    public Map<String, Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes() {
        this.participantes = new HashMap<>();
    }


    
}
