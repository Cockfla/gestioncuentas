package org.example;


public class Main {
    public static void main(String[] args) {
    Ejecutivo Ejecutivo1=new Ejecutivo("2.222.222-2","xd");

    /*Ejecutivo1.AgregarCuentaCorriente(Cliente1,"21.315.211-4","Elias","xd","sd",5000);
    Ejecutivo1.AgregarCuentaAhorro(Cliente1,"21.315.211-4","xddd","dddd","ddd",20000);
    Cliente1.verInformacion();

        Cliente clientexd= new Cliente("20.659.872-7","Maria jesus");
        Ejecutivo1.AgregarCuentaCorriente(clientexd,"20.659.872-7","Maria jesus","anashe","xds",300000);
        clientexd.verInformacion();
        Ejecutivo1.VerCuentasAgregadas();*/


        Cliente cliente4= new Cliente("3.333.333-3","elias","xd","xdd");
        //Ejecutivo1.AgregarCuentaCorriente(cliente4,"3.333.333-3","elias","xddd","xd@xd");
        Ejecutivo1.AgregarCuentaAhorro(cliente4,"3.333.333-3","elias","xd","xd@gmail.com");
       // Ejecutivo1.EliminarCuenta("12.111.111-1");
        //Ejecutivo1.ActualizarCliente("11.111.111-1","andres","venezuela","mamaguevo@gmail.com");
       // Ejecutivo1.MostrarClientes();
       // cliente4.verCuentas();
    }
}