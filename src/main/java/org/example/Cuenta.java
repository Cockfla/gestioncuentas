package org.example;

public class Cuenta {
    private String ID;
    private String nombre;
    private String rut;
    private String direccion;
    private String correo;
    protected float saldo;
    protected int numeroConsignaciones=0;
    protected int numeroRetiros=0;

    public Cuenta(String ID, String nombre, String rut, String direccion, String correo,float saldo){
        this.ID=ID;
        this.nombre=nombre;
        this.rut=rut;
        this.direccion=direccion;
        this.correo=correo;
        this.saldo=saldo;
    }

    public String getRut() {
        return rut;
    }
    @Override
    public String toString() {
        return "Número de Cuenta: " + ID + "\n" +
                "Nombre: " + nombre + "\n" +
                "Rut: " + rut + "\n" +
                "Dirección: " + direccion + "\n" +
                "Correo: " + correo;
    }
    public void consignar(float cantidad){
        this.saldo+= cantidad;
        this.numeroConsignaciones = this.numeroConsignaciones + 1;
    }
    public void retirar(float cantidad){
        float nuevoSaldo=this.saldo-cantidad;
        if(nuevoSaldo>= 0){
            this.saldo-=cantidad;
            this.numeroRetiros = this.numeroRetiros+1;
        }else{
            throw new Error("La cantidad a retirar excede el saldo actual");
            //System.out.println("La cantidad a retirar excede el saldo actual");
        }
    }

    public void mostrarSaldo(){
        System.out.println("El saldo de la cuenta es "+this.saldo);
    }

}
