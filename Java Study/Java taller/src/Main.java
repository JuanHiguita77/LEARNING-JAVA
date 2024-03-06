import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //calculadora(scanner);
        //verificarEdad();
        //kmAMillas();
        //IMC();
        //clasificadorNumeros();
        //diasDelMes();
        //menu();
        //average();
        bisiestYear();
    }

    public static void calculadora(Scanner scanner)
    {
        // Solicitar al usuario que ingrese dos números
        System.out.println("Ingrese el primer número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double numero2 = scanner.nextDouble();

        // Realizar operaciones básicas
        double suma = numero1 + numero2;
        double resta = numero1 - numero2;
        double multiplicacion = numero1 * numero2;

        double division = 0;

        // Mostrar resultados
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);

        if (numero2 != 0)
        {
            division = numero1 / numero2;
            System.out.println("División: " + String.format("%.2f",division));
        } else {
            System.out.println("No se puede dividir por cero.");
        }

        scanner.close();
    }

    /*
        Crea un programa que solicite la edad del usuario y determine si es mayor de edad (18 años o más).
        El programa debe imprimir un mensaje indicando si el usuario es mayor de edad o no.
    * */

    public static void verificarEdad()
    {
        int age = Integer.parseInt(JOptionPane.showInputDialog("---VERIFICADOR DE EDAD--- \nIngresa tu edad: "));

        if(age >= 18)
        {
            JOptionPane.showMessageDialog(null, "Eres Mayor de edad!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Eres Menor de edad!!");
        }
    }

    /*
        * Desarrolla un programa que convierta kilómetros a millas. El programa debe solicitar al usuario que
        introduzca una distancia en kilómetros y luego debe mostrar la distancia equivalente en millas.
        Utiliza el hecho de que una milla es igual a 1.60934 kilómetros.
    * */

    public static void kmAMillas()
    {
        int km = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los kilometros que desea transformar a millas: "));

        JOptionPane.showMessageDialog(null,km + " Kilometros equivale a " + String.format("%.2f", (km/1.60934)) + " Millas");
    }

    /*
    * Escribe un programa que calcule el índice de masa corporal (IMC) de una persona. El programa
      debe pedir al usuario su peso en kilogramos y su altura en metros, calcular el IMC y mostrar un
      mensaje con el resultado. La fórmula para calcular el IMC es peso / (altura * altura).
    * */

    public static void IMC()
    {
        int weight = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su peso actual en kilogramos"));
        double height = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su altura actual en centimetros"));

        height = height/100;

        JOptionPane.showMessageDialog(null, "Su indice de masa corporal es: " + (weight / (height * height)));
    }

    /*
    * Crea un programa que solicite al usuario un número y muestre un mensaje indicando si el número
      es positivo, negativo o cero. Además, indica si el número es par o impar.
    * */

    public static void clasificadorNumeros()
    {
        float number = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un numero a verificar si es positivo, negativo o cero, tambien si es par o impar"));

        if(number > 0)
        {
            JOptionPane.showMessageDialog(null,"El numero es positivo");
        }
        else if(number < 0)
        {
            JOptionPane.showMessageDialog(null,"El numero es negativo");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El numero es cero");
        }

        if (number % 2 == 0)
        {
            JOptionPane.showMessageDialog(null, "Ademas el numero es par");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ademas el numero es impar");
        }
    }

    /*
    * Desarrolla un programa que pida al usuario el número de un mes (1-12) y muestre el número de días
      de ese mes. Asume que febrero tiene 28 días. Utiliza una estructura switch para resolverlo.
    */

    public static void diasDelMes()
    {
       int mounth = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del mes a saber sus dias en el 2024"));

       switch (mounth)
       {
           case 1:
               JOptionPane.showMessageDialog(null,"El mes Enero tiene 31 dias");
               break;

           case 2:
               JOptionPane.showMessageDialog(null,"El mes Febrero tiene 28 dias");
               break;

           case 3:
               JOptionPane.showMessageDialog(null,"El mes Marzo tiene 31 dias");
               break;

           case 4:
               JOptionPane.showMessageDialog(null,"El mes Abril tiene 30 dias");
               break;

           case 5:
               JOptionPane.showMessageDialog(null,"El mes Mayo tiene 31 dias");
               break;

           case 6:
               JOptionPane.showMessageDialog(null,"El mes Junio tiene 30 dias");
               break;

           case 7:
               //Julio
           case 8:
               JOptionPane.showMessageDialog(null,"El mes Julio y Agosto tiene 31 dias");
               break;

           case 9:
               JOptionPane.showMessageDialog(null,"El mes Septiembre tiene 30 dias");
               break;

           case 10:
               JOptionPane.showMessageDialog(null,"El mes Octubre tiene 31 dias");
               break;

           case 11:
               JOptionPane.showMessageDialog(null,"El mes Noviembre tiene 30 dias");
               break;

           case 12:
               JOptionPane.showMessageDialog(null,"El mes Diciembre tiene 31 dias");
               break;

           default:
               JOptionPane.showMessageDialog(null,"Ingresaste una numero de mes incorrecto!!");
       }
    }

    /*
    * Implementa un programa que muestre un menú con opciones para realizar diferentes operaciones
      matemáticas (por ejemplo, sumar, restar, multiplicar, dividir). El usuario debe poder seleccionar una
      opción ingresando un número, y luego el programa debe pedir los números necesarios para realizar
      la operación elegida y mostrar el resultado. Utiliza una estructura switch para manejar las opciones
      del menú.*/

    public static void menu()
    {
        int option;
        float num1, num2;
        float result;

        do
        {
            option = Integer.parseInt(JOptionPane.showInputDialog(null,
    "---CALCULADORA--- \n" +
            "1 - Sum \n" +
            "2 - subtraction \n" +
            "3- Multiply \n" +
            "4 - Division \n" +
            "0 - SALIR"));

            switch (option)
            {
                case 1:
                    num1 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el primer numero a operar"));
                    num2 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el segundo numero a operar"));

                    result = sum(num1, num2);

                    JOptionPane.showMessageDialog(null,"El resultado de la suma es: " + result);
                    break;

                case 2:
                    num1 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el primer numero a operar"));
                    num2 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el segundo numero a operar"));

                    result = subtraction(num1,  num2);

                    JOptionPane.showMessageDialog(null,"El resultado de la resta es: " + result);
                    break;

                case 3:
                    num1 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el primer numero a operar"));
                    num2 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el segundo numero a operar"));

                    result = multiply( num1,  num2);

                    JOptionPane.showMessageDialog(null,"El resultado de la Multiplicacion es: " + result);
                    break;

                case 4:
                    num1 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el primer numero a operar"));
                    num2 = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el segundo numero a operar"));

                    result = division( num1,  num2);

                    JOptionPane.showMessageDialog(null,"El resultado de la Division es: " + result);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"CALCULADORA FINALIZADA");
                    break;
            }
        }while(option != 0);
    }
    public static float sum(float num1, float num2)
    {
        return num1 + num2;
    }

    public static float subtraction(float num1, float num2)
    {
        return num1 - num2;
    }

    public static float multiply(float num1, float num2)
    {
        return num1 * num2;
    }

    public static float division(float num1, float num2)
    {
        return num1 / num2;
    }

    /*
    * Escribe un programa que solicite al usuario ingresar tres calificaciones, calcule el promedio y
      muestre un mensaje indicando si el alumno aprueba o no (considera que se aprueba con un
      promedio de 6 o más).*/

    public static void average()
    {
        float note1, note2, note3, average;

        note1 = Float.parseFloat(JOptionPane.showInputDialog( null,"Ingrese la primera nota entre 1 y 10"));
        note2 = Float.parseFloat(JOptionPane.showInputDialog( null,"Ingrese la segunda nota entre 1 y 10"));
        note3 = Float.parseFloat(JOptionPane.showInputDialog( null,"Ingrese la tercera nota entre 1 y 10"));

        average = (note1 + note2 + note3)/3;

        if(average >= 6)
        {
            JOptionPane.showMessageDialog(null,"Aprobaste con un promedio de " + String.format("%.2f", average) + "!!");
            return;
        }

        JOptionPane.showMessageDialog(null,"Reprobaste con un promedio de " + String.format("%.2f", average));

    }

    /*
    * Escribe un programa que le pida al usuario que ingrese un año y determine si es un año bisiesto o
      no. Recuerda que un año es bisiesto si es divisible entre 4, excepto aquellos que son divisibles entre
      100, a menos que también sean divisibles entre 400.*/
    public static void bisiestYear()
    {
        int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año a verificar"));

        boolean isBisiest = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (isBisiest)
        {
            JOptionPane.showMessageDialog(null,"El año" + year + " es Bisiesto");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El año " + year + " NO! es Bisiesto");
        }
    }
}