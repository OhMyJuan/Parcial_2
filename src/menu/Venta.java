/**
 * Clase con las funciones de ventas
 * @author Brian Ojeda
 *
 */

package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venta {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Ventas venta = new Ventas();
        // crear tus productos y agregarlos a la lista 'productos'
        Producto producto = new Producto("Helado", "Postre", 15, 3.67);
        Producto producto1 = new Producto("Hamburguesa", "Comida rapida", 20, 5.29);
        Producto producto2 = new Producto("Ensalada César", "Vegetales", 10, 8.50);

        productos.add(producto);
        productos.add(producto1);
        productos.add(producto2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cotizar productos");
            System.out.println("2. Comprar productos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                // Cotizar productos
                System.out.println("Lista de productos disponibles para cotizar:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println(i + 1 + ". " + productos.get(i));
                }

                System.out.print("Seleccione un producto para cotizar (1-" + productos.size() + "): ");
                int productoIndex = scanner.nextInt();
                if (productoIndex >= 1 && productoIndex <= productos.size()) {
                    Producto productoSeleccionado = productos.get(productoIndex - 1);

                    System.out.print("Ingrese la cantidad que desea cotizar: ");
                    int cantidadCotizar = scanner.nextInt();

                    if (cantidadCotizar <= productoSeleccionado.getCantidadDisponible()) {
                        double totalCotizacion = cantidadCotizar * productoSeleccionado.getPrecioUnitario();
                        System.out.println("Cotización realizada con éxito. Total: $" + totalCotizacion);
                    } else {
                        System.out.println("No hay suficiente cantidad disponible para cotizar.");
                    }
                } else {
                    System.out.println(
                            "Opción no válida. Por favor, seleccione un número entre 1 y " + productos.size() + ".");
                }
            } else if (opcion == 2) {
                // Comprar productos
                System.out.println("Lista de productos disponibles para comprar:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println(i + 1 + ". " + productos.get(i));
                }

                System.out.print("Seleccione un producto para comprar (1-" + productos.size() + "): ");
                int productoIndex = scanner.nextInt();
                if (productoIndex >= 1 && productoIndex <= productos.size()) {
                    Producto productoSeleccionado = productos.get(productoIndex - 1);

                    System.out.print("Ingrese la cantidad que desea comprar: ");
                    int cantidadComprar = scanner.nextInt();

                    if (cantidadComprar <= productoSeleccionado.getCantidadDisponible()) {
                        // Actualizar la cantidad disponible del producto
                        productoSeleccionado
                                .setCantidadDisponible(productoSeleccionado.getCantidadDisponible() - cantidadComprar);

                        // Crear un nuevo item de venta
                        VentaItem itemVenta = new VentaItem(productoSeleccionado, cantidadComprar);
                        venta.agregarItem(itemVenta);

                        System.out.println("Compra realizada con éxito.");
                    } else {
                        System.out.println("No hay suficiente cantidad disponible para comprar.");
                    }
                } else {
                    System.out.println(
                            "Opción no válida. Por favor, seleccione un número entre 1 y " + productos.size() + ".");
                }
            }

            else if (opcion == 3) {
                return; // Salir del bucle
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                scanner.close();
            }
        }

    }
}

// clase para crear los productos
class Producto {
    private String nombre;
    private String categoria;
    private int cantidadDisponible;
    private double precioUnitario;

    public Producto(String nombre, String categoria, int cantidadDisponible, double precioUnitario) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String toString() {
        return nombre + " (" + categoria + ") - Cantidad: " + cantidadDisponible + " - Precio: $" + precioUnitario;
    }
}

class VentaItem {
    private Producto producto;
    private int cantidad;

    public VentaItem(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return producto.getPrecioUnitario() * cantidad;
    }

    public String toString() {
        return producto.getNombre() + " - Cantidad: " + cantidad + " - Total: $" + getTotal();
    }
}

class Ventas {
    private static int numeroVenta = 1;

    private int numero;
    private List<VentaItem> items;

    public Ventas() {
        this.numero = numeroVenta++;
        this.items = new ArrayList<>();
    }

    public void agregarItem(VentaItem item) {
        items.add(item);
    }

    public double getTotalVenta() {
        double total = 0;
        for (VentaItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public int getNumero() {
        return numero;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta #" + numero + "\n");
        for (VentaItem item : items) {
            sb.append(item.toString() + "\n");
        }
        sb.append("Total: $" + getTotalVenta() + "\n");
        return sb.toString();
    }
}
