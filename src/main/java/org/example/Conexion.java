package org.example;

import java.sql.*;

public class Conexion {
    private static String driver ="com.mysql.jdbc.Driver";
    public static String database = "CUENTASBANCARIAS";//nombre de la database
    public static String hostname="localhost"; //host
    public static String port="3306";//puerta de la BD
    private static String urlCon="jdbc:mysql://"+hostname+":"+port+"/"+database+"?useSSL=false";
    public String username="root";
    public String password="";
    private static Connection conn=null;
    private static Conexion instancia;
    public Conexion() {
    }
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection abrirConexion(){
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(urlCon,username,password);
            System.out.println("Conexion exitosa a la base de datos");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion a la base de datos."+e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    private void cerrarConexion(){
        try{
            if (!conn.isClosed()){
                conn.close();
                System.out.println("Conexión cerrada");
            }
        }catch (SQLException e){
            e.getMessage();

        }

    }

    public void insertCliente(String RUT,String NOMBRE,String DIRECCION,String CORREO){
        try {
            abrirConexion();
            PreparedStatement statement=null;
            String consultaSql = "INSERT INTO CLIENTE(RUT,NOMBRE,DIRECCION,CORREO) VALUES (?,?,?,?)";
            statement = conn.prepareStatement(consultaSql);
            statement.setString(1,RUT);
            statement.setString(2,NOMBRE);
            statement.setString(3,DIRECCION);
            statement.setString(4,CORREO);

            int filasAfectadas=statement.executeUpdate();

            if (filasAfectadas>0){
                System.out.println("Inserción exitosa. Filas afectadas: "+filasAfectadas);
            }else{
                System.out.println("Inserción fallida");
            }

        }catch (SQLException e){
            System.out.println("Error al ejecutar la inserción"+e.getMessage());
        }finally {
            cerrarConexion();
        }

    }
    public void insertEjecutiva(String RUT,String NOMBRE){
        try {
            abrirConexion();
            PreparedStatement statement=null;
            String consultaSql = "INSERT INTO EJECUTIVA(RUT,NOMBRE) VALUES (?,?)";
            statement = conn.prepareStatement(consultaSql);
            statement.setString(1,RUT);
            statement.setString(2,NOMBRE);

            int filasAfectadas=statement.executeUpdate();

            if (filasAfectadas>0){
                System.out.println("Inserción exitosa. Filas afectadas: "+filasAfectadas);
            }else{
                System.out.println("Inserción fallida");
            }

        }catch (SQLException e){
            System.out.println("Error al ejecutar la inserción"+e.getMessage());
        }finally {
            cerrarConexion();
        }

    }
    public void insertCuentaAhorro(String num,String RutCliente,String nombre, String RutEjecutiva){
        try {
            abrirConexion();
            String TipoCuenta= "Cuenta de Ahorro";
            PreparedStatement statement=null;
            String consultaSql = "INSERT INTO CUENTA(NUM,RutCliente,Nombre,RutEjecutiva,TipoCuenta) VALUES (?,?,?,?,?)";
            statement = conn.prepareStatement(consultaSql);
            statement.setString(1,num);
            statement.setString(2,RutCliente);
            statement.setString(3,nombre);
            statement.setString(4,RutEjecutiva);
            statement.setString(5,TipoCuenta);

            int filasAfectadas=statement.executeUpdate();

            if (filasAfectadas>0){
                System.out.println("Inserción exitosa. Filas afectadas: "+filasAfectadas);
            }else{
                System.out.println("Inserción fallida");
            }

        }catch (SQLException e){
            System.out.println("Error al ejecutar la inserción"+e.getMessage());
        }finally {
            cerrarConexion();
        }
    }
    public void insertCuentaCorriente(String num,String RutCliente,String nombre, String RutEjecutiva){
        try {
            abrirConexion();
            String TipoCuenta= "Cuenta Corriente";
            PreparedStatement statement=null;
            String consultaSql = "INSERT INTO CUENTA(NUM,RutCliente,Nombre,RutEjecutiva,TipoCuenta) VALUES (?,?,?,?,?)";
            statement = conn.prepareStatement(consultaSql);
            statement.setString(1,num);
            statement.setString(2,RutCliente);
            statement.setString(3,nombre);
            statement.setString(4,RutEjecutiva);
            statement.setString(5,TipoCuenta);

            int filasAfectadas=statement.executeUpdate();

            if (filasAfectadas>0){
                System.out.println("Inserción exitosa. Filas afectadas: "+filasAfectadas);
            }else{
                System.out.println("Inserción fallida");
            }

        }catch (SQLException e){
            System.out.println("Error al ejecutar la inserción"+e.getMessage());
        }finally {
            cerrarConexion();
        }
    }
    public void MostrarCuentasCliente(String rut){
        try{
            abrirConexion();
            Statement statement= conn.createStatement();
            String consulta="Select * from CUENTA WHERE RutCliente='"+rut+"'";
            ResultSet resultado= statement.executeQuery(consulta);
            while (resultado.next()){
                String NUM=resultado.getString("num");
                String RutCliente=resultado.getString("RutCliente");
                String Nombre=resultado.getString("Nombre");
                String RutEjecutiva=resultado.getString("RutEjecutiva");
                String TipoCuenta=resultado.getString("TipoCuenta");
                System.out.println("Numéro de Cuenta: "+NUM+" Rut Cliente : "+RutCliente+" Nombre Cliente: "+Nombre+" Rut Ejecutiva: "+RutEjecutiva+" Tipo de Cuenta: "+TipoCuenta);
            }

        }catch (SQLException e){
            System.out.println("No se ha podido listar a los usuarios"+e.getMessage());
        }finally {
            cerrarConexion();
        }
    }

