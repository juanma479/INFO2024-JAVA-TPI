package com.gastronomia.eventos;

import java.util.Scanner;

import com.gastronomia.eventos.service.chef.ChefService;
import com.gastronomia.eventos.service.chef.impl.ChefServiceImpl;
import com.gastronomia.eventos.service.evento.EventoService;
import com.gastronomia.eventos.service.evento.impl.EventoServiceImpl;
import com.gastronomia.eventos.service.export.ExportArchivoService;
import com.gastronomia.eventos.service.export.impl.ExportArchivoServiceImpl;
import com.gastronomia.eventos.service.menu.MenuService;
import com.gastronomia.eventos.service.menu.impl.MenuServiceImpl;
import com.gastronomia.eventos.service.participante.ParticipanteService;
import com.gastronomia.eventos.service.participante.impl.ParticipanteServiceImpl;
import com.gastronomia.eventos.service.resena.ResenaService;
import com.gastronomia.eventos.service.resena.impl.ResenaServiceImpl;
import com.gastronomia.eventos.service.sistema.SistemaService;
import com.gastronomia.eventos.service.sistema.impl.SistemaServiceImpl;

public class App {
    public static void main( String[] args )
    {
        // Crear una instancia de SistemaService
        SistemaService sistemaService = new SistemaServiceImpl();
        
        try ( // Crear un Scanner para la entrada del usuario
                Scanner scanner = new Scanner(System.in)) {
            EventoService eventoService = new EventoServiceImpl();
            ChefService chefService = new ChefServiceImpl();
            ExportArchivoService exportArchivoService = new ExportArchivoServiceImpl();
            ParticipanteService participanteService = new ParticipanteServiceImpl();
            ResenaService resenaService = new ResenaServiceImpl();


            // Crear una instancia de MenuService
            MenuService menuService = new MenuServiceImpl(sistemaService, eventoService, chefService,
            participanteService, exportArchivoService, resenaService, scanner);
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
        }
    }

    
}
