package com.gastronomia.eventos.service.chef.impl;

import java.util.Scanner;

import com.gastronomia.eventos.domain.Chef;
import com.gastronomia.eventos.service.chef.ChefService;

public class ChefServiceImpl implements ChefService{

    @Override
    public Chef crearChef(Scanner scanner) {
        
        // Ingresar el nombre del Chef
    System.out.println("Ingrese el nombre del Chef: ");
    String nombreChef = scanner.nextLine().trim();
    
    // Verificar que el nombre no esté vacío
    if (nombreChef.isEmpty()) {
        System.out.println("El nombre del Chef no puede estar vacío.");
        return null;
    }

    // Ingresar la especialidad del Chef
    System.out.println("Ingrese la especialidad del Chef: ");
    String especialidad = scanner.nextLine().trim();

    // Verificar que la especialidad no esté vacía
    if (especialidad.isEmpty()) {
        System.out.println("La especialidad del Chef no puede estar vacía.");
        return null; // O manejar el error de la forma que prefieras
    }

    // Crear y devolver el objeto Chef
    return new Chef(nombreChef, especialidad);
    }
    

}
