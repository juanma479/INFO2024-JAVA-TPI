package com.gastronomia.eventos;

import java.util.Scanner;

import com.gastronomia.eventos.service.evento.EventoService;
import com.gastronomia.eventos.service.evento.impl.EventoServiceImpl;
import com.gastronomia.eventos.service.menu.MenuService;
import com.gastronomia.eventos.service.menu.impl.MenuServiceImpl;
import com.gastronomia.eventos.service.sistema.SistemaService;
import com.gastronomia.eventos.service.sistema.impl.SistemaServiceImpl;

public class App {
    public static void main( String[] args )
    {
        // Crear una instancia de SistemaService
        SistemaService sistemaService = new SistemaServiceImpl();
        
        // Crear un Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        EventoService eventoService = new EventoServiceImpl();

        // Crear una instancia de MenuService con el SistemaService y el Scanner
        MenuService menuService = new MenuServiceImpl(sistemaService, eventoService, scanner);

        // Iniciar el sistema automáticamente
        sistemaService.iniciarSistema();

        // Mostrar el menú y manejar la interacción del usuario
        boolean running = true;
        while (running) {
            // Mostrar el menú
            menuService.mostrarMenu();

            // Leer la opción seleccionada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            // Procesar la opción seleccionada
            menuService.procesarOpcion(opcion);
        }

        // Cerrar el Scanner
        scanner.close();
    }

    
}
