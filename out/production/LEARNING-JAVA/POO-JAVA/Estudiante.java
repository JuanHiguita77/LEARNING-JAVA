interface Imprimible
{
    void imprimir();
}

public class  Estudiante extends Persona
{
    private int nEstudiante;
    private String carrera;

    public Estudiante(String nombre, int edad, String genero, int nEstudiante, String carrera)
    {
        super(nombre, edad, genero);
        this.nEstudiante = nEstudiante;
        this.carrera = carrera;
    }

    public int getNEstudiante()
    {
        return nEstudiante;
    }

    public void setNEstudiante(int nEstudiante)
    {
        this.nEstudiante = nEstudiante;
    }

    public String getCarrera()
    {
        return carrera;
    }

    public void setCarrera(String carrera)
    {
        this.carrera = carrera;
    }

    void imprimir(Estudiante estudent)
    {
        System.out.println("Nombre Estudiante: " + estudent.getNombre());
        System.out.println("Edad Estudiante: " + estudent.getEdad());
        System.out.println("Genero Estudiante: " + estudent.getGenero());
        System.out.println("Carrera Estudiante: " + estudent.getCarrera());
        System.out.println("Numero Estudiante: " + estudent.getNEstudiante());
    }

    public static void main(String[] args)
    {
        Estudiante estudent = new Estudiante("Juan", 23, "Alfa hombre", 1, "Desarrollo");

        estudent.imprimir(estudent);
    }
}
