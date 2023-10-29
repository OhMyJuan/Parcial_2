/**
 * Clase con la las funciones del Pedido
 * @author Brian Ojeda
 *
 */
package menu;

import java.util.Scanner;

public class Pedido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Estos son los pedidos disponibles");
        System.out.println("    1. Hamburguesa");
        System.out.println("    2. Helado");
        System.out.println("    3. Pizza");
        System.out.println("    0. Salir");
        int numPedido;
        String salir;
        GestorPedidos gestor = new GestorPedidos();

        do {
            System.out.print("Ingrese un número para ver el detalle del pedido: ");
            numPedido = sc.nextInt();
            if (numPedido == 0) return;
            // Llamamos a la función detalles y obtenemos un objeto CrearPedidos
            CrearPedidos pedido = detalles(numPedido, gestor);
            if (pedido != null) {
                String detalles = gestor.detallesPedido(pedido);
                System.out.print(detalles);
            } else {
                System.out.println("No se encontró el pedido.");
            }
            System.out.print("\nDesea ver otro pedido? Si/No: ");
            salir = sc.next();
            if (!salir.equals("Si")) return;
        } while ((numPedido >= 1 && numPedido <= 3));
        sc.close();

    }

    // implementar la función para obtener los detalles del pedido
    public static CrearPedidos detalles(int numPedido, GestorPedidos gestor) {
        CrearPedidos pedido = gestor.crearPedido(1, "Brian", "Hamburguesa", 100.40);

        CrearPedidos pedido1 = gestor.crearPedido(2, "Juan", "Helado", 45.2);
        CrearPedidos pedido2 = gestor.crearPedido(3, "Boris", "Pizza", 19.67);

        CrearPedidos[] pedidos = { pedido, pedido1, pedido2 };
        for (CrearPedidos p : pedidos) {
            if (p.getId() == numPedido) {
                return p;
            }
        }

        return null;
    }

    public static class CrearPedidos {
        private int id;
        private String cliente;
        private String pedido;
        private double total;

        public CrearPedidos(int id, String cliente, String pedido, double total) {
            this.id = id;
            this.cliente = cliente;
            this.pedido = pedido;
            this.total = total;
        }

        public int getId() {
            return id;
        }

        public String getCliente() {
            return cliente;
        }

        public String getPedido() {
            return pedido;
        }

        public double getTotal() {
            return total;
        }

    }

    public static class GestorPedidos {
        public CrearPedidos crearPedido(int id, String cliente, String pedido, double total) {
            CrearPedidos nuevoPedido = new CrearPedidos(id, cliente, pedido, total);
            return nuevoPedido;
        }

        public String detallesPedido(CrearPedidos pedido) {
            String detalles = "ID: " + pedido.getId() + "\n";
            detalles += "Cliente: " + pedido.getCliente() + "\n";
            detalles += "Pedido: " + pedido.getPedido() + "\n";
            detalles += "Total: " + pedido.getTotal() + "\n";
            return detalles;
        }
    }

}
