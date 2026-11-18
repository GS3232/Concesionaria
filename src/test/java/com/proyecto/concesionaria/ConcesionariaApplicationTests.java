package com.proyecto.concesionaria;

// Importamos JUnit para realizar pruebas automáticas.
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

        Auto auto = new Auto("Peugeot", "206", 200000.00, 4);

        assertEquals("Peugeot", auto.getMarca());
        assertEquals("206", auto.getModelo());
        assertEquals(4, auto.getCantidadPuertas());
        assertEquals(200000.00, auto.getPrecio());
    }

    // Verificamos que la motocicleta se cree correctamente.
    @Test
    void crearMotoCorrectamente() {

        Moto moto = new Moto("Honda", "Titan", 60000.00, 125);

        assertEquals("Honda", moto.getMarca());
        assertEquals("Titan", moto.getModelo());
        assertEquals(125, moto.getCilindrada());
        assertEquals(60000.00, moto.getPrecio());
    }

    // Verificamos que la descripción del automóvil sea correcta.
    @Test
    void descripcionDelAutoCorrecta() {

        Auto auto = new Auto("Peugeot", "206", 200000.00, 4);

        assertEquals(
                "Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: $200.000,00",
                auto.toString()
        );
    }

    // Verificamos que la descripción de la motocicleta sea correcta.
    @Test
    void descripcionDeLaMotoCorrecta() {

        Moto moto = new Moto("Honda", "Titan", 60000.00, 125);

        assertEquals(
                "Marca: Honda // Modelo: Titan // Cilindrada: 125c // Precio: $60.000,00",
                moto.toString()
        );
    }
}