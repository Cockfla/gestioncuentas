package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ejecutivo extends Persona{

   private List<Cuenta> cuentas;

    public Ejecutivo( String rut,String nombre){
        super(rut,nombre);
        this.cuentas=new ArrayList<>();

    }
    public void AgregarCliente(String rut,String nombre,String Direccion, String Correo){
        try{
            Cliente cliente=new Cliente(rut,nombre,Direccion,Correo);
            Conexion.getInstance().insertCliente(rut,nombre,Direccion,Correo);
            System.out.println("Se ha agregado correctamente al cliente");
        }catch (Error e){
            System.out.println("Error al agregar cliente"+e.getMessage());
        }
    }

    public void AgregarCuentaCorriente(Cliente cliente, String rut, String nombre, String direccion, String correo) {
        try {
            String ID = rut + "-1";
            CuentaCorriente nuevaCuenta = new CuentaCorriente(ID, nombre, rut, direccion, correo);
            cuentas.add(nuevaCuenta);
            cliente.agregarCuenta(nuevaCuenta);
            Conexion.getInstance().insertCuentaCorriente(ID,rut,nombre,getRut());
            System.out.println("Se ha creado exitosamente la cuenta corriente");
        } catch (Error e) {
            System.out.println("No se ha podido crear la cuenta corriente");
        }
    }
    public void AgregarCuentaAhorro(Cliente cliente, String rut, String nombre, String direccion, String correo){
        try {
            String ID = rut + "-2";
            CuentaCorriente nuevaCuenta = new CuentaCorriente(ID, nombre, rut, direccion, correo);
            cuentas.add(nuevaCuenta);
            cliente.agregarCuenta(nuevaCuenta);

            // Llama al método insertCuentaCorriente de la clase Conexion para guardar la información en la base de datos
            Conexion.getInstance().insertCuentaAhorro(ID, rut, nombre, getRut());
            System.out.println("Se ha creado exitosamente la cuenta corriente");
        } catch (Error e) {
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
    public void EliminarCuenta(String rut){
        try {
            Conexion.getInstance().deleteCuenta(rut);
        }catch (Error e){
            System.out.println("Error al eliminar al cliente "+e.getMessage());
        }
    }
    public void MostrarClientes(){
        Conexion.getInstance().MostrarCuentasAgregadas(getRut());
    }
    public void ActualizarCliente(String Rut, String nombre, String Direccion, String Correo){
        Conexion.getInstance().uptadeCliente(Rut,nombre,Direccion,Correo);
    }
}
