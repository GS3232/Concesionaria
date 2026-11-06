package com.proyecto.concesionaria.servicio;

// Importamos las clases de vehículos.
import com.proyecto.concesionaria.entidades.Vehiculo;
import com.proyecto.concesionaria.entidades.Auto;
import com.proyecto.concesionaria.entidades.Moto;
// Importamos Comparator para comparar los precios.
import java.util.Comparator;
import java.util.Optional;
// Importamos las herramientas para trabajar con listas.
import java.util.ArrayList;
import java.util.List;
// Importamos la anotación Service de Spring.
import org.springframework.stereotype.Service;
import java.util.Collections;

// Indicamos a Spring que esta clase es un servicio administrado.
@Service
// Esta clase se encarga de administrar los vehículos.
public class ConcesionariaService {

// Método que carga todos los vehículos de la concesionaria.
public List<Vehiculo> cargarVehiculos() {

// Creamos una lista que puede contener autos y motos.
List<Vehiculo> vehiculos = new ArrayList<>();

// Agregamos los vehículos en el orden solicitado.
vehiculos.add(new Auto("Peugeot", "206", 200000.00, 4));
vehiculos.add(new Moto("Honda", "Titan", 60000.00, 125));
vehiculos.add(new Auto("Peugeot", "208", 250000.00, 5));
vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));

// Devolvemos la lista completa.
return vehiculos;
}

// Método genérico que imprime la descripción de cada vehículo.
public void imprimirVehiculos(List<Vehiculo> vehiculos) {

// Recorremos la lista e imprimimos cada vehículo.
vehiculos.forEach(vehiculo ->
System.out.println(vehiculo.obtenerDescripcion()));

// Imprimimos el primer separador solicitado por el enunciado.
System.out.println();
System.out.println("=============================");
System.out.println();
}

// Busca y devuelve el vehículo con el precio más alto.
public Optional<Vehiculo> obtenerVehiculoMasCaro(List<Vehiculo> vehiculos) {

// Utilizamos Stream y Comparator para encontrar el precio máximo.
return vehiculos.stream()
.max(Comparator.comparingDouble(Vehiculo::getPrecio));
}

// Busca y devuelve el vehículo con el precio más bajo.
public Optional<Vehiculo> obtenerVehiculoMasBarato(List<Vehiculo> vehiculos) {

// Utilizamos Stream y Comparator para encontrar el precio mínimo.
return vehiculos.stream()
.min(Comparator.comparingDouble(Vehiculo::getPrecio));
}

// Busca el primer vehículo cuyo modelo contiene la letra Y.
public Optional<Vehiculo> obtenerVehiculoConLetraY(List<Vehiculo> vehiculos) {

// Recorremos los vehículos y filtramos los modelos que contienen Y.
return vehiculos.stream()
.filter(vehiculo -> vehiculo.getModelo()
.toUpperCase().contains("Y"))
.findFirst();
}
// Ordena los vehículos desde el precio más alto hasta el más bajo.
public List<Vehiculo> ordenarPorPrecioDescendente(List<Vehiculo> vehiculos) {

// Creamos una lista nueva para no modificar la lista original.
List<Vehiculo> vehiculosOrdenados = new ArrayList<>(vehiculos);

// Ordenamos comparando los precios de mayor a menor.
vehiculosOrdenados.sort(
Comparator.comparingDouble(Vehiculo::getPrecio).reversed()
);

// Devolvemos la lista ordenada.
return vehiculosOrdenados;
}
// Ordena los vehículos según su orden natural.
public List<Vehiculo> ordenarPorOrdenNatural(List<Vehiculo> vehiculos) {

// Creamos una copia para conservar la lista original.
List<Vehiculo> vehiculosOrdenados = new ArrayList<>(vehiculos);

// Ordenamos utilizando el compareTo() de la clase Vehiculo.
Collections.sort(vehiculosOrdenados);

// Devolvemos la lista ordenada.
return vehiculosOrdenados;
}
// Muestra los resultados de las búsquedas solicitadas.
public void imprimirResumen(List<Vehiculo> vehiculos) {

// Buscamos el vehículo más caro.
obtenerVehiculoMasCaro(vehiculos).ifPresent(vehiculo ->
System.out.println("Vehículo más caro: "
    + vehiculo.getMarca() + " " + vehiculo.getModelo()));

// Buscamos el vehículo más barato.
obtenerVehiculoMasBarato(vehiculos).ifPresent(vehiculo ->
System.out.println("Vehículo más barato: "
    + vehiculo.getMarca() + " " + vehiculo.getModelo()));

//"Vehículo que contiene en el modelo la letra ‘Y’: "
obtenerVehiculoConLetraY(vehiculos).ifPresent(vehiculo ->
System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: "
    + vehiculo.getMarca() + " " + vehiculo.getModelo()
    + " $" + vehiculo.getPrecioFormateado()));
}
// Imprime los vehículos ordenados de las dos formas solicitadas.
public void imprimirOrdenamientos(List<Vehiculo> vehiculos) {

// Mostramos el título de la primera ordenación.
System.out.println();
System.out.println("=============================");
System.out.println("Vehículos ordenados por precio de mayor a menor:");

// Obtenemos una lista ordenada por precio descendente.
List<Vehiculo> porPrecio = ordenarPorPrecioDescendente(vehiculos);

// Imprimimos cada vehículo de la lista ordenada.
porPrecio.forEach(vehiculo ->
System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo()));

// Mostramos el separador y el título de la segunda ordenación.
System.out.println();
System.out.println("=============================");
System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");

// Obtenemos una lista ordenada según el orden natural.
List<Vehiculo> porOrdenNatural = ordenarPorOrdenNatural(vehiculos);

// Imprimimos la descripción completa de cada vehículo.
porOrdenNatural.forEach(vehiculo ->
System.out.println(vehiculo.obtenerDescripcion()));
}
}