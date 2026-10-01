package Plataforma_Ventas_Masivas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Ventas {
    private HashMap<String, Producto> productosCodigo = new HashMap<>();
    private LinkedList<Producto> productos = new LinkedList<>();
    private TreeSet<Producto> productosOrdenados = new TreeSet<>();
    private HashMap<String, List<Producto>> productosCategoria = new HashMap<>();

    public void agregarProducto(Producto producto) {
        productos.addFirst(producto);
        productosCodigo.put(producto.getCodigo(), producto);
        productosOrdenados.add(producto);
        productosCategoria.computeIfAbsent(producto.getCategoria(), k -> new ArrayList<>()).add(producto);
    }

    public Producto buscarPorCodigo(String codigo) {
        return productosCodigo.get(codigo);
    }

    public void mostrarProductosOrdenados() {
        for (Producto producto : productosOrdenados){
            System.out.println(producto);
        }
    }

    public void filtrarPorCategoria(String categoria) {
        List<Producto> listaCategoria = productosCategoria.get(categoria);
        if (listaCategoria != null) {
            for (Producto producto : listaCategoria) {
                System.out.println(producto);
            }
        } else {
            System.out.println("No se encontraron productos en la categoría: " + categoria);
        }

    }
}