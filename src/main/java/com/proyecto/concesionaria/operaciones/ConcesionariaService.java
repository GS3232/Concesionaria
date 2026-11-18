package com.proyecto.concesionaria.operaciones;

// Importamos las clases de vehículos.
import com.proyecto.concesionaria.entidades.Vehiculo;
import com.proyecto.concesionaria.entidades.Auto;
import com.proyecto.concesionaria.entidades.Moto;

// Importamos las herramientas para comparar y ordenar.
import java.util.Comparator;
import java.util.Collections;
import java.util.Optional;

// Importamos las herramientas para trabajar con listas.
import java.util.ArrayList;
import java.util.List;

// Importamos la anotación Service de Spring.
import org.springframework.stereotype.Service;

// Indicamos a Spring que esta clase es un servicio administrado.
@Service
public class ConcesionariaService {

    // Carga todos los vehículos de la concesionaria.
    public List<Vehiculo> cargarVehiculos() {

        // Creamos una lista que puede contener autos y motos.
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Agregamos los vehículos solicitados.
        vehiculos.add(new Auto("Peugeot", "206", 200000.00, 4));
        vehiculos.add(new Moto("Honda", "Titan", 60000.00, 125));
        vehiculos.add(new Auto("Peugeot", "208", 250000.00, 5));
        vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));

        return vehiculos;
    }

    // Imprime la descripción de cada vehículo.
    public void imprimirVehiculos(List<Vehiculo> vehiculos) {

        vehiculos.forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println();
        System.out.println("=============================");
        System.out.println();
    }

    // Busca el vehículo más caro.
    public Optional<Vehiculo> obtenerVehiculoMasCaro(List<Vehiculo> vehiculos) {

        return vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getPrecio));
    }

    // Busca el vehículo más barato.
    public Optional<Vehiculo> obtenerVehiculoMasBarato(List<Vehiculo> vehiculos) {

        return vehiculos.stream()
                .min(Comparator.comparingDouble(Vehiculo::getPrecio));
    }

    // Busca el primer vehículo cuyo modelo contiene la letra Y.
    public Optional<Vehiculo> obtenerVehiculoConLetraY(List<Vehiculo> vehiculos) {

        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getModelo()
                        .toUpperCase().contains("Y"))
                .findFirst();
    }

    // Ordena los vehículos por precio de mayor a menor.
    public List<Vehiculo> ordenarPorPrecioDescendente(List<Vehiculo> vehiculos) {

        // Creamos una copia para no modificar la lista original.
        List<Vehiculo> vehiculosOrdenados = new ArrayList<>(vehiculos);

        vehiculosOrdenados.sort(
                Comparator.comparingDouble(Vehiculo::getPrecio).reversed()
        );

        return vehiculosOrdenados;
    }

    // Ordena los vehículos según su orden natural.
    public List<Vehiculo> ordenarPorOrdenNatural(List<Vehiculo> vehiculos) {

        List<Vehiculo> vehiculosOrdenados = new ArrayList<>(vehiculos);

        Collections.sort(vehiculosOrdenados);

        return vehiculosOrdenados;
    }

    // Muestra los resultados de las búsquedas.
    public void imprimirResumen(List<Vehiculo> vehiculos) {

        obtenerVehiculoMasCaro(vehiculos).ifPresent(vehiculo ->
                System.out.println("Vehículo más caro: "
                        + vehiculo.informarNombre()));

        obtenerVehiculoMasBarato(vehiculos).ifPresent(vehiculo ->
                System.out.println("Vehículo más barato: "
                        + vehiculo.informarNombre()));

        obtenerVehiculoConLetraY(vehiculos).ifPresent(vehiculo ->
                System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: "
                        + vehiculo.informarNombre()
                        + " $" + vehiculo.formatearPrecio()));
    }

    // Imprime los vehículos ordenados de las dos formas solicitadas.
    public void imprimirOrdenamientos(List<Vehiculo> vehiculos) {

        System.out.println();
        System.out.println("=============================");
        System.out.println("Vehículos ordenados por precio de mayor a menor:");

        List<Vehiculo> porPrecio = ordenarPorPrecioDescendente(vehiculos);

        porPrecio.forEach(vehiculo ->
                System.out.println(vehiculo.informarNombre()));

        System.out.println();
        System.out.println("=============================");
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");

        List<Vehiculo> porOrdenNatural = ordenarPorOrdenNatural(vehiculos);

        porOrdenNatural.forEach(vehiculo ->
                System.out.println(vehiculo));
    }
}