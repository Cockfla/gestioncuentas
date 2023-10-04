package org.example;


public class Main {
    public static void main(String[] args) {
    Ejecutivo Ejecutivo1=new Ejecutivo("hola","33333");

    Cliente Cliente1=new Cliente("21.315.211-4","Elias");
    Ejecutivo1.AgregarCuentaCorriente(Cliente1,"21.315.211-4","Elias","xd","sd",5000);
    Ejecutivo1.AgregarCuentaAhorro(Cliente1,"21.315.211-4","xddd","dddd","ddd",20000);
    Cliente1.verInformacion();

        Cliente clientexd= new Cliente("20.659.872-7","Maria jesus");
        Ejecutivo1.AgregarCuentaCorriente(clientexd,"20.659.872-7","Maria jesus","anashe","xds",300000);
        clientexd.verInformacion();
        Ejecutivo1.VerCuentasAgregadas();
    }
}