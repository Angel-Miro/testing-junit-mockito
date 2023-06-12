package org.ajmg.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;

    List<Cuenta> cuentas;

    public Banco(){
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void add(Cuenta cuenta){
        this.cuentas.add(cuenta);
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto){
        origen.cargar(monto);
        destino.abonar(monto);
    }
}
