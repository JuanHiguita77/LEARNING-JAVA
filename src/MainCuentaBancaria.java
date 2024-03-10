import java.util.Scanner;
public class MainCuentaBancaria
{
        /*Cuenta Bancaria: Implementa una clase CuentaBancaria con los atributos
    titular y balance. Añade métodos para depositar dinero, retirar dinero (no
    permitas que el balance se vuelva negativo) y mostrar el balance actual.*/
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        banco(scanner);
    }

    public static void banco(Scanner scanner)
    {
        CuentaBancaria banco = new CuentaBancaria();

        String titular;
        double dinero;
        int option;

        System.out.println("Ingrese el nombre del titular de la cuenta: ");
        titular = scanner.nextLine();
        banco.setTitular(titular);

        do
        {
            System.out.println("BANCO EL CUERVO");
            System.out.println("1 - Ingresar  dinero");
            System.out.println("2 - Retirar  dinero");
            System.out.println("3 - CERRAR SESION");
            option = scanner.nextInt();

            switch (option)
            {
                case 1:
                        System.out.println("Ingrese la cantidad a Depositar");
                        dinero = scanner.nextDouble();

                        banco.depositar(dinero);
                    break;

                case 2:
                        System.out.println("Ingrese la cantidad a Retirar");
                        dinero = scanner.nextDouble();

                        banco.retirar(dinero);
                    break;

                case 3:
                        System.out.println("SESION FINALIZADA");
                        banco.info();
                    break;
            }
        }while(option != 3);

    }
}