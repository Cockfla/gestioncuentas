package org.example;

public class CuentaCorriente extends Cuenta{
    public float sobregiro;
    public CuentaCorriente(String ID, String nombre, String rut, String direccion, String correo) {
        super(ID, nombre, rut, direccion, correo);
    }
    public void consignar(float cantidad){
        float residuo = cantidad-this.sobregiro ;
        if (this.sobregiro>0) {
            if (residuo > 0) {
                this.sobregiro = 0;
                this.saldo = residuo;
            }else{
                this.sobregiro=residuo;
                this.saldo=0;

            }
        }else{
            super.consignar(cantidad);
        }
    }

    public void retirar(float cantidad){
        float resultado = this.saldo - cantidad;
        if(resultado<=0){
            this.sobregiro= this.sobregiro-resultado;
            this.saldo = 0;
        }else{
            super.retirar(cantidad);
        }
    }
    public void mostrarSaldo(){
        System.out.println("El sobregiro es: "+this.sobregiro);
        super.mostrarSaldo();
    }
    public String toString() {
        return super.toString() + "\nTipo de Cuenta: Cuenta Corriente";
    }
}


