package menu;
/**
 * Clase con la las funciones del menú
 * @author Juan Jurado
 *
 */

import java.util.Scanner;

public class Menu {
    public static boolean main(int opcion, Scanner sc) {
        boolean estado;

        // Analiza la opción que se escoje en el menú
        switch (opcion) {
            case 1:
                estado = Venta.main();
                break;

            case 2:
                estado = Pedido.main();
                break;

            case 3:
                estado = ServicioCliente.main();
                break;

            case 4:
                estado = HorariosUbicaciones.main();
                break;

            case 5:
                estado = Promociones.main();
                break;

            case 6:

                estado = Salir.main();
                break;

            default:
                estado = false;
                break;
        }

        return estado;
    }
}