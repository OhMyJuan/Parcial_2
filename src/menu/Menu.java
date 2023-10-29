package menu;
/**
 * Clase con la las funciones del menú
 * @author Juan Jurado
 *
 */

import java.util.Scanner;

public class Menu {
    public static void main(int opcion, Scanner sc) {

        // Analiza la opción que se escoje en el menú
        switch (opcion) {
            case 1:
                Venta.main();
                break;

            case 2:
                Pedido.main(null);
                break;

            case 3:
                ServicioCliente.main();
                break;

            case 4:
                HorariosUbicaciones.main();
                break;

            case 5:
                Promociones.main();
                break;

            case 6:
                System.out.print("Hasta pronto!!");
                System.out.println(" ");
                break;
        }

        if (opcion != 6) {
            System.out.println(" ");
            System.out.println("Presionar ENTER para regresar al Menú Principal");
            sc.nextLine();
        }

    }
}