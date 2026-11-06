package com.proyecto.concesionaria.entidades;

// Importamos las anotaciones de Lombok.
import lombok.Getter;

// @Getter genera automáticamente el getter de cantidadPuertas.
@Getter

// Auto hereda los atributos y métodos de la clase Vehiculo.
public class Auto extends Vehiculo {

// Atributo propio de los automóviles.
private int cantidadPuertas;

// Constructor para crear un automóvil.
public Auto(String marca, String modelo, double precio, int cantidadPuertas) {

// Enviamos los atributos comunes al constructor de la clase padre.
super(marca, modelo, precio);

// Guardamos la cantidad de puertas del automóvil.
this.cantidadPuertas = cantidadPuertas;
}

// Implementamos el método exigido por la interfaz Imprimible.
@Override
public String obtenerDescripcion() {

// Devolvemos los datos del automóvil con el formato solicitado.
return String.format(
"Marca: %s // Modelo: %s // Puertas: %d // Precio: $%,.2f",
getMarca(),
getModelo(),
cantidadPuertas,
getPrecio());
}
}
