package com.proyecto.concesionaria;

// Importamos JUnit para poder realizar pruebas automáticas.
import org.junit.jupiter.api.Test;

// Importamos las herramientas para verificar resultados.
import static org.junit.jupiter.api.Assertions.*;

// Importamos las clases que vamos a probar.
import com.proyecto.concesionaria.entidades.Auto;
import com.proyecto.concesionaria.entidades.Moto;

class ConcesionariaApplicationTests {

// Verificamos que el automóvil se cree correctamente.
@Test
void crearAutoCorrectamente() {

// Creamos un automóvil Peugeot 206.
Auto auto = new Auto("Peugeot", "206", 200000.00, 4);

// Comprobamos su marca.
assertEquals("Peugeot", auto.getMarca());

// Comprobamos su modelo.
assertEquals("206", auto.getModelo());

// Comprobamos su cantidad de puertas.
assertEquals(4, auto.getCantidadPuertas());

// Comprobamos su precio.
assertEquals(200000.00, auto.getPrecio());
}

// Verificamos que la motocicleta se cree correctamente.
@Test
void crearMotoCorrectamente() {

// Creamos una motocicleta Honda Titan.
Moto moto = new Moto("Honda", "Titan", 60000.00, 125);

// Comprobamos su marca.
assertEquals("Honda", moto.getMarca());

// Comprobamos su modelo.
assertEquals("Titan", moto.getModelo());
// Comprobamos su cilindrada.
assertEquals(125, moto.getCilindrada());

// Comprobamos su precio.
assertEquals(60000.00, moto.getPrecio());
}

// Verificamos que la descripción del automóvil sea correcta.
@Test
void descripcionDelAutoCorrecta() {

// Creamos el automóvil.
Auto auto = new Auto("Peugeot", "206", 200000.00, 4);

// Comprobamos la descripción generada.
assertEquals(
"Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: $200.000,00",
auto.obtenerDescripcion());
}

// Verificamos que la descripción de la motocicleta sea correcta.
@Test
void descripcionDeLaMotoCorrecta() {

// Creamos la motocicleta.
Moto moto = new Moto("Honda", "Titan", 60000.00, 125);

// Comprobamos la descripción generada.
assertEquals(
"Marca: Honda // Modelo: Titan // Cilindrada: 125c // Precio: $60.000,00",
moto.obtenerDescripcion());
}
}