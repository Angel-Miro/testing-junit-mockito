package org.ajmg.models;

import org.ajmg.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal cuenta;

    private boolean isActive;

    public Cuenta(){
        this.isActive = true;
    }

    public Cuenta(String persona, BigDecimal cuenta){
        this();
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

    public void abonar (BigDecimal monto){
        if(monto.doubleValue() != 0.0){
            this.cuenta = this.cuenta.add(monto);
        }
    }

    public void cargar(BigDecimal cargo) throws SaldoInsuficienteException {
        if(cargo.doubleValue() != 0.0){
            if(cargo.doubleValue() > this.cuenta.doubleValue()){
                throw  new SaldoInsuficienteException("Saldo insuficiente");
            } else {
                this.cuenta = this.cuenta.subtract(cargo);
            }
        }
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta)obj;
        if(c.getPersona() == null && c.getCuenta() == null){
            return false;
        }

        return this.persona.equals(c.getPersona()) && this.cuenta.equals(c.getCuenta());

    }
}
