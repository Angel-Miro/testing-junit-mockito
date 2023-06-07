package org.ajmg.models;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal cuenta;

    private boolean isActive;

    public Cuenta(){}

    public Cuenta(String persona, BigDecimal cuenta){
        this.persona = persona;
        this.cuenta = cuenta;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getCuenta() {
        return cuenta;
    }

    public void setCuenta(BigDecimal cuenta) {
        this.cuenta = cuenta;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
