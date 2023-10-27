/**
 * Programa para la empresa XXXX que
 */

import java.util.Scanner;

import menu.Menu;
import tools.Tools;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int opcion;

        Tools.limpiarConsola();

        do {
            System.out.print("Ingrese su nombre: ");
            nombre = sc.nextLine();
        } while (nombre.length() == 0);


        do {
            Tools.limpiarConsola();

            System.out.println("MENÚ PRINCIPAL");
            System.out.println("    1. Ventas");
            System.out.println("    2. Consulta de Pedido");
            System.out.println("    3. Servicio al Cliente");
            System.out.println("    4. Horario y Ubicaciones");
            System.out.println("    5. Promociones");
            System.out.println("    6. Salir");

            opcion = sc.nextInt();
            Tools.limpiarConsola();

            Menu.main(opcion, sc);

            if (opcion != 6) {
                sc.nextLine();
            }
        } while (opcion != 6);

        sc.close();
    }

}
