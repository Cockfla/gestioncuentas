package org.example;

public class CuentaAhorro extends Cuenta{
    public boolean active;
    public CuentaAhorro(String ID, String nombre, String rut, String direccion, String correo,float saldo) {
        super(ID, nombre, rut, direccion, correo,saldo);
        if (saldo>=10000){
            this.active = true;
        }else{
            this.active = false;
        }
    }
    public String toString() {
        return super.toString() + "\nTipo de Cuenta: Cuenta de Ahorro";
    }
    public void consignar(float cantidad){
        if(this.active){
            super.consignar(cantidad);
            this.numeroConsignaciones = this.numeroConsignaciones + 1;
        }
    }
    public void estadoCuentaAhorro(){
        System.out.println("Estado de la cuenta es: "+this.active);
    }
    public void retirar(float cantidad){
        float nuevoSaldo=this.saldo-cantidad;
        if(nuevoSaldo>= 0){
            this.saldo-=cantidad;
            this.numeroRetiros = this.numeroRetiros+1;
        }else{
            System.out.println("La cantidad a retirar excede el saldo actual");
        }

    }
    public void mostrarSaldo() {
        super.mostrarSaldo();
    }
    public void mostrarMovimientos(){
        float movimientos=numeroConsignaciones+numeroRetiros;
        System.out.println("Se han registrado "+movimientos +" movimientos a la fecha");
    }
}




