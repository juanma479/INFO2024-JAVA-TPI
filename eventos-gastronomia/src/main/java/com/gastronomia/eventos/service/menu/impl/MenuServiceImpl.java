package com.gastronomia.eventos.service.menu.impl;

import java.util.Scanner;

import com.gastronomia.eventos.service.menu.MenuService;

public class MenuServiceImpl implements MenuService{

    @Override
    public void mostrarMenu(Scanner scanner) {
        System.out.println("1. Crear Evento");
        System.out.println("2. Inscribir Participante");
        System.out.println("3. Asignar Chef a Evento");
        System.out.println("4. Salir");
    }

    @Override
    public int seleccionarOpcion(Scanner scanner) {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

}
