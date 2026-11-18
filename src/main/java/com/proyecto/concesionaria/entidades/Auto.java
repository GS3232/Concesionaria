package com.proyecto.concesionaria.entidades;

// Importamos Lombok para generar el getter.
import lombok.Getter;

// Genera automáticamente getCantidadPuertas().
@Getter
public class Auto extends Vehiculo {

    // Atributo propio de los automóviles.
    private int cantidadPuertas;

    // Constructor del automóvil.
    public Auto(String marca, String modelo, double precio, int cantidadPuertas) {

        // Enviamos los atributos comunes al constructor de Vehiculo.
        super(marca, modelo, precio);

        // Asignamos el atributo propio del automóvil.
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String toString() {
    return String.format(
            "Marca: %s // Modelo: %s // Puertas: %d // Precio: $%s",
            getMarca(),
            getModelo(),
            getCantidadPuertas(),
            formatearPrecio()
    );
}
}