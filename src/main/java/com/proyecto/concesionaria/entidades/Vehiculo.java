package com.proyecto.concesionaria.entidades;

// Importamos la interfaz de nuestra aplicación.
import com.proyecto.concesionaria.interfaces.IGestionAutomotriz;

// Importamos las herramientas para formatear números.
import java.text.NumberFormat;
import java.util.Locale;

// Importamos las anotaciones de Lombok.
import lombok.Getter;
import lombok.AllArgsConstructor;

// Lombok genera los getters y el constructor con todos los atributos.
@Getter
@AllArgsConstructor

// Clase abstracta que representa los datos comunes de los vehículos.
// Implementa la interfaz y define el orden natural.
public abstract class Vehiculo implements IGestionAutomotriz, Comparable<Vehiculo> {

    // Atributos comunes de autos y motos.
    private String marca;
    private String modelo;
    private double precio;

    // Devuelve el nombre del vehículo: marca y modelo.
    @Override
    public String informarNombre() {
        return marca + " " + modelo;
    }

    // Devuelve el precio con formato argentino.
    @Override
    public String formatearPrecio() {

        // Configuramos el formato numérico para Argentina.
        NumberFormat formato = NumberFormat.getNumberInstance(
                Locale.forLanguageTag("es-AR")
        );

        // Establecemos dos decimales.
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);

        // Devolvemos el precio convertido en texto.
        return formato.format(precio);
    }

    // Define el orden natural: marca, modelo y precio.
    @Override
    public int compareTo(Vehiculo otro) {

        // Comparamos las marcas.
        int resultadoMarca = this.marca.compareTo(otro.marca);

        if (resultadoMarca != 0) {
            return resultadoMarca;
        }

        // Si las marcas coinciden, comparamos los modelos.
        int resultadoModelo = this.modelo.compareTo(otro.modelo);

        if (resultadoModelo != 0) {
            return resultadoModelo;
        }

        // Si también coinciden los modelos, comparamos los precios.
        return Double.compare(this.precio, otro.precio);
    }
}