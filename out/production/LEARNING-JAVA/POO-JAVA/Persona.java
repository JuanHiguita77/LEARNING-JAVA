/*Crea una clase Estudiante que herede de la clase Persona. Agrega atributos adicionales como número de estudiante y carrera.
Incluye métodos específicos para manejar estos atributos.*/
interface imprimir
{
    void imprimit();
}

public class Persona
{

    private String nombre, genero;
    private int edad;

    public Persona(String nombre, int edad, String genero)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public void imprimir(Persona humano)
    {
        System.out.println("Nombre Persona: " + humano.getNombre());
        System.out.println("Edad Persona: " + humano.getEdad());
        System.out.println("Genero Persona: " + humano.getGenero());
    }

    public static void main(String[] args)
    {
        Persona humano = new Persona("Juan", 23, "Alfa hombre");

        humano.imprimir(humano);

    }
}