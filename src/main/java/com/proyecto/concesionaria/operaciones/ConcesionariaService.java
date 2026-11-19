package com.proyecto.concesionaria.operaciones;

import com.proyecto.concesionaria.entidades.Vehiculo;
import com.proyecto.concesionaria.entidades.Auto;
import com.proyecto.concesionaria.entidades.Moto;

import java.util.Comparator;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcesionariaService {

        // Carga los vehículos en una lista.
        public List<Vehiculo> cargarVehiculos() {
                List<Vehiculo> vehiculos = new ArrayList<>();

                vehiculos.add(new Auto("Peugeot", "206", 200000.00, 4));
                vehiculos.add(new Moto("Honda", "Titan", 60000.00, 125));
                vehiculos.add(new Auto("Peugeot", "208", 250000.00, 5));
                vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));

                return vehiculos;
        }

        // Impresión de los vehiculos.
        public void imprimirVehiculos(List<Vehiculo> vehiculos) {
                System.out.println();
                vehiculos.forEach(System.out::println);
                System.out.println();
                System.out.println("=============================");
        }

        // Busca el vehículo más caro usando API Stream
        public Optional<Vehiculo> obtenerVehiculoMasCaro(List<Vehiculo> vehiculos) {
                return vehiculos.stream()
                                .max(Comparator.comparingDouble(Vehiculo::getPrecio));
        }

        // Busca el vehículo más barato usando API Stream
        public Optional<Vehiculo> obtenerVehiculoMasBarato(List<Vehiculo> vehiculos) {
                return vehiculos.stream()
                                .min(Comparator.comparingDouble(Vehiculo::getPrecio));
        }

        // Busca el vehículo cuyo modelo contiene la letra 'Y' usando API Stream
        public Optional<Vehiculo> obtenerVehiculoConLetraY(List<Vehiculo> vehiculos) {
                return vehiculos.stream()
                                .filter(vehiculo -> vehiculo.getModelo()
                                                .toUpperCase().contains("Y"))
                                .findFirst();
        }

        // Ordena los vehículos por precio de mayor a menor usando API Stream
        public List<Vehiculo> ordenarPorPrecioDescendente(List<Vehiculo> vehiculos) {
                return vehiculos.stream()
                                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio).reversed())
                                .collect(Collectors.toList());
        }

        // Ordena los vehículos por su orden natural (Comparable) usando API Stream
        public List<Vehiculo> ordenarPorOrdenNatural(List<Vehiculo> vehiculos) {
                return vehiculos.stream()
                                .sorted()
                                .collect(Collectors.toList());
        }

        // Imprime el resumen de los vehículos
        public void imprimirResumen(List<Vehiculo> vehiculos) {
                obtenerVehiculoMasCaro(vehiculos).ifPresent(
                                vehiculo -> System.out.println("Vehículo más caro: " + vehiculo.informarNombre()));

                obtenerVehiculoMasBarato(vehiculos).ifPresent(
                                vehiculo -> System.out.println("Vehículo más barato: " + vehiculo.informarNombre()));

                obtenerVehiculoConLetraY(vehiculos).ifPresent(
                                vehiculo -> System.out.println("Vehículo que contiene en el modelo la letra 'Y': "
                                                + vehiculo.informarNombre()
                                                + " $" + vehiculo.formatearPrecio()));

                System.out.println("=============================");
        }

        // Imprime los vehículos ordenados
        public void imprimirOrdenamientos(List<Vehiculo> vehiculos) {
                System.out.println("Vehículos ordenados por precio de mayor a menor:");
                List<Vehiculo> porPrecio = ordenarPorPrecioDescendente(vehiculos);
                porPrecio.forEach(vehiculo -> System.out.println(vehiculo.informarNombre()));

                System.out.println("=============================");

                System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
                List<Vehiculo> porOrdenNatural = ordenarPorOrdenNatural(vehiculos);
                porOrdenNatural.forEach(System.out::println);
                System.out.println();
        }
}