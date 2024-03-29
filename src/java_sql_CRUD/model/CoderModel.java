package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object obj) {

        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();

        //2. Convertir el obj que llegó a Coder
        Coder objCoder =(Coder) obj;

        try {
            //3. Escribir el SQl
            String sql = "INSERT INTO coder (name,age,clan) VALUES (?,?,?);";

            //4. Preparar el Statement, además agregar la propiedad  RETURN_GENERATED_KEYS que hace que la sentencia SQL nos retorne los id generados por la Base de datos
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar valor a los ? ? ?
            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());

            //6. Ejecutar el Query
            objPrepare.execute();

            //7. Obtener el resultado con los id (LLaves generadas)
            ResultSet objRest = objPrepare.getGeneratedKeys();

            //8. Iterar mientras haya un registro
            while (objRest.next()){
                //Podemos obtener el valor tambien con indices
                objCoder.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Coder insertion was  successful.");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());

        }

        ConfigDB.closeConnection();

        return objCoder;
    }

    @Override
    public List<Object> findAll() {
        // 1. Crear lista para guardar lo que nos devuelve la base de datos
        List<Object> listCoders = new ArrayList<>();

        // 2. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        try {
            // 3. Escribimos el query en Sql
            String sql = "SELECT * FROM coder;";

            //4. Usar el prepareStatement ----  Se le pasa el dato al statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5. Ejecutar el query y obtener el resultado (ResulSet)

            ResultSet objResult = objPrepare.executeQuery();

            // 6. Mientras haya un resultado siguiente hacer:
            while (objResult.next()){

                // 6.1 Crear un coder
                Coder objCoder = new Coder();

                //6.2 Llenar el objeto con la información de la base de datos del objeto ques está iterando
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setId(objResult.getInt("id"));
                objCoder.setClan(objResult.getString("clan"));

                //6.3 Agregamos el Coder a la lista
                listCoders.add(objCoder);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //Paso 7. Cerrar la conexión
        ConfigDB.closeConnection();

        return listCoders;
    }

    @Override
    public boolean  delete(Object obj)
    {
        Coder coder = (Coder) obj;

        Connection  conexion = ConfigDB.openConnection();

        //Vamos a devolver el resultado de lo que paso si elimino o no
        boolean isDeleted = false;

        try
        {
            String sqlQuery = "DELETE  FROM coder WHERE id = ?;";

            PreparedStatement preparedStatement = conexion.prepareStatement(sqlQuery);

            //Se le pasa el dato al statement
            preparedStatement.setInt(1, coder.getId());

            //Devuelve un numero para saber a cuantas filas se le hizo el cambio
            int resultadoFIlasAfectadas = preparedStatement.executeUpdate();

            //Fueron afectadas?
            if (resultadoFIlasAfectadas > 0)
            {
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Se actualizaron correctamente las filas " + resultadoFIlasAfectadas);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }

        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error en el Update: " +  e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public boolean update(Object object) {

        Connection conexion = ConfigDB.openConnection();

        boolean isUpdated = false;

        try
        {
            Coder coder = (Coder) object;

            String sqlQuery = "UPDATE coder SET name = ?, age = ?, clan = ? WHERE id = ?;";

            PreparedStatement preparedStatement = conexion.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //Se le pasa el dato al statement
            preparedStatement.setString(1, coder.getName());            //Se le pasa el dato al statement
            preparedStatement.setInt(2, coder.getAge());
            preparedStatement.setString(3, coder.getClan());
            preparedStatement.setInt(4, coder.getId());

            int resultado = preparedStatement.executeUpdate();

            if (resultado > 0)
            {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "Updated Successfully");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null , "Error --> " + e.getMessage());
        }
        finally
        {
            ConfigDB.closeConnection();
        }

        return isUpdated;
    }

    //No viene del CRUD, es propio
    public Coder findById(int id)
    {
        Connection conexion = ConfigDB.openConnection();

        //Global
        Coder coder = null;

        try
        {
            String sqlQuery = "SELECT * FROM coder WHERE id = ?;";

            PreparedStatement preparedStatement = conexion.prepareStatement(sqlQuery);

            //Se le pasa el dato al statement
            preparedStatement.setInt(1, id);

            //TIpo de dato del jdbc: ResultSet
            /*
            * execute: devuelve boolean
            * executeQuery: Devuelve algo
            * executeUpdate: Actualiza
            * */

            ResultSet resultado = preparedStatement.executeQuery();

            if(resultado.next())
            {
                coder = new Coder();

                coder.setAge(resultado.getInt("age"));
                coder.setClan(resultado.getString("clan"));
                coder.setName(resultado.getString("name"));
                coder.setId(resultado.getInt("id"));
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Hubo un error al buscar el coder");
        }

        ConfigDB.closeConnection();
        return coder;
    }

    public List<Object> findByName(String name)
    {
        // 1. Crear lista para guardar lo que nos devuelve la base de datos
        List<Object> listCoders = new ArrayList<>();

        // 2. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        try {
            // 3. Escribimos el query en Sql
            String sqlQuery = "SELECT *  FROM coder WHERE name LIKE ?;";

            //4. Usar el prepareStatement ----  Se le pasa el dato al statement
            PreparedStatement preparedStatement = objConnection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, "%" + name + "%");

            //5. Ejecutar el query y obtener el resultado (ResulSet)

            ResultSet resultado = preparedStatement.executeQuery();

            // 6. Mientras haya un resultado siguiente hacer:
            while (resultado.next()){

                // 6.1 Crear un coder
                Coder objCoder = new Coder();

                //6.2 Llenar el objeto con la información de la base de datos del objeto ques está iterando
                objCoder.setName(resultado.getString("name"));
                objCoder.setAge(resultado.getInt("age"));
                objCoder.setId(resultado.getInt("id"));
                objCoder.setClan(resultado.getString("clan"));

                //6.3 Agregamos el Coder a la lista
                listCoders.add(objCoder);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //Paso 7. Cerrar la conexión
        ConfigDB.closeConnection();

        return listCoders;
    }
}
