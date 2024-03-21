package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.util.List;

public class CoderController {

    public static void getAll(){
        CoderModel coderModel = new CoderModel();

        JOptionPane.showMessageDialog(null, getAll(coderModel.findAll()));
    }

    //Listar factorizado para todo
    public static String getAll(List<Object> objectList)
    {
        String list = "🤷‍♂️ CODER LIST \n";

        for (Object iterador: objectList){
            //Convertimos del Object a Coder
            Coder objCoder = (Coder) iterador;
            list += objCoder.toString() + "\n";
        }

        return list;
    }

    public static void create(){
        //Usamos el modelo
        CoderModel objCoderModel = new CoderModel();

        //Pedimos los datos al usuario
        String name = JOptionPane.showInputDialog("Insert name");
        String clan = JOptionPane.showInputDialog("Insert clan");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age"));

        //Creamos una instancia de coder
        Coder objCoder = new Coder();
        objCoder.setClan(clan);
        objCoder.setAge(age);
        objCoder.setName(name);

        //Llamamos al método de insercción y guardamos el objeto que retorna en coder previamente instanciado, debemos castearlo.
        objCoder = (Coder) objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());
    }


    //Solo listamos y lo devolvemos
    public static String getCodersList()
    {
        CoderModel objModel = new CoderModel();
        String listCoders = "🤷‍♂️ CODER LIST \n";

        for (Object iterador: objModel.findAll()){
            //Convertimos del Object a Coder
            Coder objCoder = (Coder) iterador;
            listCoders += objCoder.toString() + "\n";
        }

        return listCoders;
    }
    public static void delete()
    {
        CoderModel coderModel = new CoderModel();

        String codersList = getCodersList();
        int id = Integer.parseInt(JOptionPane.showInputDialog(codersList + "Ingrese el ID a eliminar"));

        //Buscamos primero si existe
        Coder coder = coderModel.findById(id);

        if (coder == null)
        {
            JOptionPane.showInputDialog(null,"El coder no se encontró");
        }
        else
        {
            int confirm = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar a " + coder.toString());

            if (confirm == 1)
            {
                JOptionPane.showMessageDialog(null,"Cancelado!");
            }
            else
            {
                coderModel.delete(coder);
                JOptionPane.showMessageDialog(null, "Se eliminó con exito --> " + coder.toString());
            }
        }
    }

    public static void findByName()
    {
        CoderModel coderModel = new CoderModel();

        String searchName = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

        String listCoders = "🤷‍LISTA DE CODERS ENCONTRADOS \n";

        for (Object iterador: coderModel.findByName(searchName))
        {
            //Convertimos del Object a Coder
            Coder objCoder = (Coder) iterador;
            listCoders += objCoder.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null ,listCoders);
    }

    public static void update()
    {
        CoderModel coderModel = new CoderModel();

        String listCoders = getCodersList();

        int idUpdated = Integer.parseInt( JOptionPane.showInputDialog(listCoders + "Enter ID coder to edit"));

        Coder coder = coderModel.findById(idUpdated);

        if (coder == null)
        {
            JOptionPane.showMessageDialog(null, "No se encontró el coder");
        }
        else
        {
            String name = JOptionPane.showInputDialog(null, "Ingrese el nombre del coder de lo contrario dejar tal cual", coder.getName());
            int age = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el nombre del coder de lo contrario dejar tal cual", String.valueOf(coder.getAge())));//Transformar a string de entero
            String clan = JOptionPane.showInputDialog("Ingrese el nombre del coder de lo contrario dejar tal cual", coder.getClan());

            coder.setName(name);
            coder.setAge(age);
            coder.setClan(clan);

            coderModel.update(coder);
        }
    }
}
