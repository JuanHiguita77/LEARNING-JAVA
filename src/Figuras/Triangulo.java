
//Extendemos la clase de figura sobre la que usara sus funciones
class Triangulo extends FIgura
{
    //Creamos todo como lo hariamos normalmente sin darle el alcance a la clase, simplemente class
    private double altura;
    private double base;

    public Triangulo(double altura, double base)
    {
        this.altura = altura;
        this.base = base;
    }

    //Usar las funciones abstractas
    @Override
    double calcularArea()
    {
        return altura * base;
    }
}
