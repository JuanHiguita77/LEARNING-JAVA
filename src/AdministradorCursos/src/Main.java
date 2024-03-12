import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        GestionCurso gestion = new GestionCurso();
        int option;

        do {
            System.out.println("1 - Administrar Estudiantes");
            System.out.println("2 - Administrar Cursos");
            System.out.println("3 - SALIR");
            option = scanner.nextInt();

            switch (option)
            {
                case 1:
                    int option1;
                    System.out.println("""
                                MENU ADMIN ESTUDIANTES
                                1 - Agregar Estudiante
                                2 - Listar Estudiantes
                                3 - Eliminar por ID
                                4 - SALIR """);
                    option1 = scanner.nextInt();
                    do
                    {
                        switch (option1)
                        {
                            case 1:
                                gestion.listarCursos();
                                System.out.println("Ingrese el codigo del curso donde ingresaras el nuevo estudiante");
                                String codigo =  scanner.next();

                                Curso curso = gestion.buscarCursoPorCodigo(codigo);
                                if (curso == null)
                                {
                                    System.out.println("EL codigo ingresado no es valido");
                                }
                                else
                                {
                                    //Sacamos el metodo de agregar estudiante atravez del curso generado por la consulta
                                    curso.agregarEstudiante(scanner);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el codigo del curso donde ingresaras el nuevo estudiante");
                                codigo =  scanner.next();
                                curso = gestion.listarCursos(scanner);

                                if (curso == null)
                                {
                                    System.out.println("EL codigo ingresado no es valido");
                                }
                                else
                                {
                                    //Sacamos el metodo de agregar estudiante atravez del curso generado por la consulta
                                    curso.listarEstudiantes();
                                }
                                break;

                           /* case 3:
                                System.out.println("Ingrese el codigo a buscar");
                                String codigo = scanner.next();
                                Curso curso = gestion.buscarCursoPorCodigo(codigo);

                                if(curso == null)
                                {
                                    System.out.println("No existe cursos con este codigo");
                                }
                                else
                                {
                                    System.out.println(curso.toString());
                                }

                                break;*/
                            case 4:
                                System.out.println("SALIENDO...");
                                break;
                        }
                    }while(option1 != 4);
                    break;//break del case 1
                case 2:
                    int option2 = 0;

                    do
                    {
                        System.out.println("""
                                MENU ADMIN CURSOS
                                1 - Agregar Curso
                                2 - Listar Cursos
                                3 - Buscar por codigo
                                4 - SALIR """);
                        option2 = scanner.nextInt();

                        switch (option2)
                        {
                            case 1:
                                gestion.agregarCurso(scanner);
                                break;
                            case 2:
                                gestion.listarCursos();
                                break;
                            case 3:
                                System.out.println("Ingrese el codigo a buscar");
                                String codigo = scanner.next();
                                Curso curso = gestion.buscarCursoPorCodigo(codigo);

                                if(curso == null)
                                {
                                    System.out.println("No existe cursos con este codigo");
                                }
                                else
                                {
                                    System.out.println(curso.toString());
                                }

                                break;
                            case 4:
                                System.out.println("SALIENDO...");
                                break;
                        }
                    }while(option2 != 4);
                    break;
                case 3:
                    System.out.println("SALIENDO....");
                    break;
            }
        }while(option != 3);
    }
}