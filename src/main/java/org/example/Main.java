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

       Conexion.getInstance();
        //Cliente cliente21= new Cliente("12.111.111-1","dou","xd","xdd");
        //Ejecutivo1.AgregarCuentaCorriente(clientexd,"12.111.111-1","dou","xddd","xd@xd","2.222.222-2");
        Ejecutivo1.EliminarCuenta("11.111.111-1");
       // new Conexion().uptadeUsuario("11.111.111-1","mamaguevo","alli","xddd");
       // Ejecutivo1.MostrarClientes("2.222.222-2");
        //cliente21.verCuentas();
    }
}