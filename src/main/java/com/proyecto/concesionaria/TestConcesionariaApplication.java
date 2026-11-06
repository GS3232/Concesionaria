package com.proyecto.concesionaria;

// Importamos Spring Boot.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importamos CommandLineRunner para ejecutar código al iniciar.
import org.springframework.boot.CommandLineRunner;

// Importamos nuestro servicio.
import com.proyecto.concesionaria.servicio.ConcesionariaService;

// Importamos la anotación para inyectar dependencias.
import org.springframework.beans.factory.annotation.Autowired;

// Clase principal de la aplicación.
@SpringBootApplication
public class TestConcesionariaApplication implements CommandLineRunner {

    // Inyectamos el servicio de la concesionaria.
    @Autowired
    private ConcesionariaService concesionariaService;

    // Método principal que inicia Spring Boot.
    public static void main(String[] args) {
        SpringApplication.run(TestConcesionariaApplication.class, args);
    }

    // Este método se ejecuta automáticamente al iniciar Spring Boot.
    @Override
    public void run(String... args) {

        // Cargamos los vehículos.
        var vehiculos = concesionariaService.cargarVehiculos();

        // Dejamos un renglón en blanco después del inicio de Spring Boot.
        System.out.println();

        // Mostramos los vehículos.
        concesionariaService.imprimirVehiculos(vehiculos);
        // Mostramos el resumen y las listas ordenadas.
        concesionariaService.imprimirResumen(vehiculos);

        // Imprimimos los vehículos ordenados de las dos formas solicitadas.
        concesionariaService.imprimirOrdenamientos(vehiculos);
    }
}