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
    public void insertCliente(int ID,String nombre,String clave){
        try {
            abrirConexion();
            PreparedStatement statement=null;
            String consultaSql = "INSERT INTO CLIENTE(id,nombre,clave) VALUES (?,?,?)";
            statement = conn.prepareStatement(consultaSql);
            statement.setInt(1,ID);
            statement.setString(2,nombre);
            statement.setString(3,clave);

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

    public void listarUsuario(){
        try{
            abrirConexion();
            Statement statement= conn.createStatement();
            String consulta="Select * from usuario";
            ResultSet resultado= statement.executeQuery(consulta);
            while (resultado.next()){
                int id=resultado.getInt("id");
                String nombre=resultado.getString("nombre");
                String clave=resultado.getString("clave");
                System.out.println("id: "+id+" nombre: "+nombre+" clave: "+clave);
            }

        }catch (SQLException e){
            System.out.println("No se ha podido listar a los usuarios"+e.getMessage());
        }finally {
            cerrarConexion();
        }
    }
    public void eliminarUsuario(int ID){
        try{
            abrirConexion();
            PreparedStatement statement=null;
            String consulta= "DELETE FROM usuario where ID="+ID;
            statement= conn.prepareStatement(consulta);
            int filasAfectadas= statement.executeUpdate();
            if(filasAfectadas>0){
                System.out.println("Eliminado exitosamente.Filas afectadas: "+filasAfectadas);

            }else{
                System.out.println("No se ha podido eliminar");
            }

        }catch (SQLException e){
            System.out.println("Error al ejecutar al eliminar"+e.getMessage());
        }
        finally {
            cerrarConexion();
        }
    }
    public void uptadeUsuario(int ID,String nombre, String clave){
        try {
            abrirConexion();
            PreparedStatement statement=null;
            String consulta= "UPDATE usuario SET nombre=?,clave=? WHERE ID="+ID;
            statement = conn.prepareStatement(consulta);
            statement.setString(1,nombre);
            statement.setString(2,clave);
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