    public void MostrarCuentasAgregadas(String rut){
        try{
            abrirConexion();
            Statement statement= conn.createStatement();
            String consulta="Select * from CUENTA WHERE RutEjecutiva='"+rut+"'";
            ResultSet resultado= statement.executeQuery(consulta);
            while (resultado.next()){
                String NUM=resultado.getString("num");
                String RutCliente=resultado.getString("RutCliente");
                String Nombre=resultado.getString("Nombre");
                String RutEjecutiva=resultado.getString("RutEjecutiva");
                String TipoCuenta=resultado.getString("TipoCuenta");
                System.out.println("Numéro de Cuenta: "+NUM+" Rut Cliente : "+RutCliente+" Nombre Cliente: "+Nombre+" Rut Ejecutiva: "+RutEjecutiva+" Tipo de Cuenta: "+TipoCuenta);
            }

        }catch (SQLException e){
            System.out.println("No se ha podido listar a los usuarios"+e.getMessage());
        }finally {
            cerrarConexion();
        }
    }
    public void deleteCuenta(String rut) {
        try {
            abrirConexion();
            PreparedStatement statement = null;
            String consulta = "DELETE FROM CUENTA WHERE RutCliente=?";
            statement = conn.prepareStatement(consulta);
            statement.setString(1, rut);

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Eliminado exitosamente. Filas afectadas: " + filasAfectadas);
            } else {
                System.out.println("No se ha podido eliminar");
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar al eliminar" + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void uptadeUsuario(String RUT,String nombre, String Direccion,String Correo){
        try {
            abrirConexion();
            PreparedStatement statement=null;
            String consulta= "UPDATE CLIENTE SET NOMBRE=?,DIRECCION=?,CORREO=? WHERE RUT=?";
            statement = conn.prepareStatement(consulta);
            statement.setString(1,nombre);
            statement.setString(2,Direccion);
            statement.setString(3,Correo);
            statement.setString(4,RUT);
            int filasAfectadas=statement.executeUpdate();
            if (filasAfectadas>0){
                System.out.println("Datos de usuario actualizados correctamente. Filas afectadas: "+filasAfectadas);

            }else{
                System.out.println("No se ha podido actualizar los datos del cliente");
            }

        }catch (SQLException e){
            System.out.println("Error al actualizar los datos del cliente"+e.getMessage());

        }finally {
            cerrarConexion();

        }
    }

}