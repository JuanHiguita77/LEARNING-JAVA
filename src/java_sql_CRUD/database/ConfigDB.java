package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta clase se encargará de establecer y cerrar la conexión con la base de datos
public class ConfigDB {
    //Este atributo tendrá el estado de la conexión
    public static Connection objConnection = null;

    //Método para conectar la BD
    public  static  Connection openConnection(){

        try{
            //Llamamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos las variables de conexión
            String url = "jdbc:mysql://localhost:3306/_01_jdbc";
            String user = "root";
            String password = "Rlwl2023.";

            //Establecer la conexión
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecté perfectamente!!!!");

<<<<<<< HEAD
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
=======
        }catch (ClassNotFoundException error){
            System.out.println("ERROR >> Driver no Instalado "+error.getMessage());
        }catch (SQLException error){
            System.out.println("ERROR >> error al conectar con la base de datos"+ error.getMessage());
>>>>>>> 06e694cf1e7066290845b409e5e75dc250843792
        }

        return  objConnection;
    }

    //Método para finalizar una conexión
    public static void closeConnection(){
        try{
            //Si hay una conexión activa entonces la cierra
            if ( objConnection != null){
                objConnection.close();
                System.out.println("Se finalizó la conexión con éxito");
            }
        }catch (SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
