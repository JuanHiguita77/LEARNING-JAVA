import database.ConfigDB;

public class MainJdbc {
    public static void main(String[] args)
    {
        //Llamar el metodo de conexion
        ConfigDB.conexionAbierta();
        ConfigDB.closeConnection();
    }
}