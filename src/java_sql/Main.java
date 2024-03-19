import controller.CoderController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        String option = "";

        do
        {
            option = JOptionPane.showInputDialog("""
                        1 - Listar Coders
                        2 - Insertar Nuevo Coder
                        3 - Update Coder
                        4 - Delete Coder
                        5 - Get Coder By Name
                        6 - Exit 
                        """);

            switch (option)
            {
                case "1":
                    CoderController.getAll();

                    break;

                case "2":
                        CoderController.insertNew();
                    break;
            }


        }while(!option.equals("6"));
    }
}