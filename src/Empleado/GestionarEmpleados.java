import java.util.ArrayList;
import java.util.Scanner;

interface gestionTipoEmpleado
{
    String gestionTemporal();
    double gestionPermanente();
}

public class GestionarEmpleados implements gestionTipoEmpleado
{
    Scanner scanner = new Scanner(System.in);

    /*GestionEmpleados: Utiliza un ArrayList para gestionar objetos del tipo Empleado.
    Implementa métodos para añadir, eliminar y mostrar empleados. Utiliza polimorfismo para
    manejar diferentes tipos de empleados.*/

    private ArrayList<Empleado> listaEmpleados;

    public GestionarEmpleados()
    {
        this.listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado()
    {
        System.out.println("Ingrese el nombre del empleado");
        String nombreEmpleado = scanner.next();

        System.out.println("Ingrese la edad del empleado");
        int edad = scanner.nextInt();

        System.out.println("Ingrese la identificacion del empleado");
        int id = scanner.nextInt();

        System.out.println("Ingrese Salario del empleado");
        double salario = scanner.nextDouble();

        System.out.println("Que tipo de empleado eres 'Temporal' o 'Permanente' " );
        String tipoEmpleado = scanner.next();

        if (tipoEmpleado.equalsIgnoreCase("temporal"))
        {
            String fechaFinalizacion = this.gestionTemporal();

            EmpleadoTemporal empleadoTemporal = new EmpleadoTemporal(nombreEmpleado, edad, id, salario, fechaFinalizacion);
            listaEmpleados.add(empleadoTemporal);
        }
        else if(tipoEmpleado.equalsIgnoreCase("permanente"))
        {
            double bonoVacaciones = this.gestionPermanente();

            EmpleadoPermanente empleadoPermanente = new EmpleadoPermanente(nombreEmpleado, edad, id, salario, bonoVacaciones);
            listaEmpleados.add(empleadoPermanente);
        }
        else
        {
            System.out.println("Tipo de empleado inexistente!");
        }

    }

    public void mostrarEmpleado()
    {
        System.out.println("---EMPLEADOS EN EL MOMENTO---");

        if (this.listaEmpleados.isEmpty())
        {
            System.out.println("NO HAY PERSONAL DISPONIBLE");
        }
        else
        {
            for (Empleado empleado : this.listaEmpleados)
            {
                System.out.println(empleado.toString());
            }
        }
    }

    public void eliminarEmpleado()
    {

        this.mostrarEmpleado();

        if (this.listaEmpleados.isEmpty())
        {
            System.out.println("NO HAY PERSONAL DISPONIBLE");
        }
        else
        {
            System.out.println("Ingrese el id a eliminar");
            int id = scanner.nextInt();

            boolean eliminarEmpleado = listaEmpleados.removeIf(empleado -> empleado.getIdEmpleado() == id);

            if (eliminarEmpleado)
            {
                System.out.println("Eliminado con exito!");
            }
            else
            {
                System.out.println("Empleado no encontrado!");
            }
        }
    }

    //Polimorfismo con interfaces
    public String gestionTemporal()
    {
        System.out.println("Ingrese fecha de finalizacion para empleado temporal");
        String fechaFinalizacion = scanner.next();

        return fechaFinalizacion;
    }

    public double gestionPermanente()
    {
        System.out.println("Ingrese la cantidad del bono para el Empleado permanente");
        double vacacionesDinero = scanner.nextDouble();

        return vacacionesDinero;
    }

}
