import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        GestionarEmpleados gestion = new GestionarEmpleados();

        int opcion;

        try
        {
            do
            {
                System.out.println("""
                        1 - Agregar Empleado
                        2 - Mostrar Empleados
                        3 - Eliminar Empleado
                        4 - SALIR
                        """);
                opcion = scanner.nextInt();

                switch (opcion)
                {
                    case 1:

                        gestion.agregarEmpleado();
                        break;

                    case 2:

                        gestion.mostrarEmpleado();
                        break;

                    case 3:

                        gestion.eliminarEmpleado();
                        break;

                    case 4:

                        System.out.println("SALIENDO...");

                        break;
                }
            }while(opcion != 4);
        }
        catch(Exception e)
        {
            System.out.println("Ingresaste mal un dato!" + e);
        }
    }
}