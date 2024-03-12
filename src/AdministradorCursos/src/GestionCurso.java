import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso
{
    private ArrayList<Curso> listaCursos;

    //Instanciar
    public GestionCurso() {
        this.listaCursos = new ArrayList<>();
    }

    public void agregarCurso(Scanner scanner)
    {
        System.out.println("Ingrese el nombre del nuevo curso");
        String nombre = scanner.next();

        System.out.println("Ingrese el codigo del nuevo curso");
        String codigo = scanner.next();

        if ( this.buscarCursoPorCodigo(codigo) != null)
        {
            System.out.println("EL curso con este codigo ya existe");
        }
        else
        {
            Curso curso = new Curso(codigo, nombre);

            if (this.listaCursos.add(curso))
            {
                System.out.println("Se agrego el curso correctamente");
            }
            else
            {
                System.out.println("No se pudo agregar el curso");
            }
        }

    }

    public Curso buscarCursoPorCodigo(String codigoBuscar)
    {
        for(Curso curso : this.listaCursos)
        {
            if (curso.getCodigo().equalsIgnoreCase(codigoBuscar))
            {
                return curso;
            }
        }
        return null;
    }

    public void listarCursos()
    {
        if (this.listaCursos.isEmpty())
        {
            System.out.println("No hay cursos!!");
        }
        else
        {
            for (Curso curso : this.listaCursos)
            {
                    System.out.println(curso.toString());
            }
        }
    }
}
