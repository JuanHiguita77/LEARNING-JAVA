import java.util.ArrayList;
import java.util.List;

public class Producto
{
    /*Control de Stock: Crea un sistema para gestionar el stock de productos en
    un almacén. Deberás tener una clase Producto con atributos como id,
    descripción, cantidad en stock. Añade métodos para agregar o quitar
    productos del stock, y para verificar la cantidad actual de un producto.*/

    private int id, cantidadStock;
    private String descripcion;

    public Producto(int id, int cantidadStock, String descripcion) {
        this.id = id;
        this.cantidadStock = cantidadStock;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock)
    {
        this.cantidadStock = cantidadStock;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void agregarProducts(List<Producto> stock, Producto producto)
    {
        stock.add(producto);
        System.out.println("Producto agregado ---> " + producto.getDescripcion());
    }

    public void eliminarProducto(List<Producto> stock, int id)
    {

        stock.remove(id);
        System.out.println("Elemento #" + (this.getId()-1) + " eliminado!");

    }

    public void verificarStock(List<Producto> stock)
    {
        int i = 1;
        System.out.println("Cantidad en el stock: " + this.getCantidadStock());

        for(Producto product : stock)
        {
            System.out.println("ID #" + i++ +  " --- Descripcion: " + product.getDescripcion());
        }
    }
}
