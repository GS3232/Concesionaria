package com.proyecto.concesionaria.test;

// Importamos las clases que vamos a probar.
import com.proyecto.concesionaria.entidades.Auto;
import com.proyecto.concesionaria.entidades.Moto;
import com.proyecto.concesionaria.entidades.Vehiculo;

// Importamos las herramientas para trabajar con listas.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestVehiculos {

    public static void main(String[] args) {

        // Creamos una lista que puede almacenar autos y motos.
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Agregamos los cuatro vehículos del trabajo.
        vehiculos.add(new Auto("Peugeot", "206", 200000.00, 4));
        vehiculos.add(new Moto("Honda", "Titan", 60000.00, 125));
        vehiculos.add(new Auto("Peugeot", "208", 250000.00, 5));
        vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));

        // Ordenamos la lista utilizando el orden natural de Vehiculo.
        Collections.sort(vehiculos);

        // Mostramos los vehículos ordenados.
        System.out.println("Vehículos ordenados por orden natural:");

        // Recorremos la lista e imprimimos cada vehículo.
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.obtenerDescripcion());
        }
    }
}