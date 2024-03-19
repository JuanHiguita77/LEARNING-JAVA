import java.util.ArrayList;
import java.util.Scanner;

public class Curso
{
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;
    private static int index = 0;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void agregarEstudiante(Scanner scanner)
    {
        scanner.nextLine();
        System.out.println("Ingrese el nombre estudiante: ");
        String nombreEst = scanner.nextLine();

        System.out.println("Ingrese el email del estudiante");
        String email = scanner.next();

        Estudiante estudiante = new Estudiante(index, nombreEst, email);
        index++;
        this.listaEstudiantes.add(estudiante);

        System.out.println("Estudiante agregado correctamente!");
    }

    public void listarEstudiantes()
    {
        if (!this.listaEstudiantes.isEmpty())
        {
            System.out.println("---LISTA ESTUDIANTES DEL CURSO --> " + this.nombre);
            for (Estudiante estudiante : this.listaEstudiantes)
            {
                System.out.println(estudiante.toString());
            }
        }
        else
        {
            System.out.println("No hay estudiantes en el curso " + this.nombre);
        }
    }

    public void eliminarEstudiante(Scanner scanner)
    {
        this.listarEstudiantes();

        System.out.println("Ingrese el id del estudiante a eliminar");
        int id = scanner.nextInt();

        boolean eliminadoEst = listaEstudiantes.removeIf(estudiante -> estudiante.getId() == id);

        if (eliminadoEst)
        {
            System.out.println("Estudiante eliminado!");
        }
        else
        {
            System.out.println("No se pudo eliminar el estudiante");
        }
    }

    @Override
    public String toString() {
        return "Curso --> " +
                "codigo = '" + codigo + '\'' +
                ", nombre = '" + nombre + '\'' +
                ", listaEstudiantes = " + listaEstudiantes +
                ' ';
    }
}
