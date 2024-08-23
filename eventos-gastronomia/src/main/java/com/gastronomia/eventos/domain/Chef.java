package com.gastronomia.eventos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chef {

    //Atributos
    private UUID idChef;
    private String nombreChef;
    private String especialidad;
    private List<Evento> eventosAsig;



    public Chef(String nombreChef, String especialidad) {
        this.idChef = UUID.randomUUID();
        this.nombreChef = nombreChef;
        this.especialidad = especialidad;
        this.eventosAsig = new ArrayList<>();
    }


    //Getters y Setters
    public UUID getIdChef() {
        return idChef;
    }

    public void setIdChef() {
        this.idChef = UUID.randomUUID();
    }


    public String getNombreChef() {
        return nombreChef;
    }

    public void setNombreChef(String nombreChef) {
        this.nombreChef = nombreChef;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public List<Evento> getEventosAsig() {
        return eventosAsig;
    }

    public void setEventosAsig() {
        this.eventosAsig = new ArrayList<>();
    }


    
}
