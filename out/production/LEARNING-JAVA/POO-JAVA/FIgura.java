
//Creamos una clase abstracta
abstract class FIgura
{
    //Creamos una funcion abstracta sin especificar sin necesidad de decir su alcance
    abstract double calcularArea();
    //Le extendemos esta funcion a las clases que lo necesiten, estas clases no deben tener el alcance definido

    public static void main(String[] args)
    {
        Circulo circulo = new Circulo(25);
        Rectangulo rectangulo = new Rectangulo(25,25);
        Triangulo triangulo = new Triangulo(25, 25);

        System.out.println("Area del Rectangulo: " + rectangulo.calcularArea());
        System.out.println("Area del CIrculo: " + circulo.calcularArea());
        System.out.println("Area del Triangulo: " + triangulo.calcularArea());


    }
}
