package org.ajmg.models;

import org.ajmg.exceptions.SaldoInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    /**
     * EL Test Driven Development (TDD) : Es crear una método que tal vez no se llame igual al de la clase
     *                                pero que dentro del metodo del test se mande a llamar o "pruebe" el
     *                                metodo de la clase.
     *
     * Ej: testAbono() y testCargo : Primero se escribe la prueba y tener los valores esperados
     *     para despues escribir el codigo
     *
     * @Test  : Es la anotacion para indicar que es un test,
     *          por convecion el teste tiene modificador de acceso de pkg
     *
     */

    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("angel juan", new BigDecimal(10000.91));
        assertEquals("angel juan", cuenta.getPersona());
        assertEquals(10000, cuenta.getCuenta().intValue());
    }


    @Test
    void testValidateActive(){
        Cuenta cuenta = new Cuenta("angel juan", new BigDecimal(10000.91));
        assertTrue(cuenta.isActive());
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("angel juan", new BigDecimal("10000.12345"));
        assertEquals(10000.12345,cuenta.getCuenta().doubleValue());
        assertFalse(cuenta.getCuenta().compareTo(BigDecimal.ZERO) < 0);
    }

    /**
     * Se hace override del metodo equals para poder comprar los objetos
     * pero esto se hace con la necesidad propia
     */
    @Test
    void testReferencia() {
        Cuenta c = new Cuenta("angel", new BigDecimal("1000.1234"));
        Cuenta c2 = new Cuenta("angel", new BigDecimal("1000.1234"));
        assertEquals(c,c2);
    }

    @Test
    void testAbono() {
        Cuenta c = new Cuenta("angel", new BigDecimal("1000.1234"));
        c.abonar(new BigDecimal("100"));
        assertEquals(1100.1234, c.getCuenta().doubleValue());
    }

    @Test
    void testCargo() {
        Cuenta c = new Cuenta("angel", new BigDecimal("1000.1234"));
        c.cargar(new BigDecimal("100"));
        assertEquals(900.1234, c.getCuenta().doubleValue());
    }

    /**
     * Para capturar exceptions se hace de la siguiente forma
     *
     */
    @Test
    void testSaldoInsuficienteException() {
        Cuenta c = new Cuenta("angel", new BigDecimal("1000.1234"));
        // aqui se asigna la exception generada a un objeto de tipo Exception
        Exception e = assertThrows(SaldoInsuficienteException.class, () -> {
            c.cargar( new BigDecimal("10000"));
        });
        // se aprovecha para validar el mensaje obtenido de la exception
        assertEquals(e.getMessage(), "Saldo insuficiente");
    }
}