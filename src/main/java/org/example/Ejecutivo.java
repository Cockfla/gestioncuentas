package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ejecutivo extends Persona{

   private List<Cuenta> cuentas;

    public Ejecutivo( String nombre,String rut){
        super(nombre,rut);
        this.cuentas=new ArrayList<>();

    }

    public void AgregarCuentaCorriente(Cliente cliente,String rut,String nombre,String direccion,String correo,float saldo){
        try {
            String ID = rut + "-" + (cuentas.size() + 1);
            CuentaCorriente nuevaCuenta = new CuentaCorriente(ID, nombre, rut, direccion, correo, saldo);
            cuentas.add(nuevaCuenta);
            cliente.agregarCuenta(nuevaCuenta);
            System.out.println("Se ha creado exitosamente la cuenta");
        }catch (Error e){
            System.out.println("No se ha podido crear la cuenta corriente");
        }
    }
    public void AgregarCuentaAhorro(Cliente cliente,String rut,String nombre,String direccion,String correo,float saldo){
        try {
            String ID = rut + "-" + (cuentas.size() + 1);
            CuentaAhorro nuevaCuenta = new CuentaAhorro(ID, nombre, rut, direccion, correo, saldo);
            cuentas.add(nuevaCuenta);
            cliente.agregarCuenta(nuevaCuenta);
            System.out.println("Se ha creado exitosamente la cuenta");
        }catch (Error e){
            System.out.println("No se ha podido crear la cuenta corriente");
        }
    }
    public void VerCuentasAgregadas(){
        System.out.println("Cuentas Agregadas: ");
        for (Cuenta cuenta:cuentas){
            System.out.println(cuenta.toString());
            System.out.println("------------------------");
        }
    }
}
