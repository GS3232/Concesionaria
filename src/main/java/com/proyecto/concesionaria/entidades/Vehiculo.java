package com.proyecto.concesionaria.entidades;

// Importamos la interfaz que deberán implementar los vehículos.
import com.proyecto.concesionaria.interfaces.Imprimible;
// Importamos las herramientas para dar formato argentino a los precios.
import java.text.NumberFormat;
import java.util.Locale;
// Importamos las anotaciones de Lombok.
import lombok.Getter;
import lombok.AllArgsConstructor;

// @Getter genera automáticamente los métodos get.
// @AllArgsConstructor genera un constructor con todos los atributos.
@Getter
@AllArgsConstructor

// Clase abstracta que representa los datos comunes de todos los vehículos.
// Implementa Imprimible y Comparable para definir un orden natural.
public abstract class Vehiculo implements Imprimible, Comparable<Vehiculo> {

// Atributos que comparten autos y motos.
private String marca;
private String modelo;
private double precio;

// Define el orden natural de los vehículos:
// primero por marca, después por modelo y finalmente por precio.
@Override
public int compareTo(Vehiculo otro) {

// Comparamos las marcas de ambos vehículos.
int resultadoMarca = this.marca.compareTo(otro.marca);

// Si las marcas son diferentes, devolvemos el resultado.
if (resultadoMarca != 0) {
return resultadoMarca;}

// Si las marcas son iguales, comparamos los modelos.
int resultadoModelo = this.modelo.compareTo(otro.modelo);

// Si los modelos son diferentes, devolvemos el resultado.
if (resultadoModelo != 0) {
return resultadoModelo;}

// Si marca y modelo son iguales, comparamos los precios.
return Double.compare(this.precio, otro.precio);
}

// Devuelve el precio con el formato utilizado en Argentina.
public String getPrecioFormateado() {

// Configuramos el formato numérico para Argentina.
NumberFormat formato = NumberFormat.getNumberInstance(
Locale.forLanguageTag("es-AR")
);

// Establecemos dos decimales.
formato.setMinimumFractionDigits(2);
formato.setMaximumFractionDigits(2);

// Devolvemos el precio formateado.
return formato.format(precio);
}
// Sobrescribimos toString para mostrar la descripción del vehículo.
@Override
public String toString() {

// Delegamos la descripción a cada tipo de vehículo.
return obtenerDescripcion();
}
}
