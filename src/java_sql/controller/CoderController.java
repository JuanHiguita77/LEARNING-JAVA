package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;

public class CoderController
{
    public static void getAll()
    {
        CoderModel coderModel = new CoderModel();

        String listCoders = " CODERS LIST \n ";
        //Usamos la lista que nos devuelve la funcion
        for ( Object coder : coderModel.findAll() )
        {
            //TIpo Objeto para generalizar y luego se convierte
            Coder newCoder = (Coder) coder;

            listCoders += newCoder.toString();
        }

        JOptionPane.showMessageDialog(null, listCoders);
    }

    public static void insertNew()
    {
        CoderModel coderModel = new CoderModel();

        String name = JOptionPane.showInputDialog("Ingrese el nombre del nuevo coder");

        int age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del coder"));

        String clan = JOptionPane.showInputDialog("Ingrese el clan del nuevo coder");

        Coder newCoder = new Coder();

        newCoder.setNombre(name);
        newCoder.setClan(clan);
        newCoder.setAge(age);

        newCoder = (Coder) coderModel.insert(newCoder);

        JOptionPane.showMessageDialog(null, newCoder.toString());

    }
}
