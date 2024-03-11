import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainProducto
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Producto> listaProductos = new ArrayList<>();

        administrar(scanner, listaProductos);
    }

    public static void administrar(Scanner scanner, List<Producto> listaProductos)
    {
        int option, id = 0, cantidadStock = 0, idDelete;
        String descripcion = "";
        Producto product = new Producto(id, cantidadStock, descripcion);

        try
        {
            do
            {
                System.out.println("ADMIN ALMACEN");
                System.out.println("1 - Ingresar producto nuevo");
                System.out.println("2 - Eliminar Producto por ID");
                System.out.println("3 - Verificar Stock de productos");
                System.out.println("4 - SALIR");
                option = scanner.nextInt();

                switch (option)
                {
                    case 1:
                        System.out.println("Ingrese la descripcion del producto");
                        descripcion = scanner.next();

                        id++;
                        cantidadStock++;

                        product = new Producto(id, cantidadStock, descripcion);
                        product.agregarProducts(listaProductos, product);

                        break;

                    case 2:

                        if (product.getCantidadStock() > 0)
                        {
                            System.out.println("Ingrese el ID del producto a eliminar");
                            idDelete = scanner.nextInt();

                            product.eliminarProducto(listaProductos,idDelete - 1);
                            product.setCantidadStock(listaProductos.size());
                        }
                        else
                        {
                            System.out.println("NO HAY PRODUCTOS EN EL STOCK");
                        }

                        break;

                    case 3:

                        product.verificarStock(listaProductos);

                        break;

                    case 4:

                        System.out.println("SESION FINALIZADA");

                        break;
                }

            }while(option != 4);
        }
        catch (Exception e)
        {
            System.out.println("Ingresaste mal un Dato --- Error: " + e);
            administrar(Scanner scanner, List<Producto> listaProductos);
        }
    }
}
