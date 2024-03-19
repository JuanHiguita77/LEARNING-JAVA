package database;

import java.sql.*;

//Clase para establecer conexion y cerrar la base de datos tambien
public class ConfigDB
{
    //Estado de la conexion
    public static Connection conexion = null;

    //Metodo para conectar la BD, devuelve algo tipo Conexion
    public static Connection conexionAbierta()
    {
        try
        {
            //Llamamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Variables de conexion
            String url = "jdbc:mysql://localhost:3306/jdbc_java";
            String usuario = "root";
            String contraseña = "Rlwl2023.";

            //Conectarnos a la BD con la credencial
            //Lo parseamos a una conexion para asegurarnos que esto será una conexion
            conexion = (Connection) DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion realizada");

            /*
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM coder");

            while (resultado.next())
            {
                System.out.println(resultado.getString("nombre"));
            }*/

        }//Fallo por driver
        catch (ClassNotFoundException e)
        {
            System.out.println("Error con el driver" + e.getMessage());
        }//Fallo por conexion
        catch (SQLException e)
        {
            System.out.println("Error al conectar base de datos " + e.getStackTrace());
        }

        return conexion;
    }

    //Cerrar conexion
    public static void closeConnection()
    {
        try
        {
            if (conexion != null)
            {
                conexion.close();
                System.out.println("Conexion finalizada");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }
}
