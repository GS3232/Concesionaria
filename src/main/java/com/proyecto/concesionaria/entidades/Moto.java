package com.proyecto.concesionaria.entidades;

// Importamos las anotaciones de Lombok.
import lombok.Getter;

// @Getter genera automáticamente el getter de cilindrada.
@Getter

// Moto hereda los atributos y métodos de Vehiculo.
public class Moto extends Vehiculo {

// Atributo propio de las motocicletas.
private int cilindrada;

// Constructor para crear una motocicleta.
public Moto(String marca, String modelo, double precio, int cilindrada) {

// Enviamos los atributos comunes al constructor de Vehiculo.
super(marca, modelo, precio);

// Guardamos la cilindrada de la motocicleta.
this.cilindrada = cilindrada;
}

// Implementamos el método exigido por la interfaz Imprimible.
@Override
public String obtenerDescripcion() {

// Devolvemos los datos de la moto con el formato solicitado.
return String.format(
"Marca: %s // Modelo: %s // Cilindrada: %dc // Precio: $%,.2f",
getMarca(),
getModelo(),
cilindrada,
getPrecio());
}
}