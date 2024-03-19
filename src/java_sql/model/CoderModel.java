package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD
{

    @Override
    public Object insert(Object object) {

        Connection  conexionOpen = ConfigDB.conexionAbierta();

        Coder coder = (Coder) object;

        try
        {
            String sqlQuery = "INSERT INTO coder (nombre, age, clan) VALUES (?, ?, ?);";

            //Retorna los ID automaticas de la base de datos con el returnkeys
            PreparedStatement preparedStatement = conexionOpen.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //Pasando datos a la query
            preparedStatement.setString(1, coder.getNombre());
            preparedStatement.setInt(2, coder.getAge());
            preparedStatement.setString(3, coder.getClan());

            preparedStatement.execute();

            ResultSet resultado = preparedStatement.getGeneratedKeys();

            while (resultado.next())
            {
                //Le asignamos el id que es el dato que falta
                coder.setId(resultado.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "New coder Insert Successfully");

        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error en las queries SQL: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return coder;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listCoders = new ArrayList<>();

        Connection  conexionOpen = ConfigDB.conexionAbierta();

        try
        {
            String  sqlQuery = "SELECT * FROM coder;";

            PreparedStatement preparedStatement = conexionOpen.prepareStatement(sqlQuery);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next())
            {
                Coder coder = new Coder();

                coder.setId(result.getInt("id"));
                coder.setNombre(result.getString("nombre"));
                coder.setAge(result.getInt("age"));
                coder.setClan(result.getString("clan"));

                listCoders.add(coder);

            }
        }
        catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listCoders;
    }

    @Override
    public boolean update(Object object) {


        return newCoder;
    }

    @Override
    public void delete(Object object) {

    }
}
