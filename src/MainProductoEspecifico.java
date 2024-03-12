import java.util.Scanner;

public class MainProductoEspecifico
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ProductoEspecifico producto;
        Inventario inventario = new Inventario();

        int opcion, id = 0, idEliminar;
        String nombre, categoria, marca, nombreBuscar;
        double precio;

        do
        {
            try
            {
                System.out.println("--PRODUCTOS SAS--");
                System.out.println("1 - Ingresar producto");
                System.out.println("2 - Eliminar producto");
                System.out.println("3 - Buscar producto");
                System.out.println("4 - Listar productos");
                System.out.println("5 - CERRAR SESION");
                opcion = scanner.nextInt();

                switch (opcion)
                {
                    case 1:
                        System.out.println("Ingrese el nombre del producto: ");
                        nombre = scanner.next();

                        System.out.println("Ingrese el precio del producto: ");
                        precio = scanner.nextDouble();

                        System.out.println("Ingrese la categoria del producto: ");
                        categoria = scanner.next();

                        System.out.println("Ingrese la marca del producto: ");
                        marca = scanner.next();

                        id++;

                        producto = new ProductoEspecifico(id, nombre, precio, categoria, marca);
                        inventario.agregarProducto(producto);

                        break;

                    case 2:
                        System.out.println("Ingrese el id del producto a eliminar");
                        idEliminar = scanner.nextInt();

                        inventario.eliminarProducto(idEliminar);
                        break;

                    case 3:
                        System.out.println("Ingrese el nombre del producto a buscar");
                        nombreBuscar = scanner.next();

                        System.out.println(inventario.buscarPorNombre(nombreBuscar));

                        break;

                    case 4:
                        inventario.listarProductos();
                        break;

                    case 5:
                        System.out.println("SALIENDO...");
                        break;

                }
            }
            catch (Exception e)
            {
                System.out.println("Ingresaste mal un dato");
                scanner.next();
                opcion = 0;
            }
        }while(opcion != 5);

        scanner.close();

    }
}
