package Catalogo_Productos_Ecommerce;

import java.util.HashMap;
import java.util.TreeSet;

public class Ecommerce {
    private HashMap<String, Producto> catalogo = new HashMap<>();
    private TreeSet<Producto> productosOrdenados = new TreeSet<>();

    public void agregarProducto(Producto producto){
        catalogo.put(producto.getCodigo(), producto);
        productosOrdenados.add(producto);
    }

    public Producto buscarProducto(String codigo){
        if(catalogo.containsKey(codigo)){
            return catalogo.get(codigo);
        } else {
            System.out.println("Producto no encontrado con código: " + codigo);
            return null;
        }
    }

    public void mostrarProductosOrdenados() {
        for (Producto producto : productosOrdenados) {
            System.out.println(producto);
        }
    }
}
