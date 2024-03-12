import java.util.ArrayList;

public class Inventario {

    private ArrayList<ProductoEspecifico> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    //metodo para añadir producto
    public void agregarProducto(ProductoEspecifico producto){
        this.listaProductos.add(producto);
    }

    //metodo para eliminar producto
    public  boolean  eliminarProducto(int id){
        return listaProductos.removeIf(producto -> producto.getId() == id);
    }

    //metodo para buscar producto por nombre
    public Producto buscarPorNombre(String nombreBuscar){
        for (Producto objProducto : this.listaProductos){
            if (objProducto.getNombre().equalsIgnoreCase(nombreBuscar)){
                return objProducto;
            }
        }
        return null;
    }

    //metodo para listar los productos
    public void listarProductos(){
        for (ProductoEspecifico producto : this.listaProductos){
            System.out.println(String.format("ID #%d | Nombre: %s | Precio: %.2f | Marca: %s | Categoría: %s",
                    producto.getId(), producto.getNombre(), producto.getPrecio(),
                    producto.getMarca(), producto.getCategoria()));
        }
    }

}
