package com.proyecto.concesionaria;

import com.proyecto.concesionaria.entidades.Vehiculo;
import com.proyecto.concesionaria.operaciones.ConcesionariaService;
import java.util.List;

public class ConcesionariaApplication {

    public static void main(String[] args) {
        ConcesionariaService servicio = new ConcesionariaService();
        List<Vehiculo> vehiculos = servicio.cargarVehiculos();

        servicio.imprimirVehiculos(vehiculos);
        servicio.imprimirResumen(vehiculos);
        servicio.imprimirOrdenamientos(vehiculos);
    }
}