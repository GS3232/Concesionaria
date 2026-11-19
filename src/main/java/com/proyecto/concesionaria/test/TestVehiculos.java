
package com.proyecto.concesionaria.test;

import com.proyecto.concesionaria.operaciones.ConcesionariaService;
import com.proyecto.concesionaria.entidades.Vehiculo;

import java.util.List;

public class TestVehiculos {

    public static void main(String[] args) {

        // Creamos un objeto del servicio.
        ConcesionariaService concesionariaService = new ConcesionariaService();

        // Cargamos los cuatro vehículos.
        List<Vehiculo> vehiculos = concesionariaService.cargarVehiculos();

        // Imprimimos todos los vehículos.
        concesionariaService.imprimirVehiculos(vehiculos);

        // Mostramos los resultados de las búsquedas.
        concesionariaService.imprimirResumen(vehiculos);

        // Mostramos los vehículos ordenados.
        concesionariaService.imprimirOrdenamientos(vehiculos);
    }
}
