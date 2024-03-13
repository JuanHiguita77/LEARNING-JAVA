
//Extendemos la clase de figura sobre la que usara sus funciones
class Circulo extends FIgura
{
    //Creamos todo como lo hariamos normalmente sin darle el alcance a la clase, simplemente class
    private double radio;

    public Circulo(double radio)
    {
        this.radio = radio;
    }

    //Usar las funciones abstractas
    @Override
    double calcularArea()
    {
        return Math.PI * radio * radio;
    }
}