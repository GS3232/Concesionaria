package com.proyecto.concesionaria.entidades;

// Importamos Lombok para generar el getter.
import lombok.Getter;

// Genera automáticamente getCilindrada().
@Getter
public class Moto extends Vehiculo {

    // Atributo propio de moto.
    private int cilindrada;

    // Constructor de moto.
    public Moto(String marca, String modelo, double precio, int cilindrada) {

        // Enviamos los atributos comunes al constructor de Vehiculo.
        super(marca, modelo, precio);

        // Asignamos el atributo propio de la moto.
        this.cilindrada = cilindrada;
    }
    @Override
    public String toString() {
    return String.format(
            "Marca: %s // Modelo: %s // Cilindrada: %dc // Precio: $%s",
            getMarca(),
            getModelo(),
            getCilindrada(),
            formatearPrecio()
    );
}
}