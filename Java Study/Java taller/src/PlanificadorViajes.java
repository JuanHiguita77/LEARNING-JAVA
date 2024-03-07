import java.util.Scanner;
import java.util.ArrayList;

/*
* Planificador de Viajes:
*
*   Escribe un programa para ayudar a planificar viajes por
    carretera. Los usuarios pueden ingresar varias ciudades que planean visitar en
    orden. Utiliza un arreglo de String para almacenar las ciudades. El programa debe
    ser capaz de:
    *
     Añadir y remover ciudades del itinerario.
    *
     Mostrar la lista completa de ciudades a visitar.
    *
     (Opcional) Calcular la distancia total del viaje asumiendo distancias ficticias entre
    ciudades consecutivas.*/
public class PlanificadorViajes
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cities = new ArrayList<>();

        String city;
        int idCity, option = 0;

        do
        {
            try
            {
                System.out.println("---RIWI VIAJES---");
                System.out.println("1 -- Agregar nueva ciudad");
                System.out.println("2 -- Borrar ciudad por ID");
                System.out.println("3 -- Borrar ciudad por nombre");
                System.out.println("4 -- Mostrar lista de ciudades");
                System.out.println("5 -- Terminar Itinerario");
                System.out.print("Ingresa la opcion --> ");
                option = scanner.nextInt();

                switch (option)
                {
                    case 1:

                        System.out.println("Ingrese la ciudad de destino");
                        city = scanner.next().toLowerCase();

                        //Agregamos ciudades
                        addCity(city, cities);
                        break;

                    case 2:

                        System.out.println("Ingrese el numero de la ciudad");
                        idCity = scanner.nextInt() - 1;

                        if ((idCity+1) > cities.size())
                        {
                            System.out.println("Ingresaste un ID inexistente!");
                            break;
                        }

                        //Eliminar por id
                        deleteCityById(idCity, cities);
                        break;

                    case 3:

                        System.out.println("Ingrese el nombre de la ciudad a eliminar");
                        city = scanner.next().toLowerCase();

                        deleteCityByName(city, cities);
                        break;

                    case 4:

                        cityList(cities);
                        break;

                    case 5:
                        System.out.println("ITINERARIO DE VIAJE TERMINADO");
                        break;

                    default:
                        System.out.println("Ingresaste una opción incorrecta!!");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Ingresas mal un dato");
            }
        }while(option != 5);
    }

    public static void addCity(String city, ArrayList cities)
    {
        //Añadiendo ciudades a la lista
        cities.add(city);
    }

    public static void deleteCityById(int cityIndex, ArrayList cities)
    {
        //Eliminando ciudades a la lista
        cities.remove(cityIndex);
    }

    public static void deleteCityByName(String cityName, ArrayList cities)
    {
        //Eliminando ciudades a la lista
        cities.remove(cityName);
    }

    public static void cityList(ArrayList cities)
    {
        int index = 1;

        System.out.println("---CIUDADES ACTUALES EN EL ITINERARIO---");
        for (Object cityLoaded : cities)
        {
            System.out.println("#" + index + "---" + cityLoaded);
            index++;
        }
    }
}
