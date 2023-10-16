package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Cuenta> cuentas;

    public Cliente(String rut, String nombre,String Direccion,String Correo) {
        super(rut, nombre);
        this.cuentas = new ArrayList<>();
        new Conexion().insertCliente(rut,nombre,Direccion,Correo);
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void verInformacion() {
        if (!cuentas.isEmpty()) {
           for(Cuenta cuenta:cuentas){
               System.out.println(cuenta.toString());
               System.out.println("----------------------");
           }
           }else{
            System.out.println("No se ha asignado ninguna cuenta a este cliente");
        }

    }
    public void verCuentas(){
        new Conexion().MostrarCuentasCliente(getRut());
    }
}

