package org.ajmg.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    /**
     * EL Test Driven Develop (TDD) : Es crear una método que tal vez no se llame igual al de la clase
     *                                pero que dentro del metodo del test se mande a llamar o "pruebe" el
     *                                metodo de la clase.
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




}