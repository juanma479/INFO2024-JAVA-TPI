package com.gastronomia.eventos;

import java.util.Scanner;

import com.gastronomia.eventos.service.evento.EventoService;
import com.gastronomia.eventos.service.evento.impl.EventoServiceImpl;
import com.gastronomia.eventos.service.menu.MenuService;
import com.gastronomia.eventos.service.menu.impl.MenuServiceImpl;

public class App {
    public static void main( String[] args )
    {
        try (Scanner scanner = new Scanner(System.in)) {
            MenuService menuService = new MenuServiceImpl();
            EventoService eventoService = new EventoServiceImpl();
            
            int opcion;
            do {
                menuService.mostrarMenu(scanner);
                opcion = menuService.seleccionarOpcion(scanner);
                
                switch (opcion) {
                    case 1 -> { eventoService.crearEvento(scanner);
                    }
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                    case 4 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            
            } while (opcion != 4);
        }

    }
}
