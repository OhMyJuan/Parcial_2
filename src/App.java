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
        boolean salir = false;

        Tools.limpiarConsola();

        do {
            System.out.print("Ingrese su nombre: ");
            nombre = sc.nextLine();
        } while (nombre.length() == 0);


        while (!salir) {

            Tools.limpiarConsola();

            System.out.println("MENÚ PRINCIPAL");
            System.out.println("    1. Ventas");
            System.out.println("    2. Consulta de Pedido");
            System.out.println("    3. Servicio al Cliente");
            System.out.println("    4. Horario y Ubicaciones");
            System.out.println("    5. Promociones");
            System.out.println("    6. Salir");
            System.out.print("Ingrese la opción: ");

            try {
                opcion = sc.nextInt();

                Tools.limpiarConsola();

                if (opcion <= 6 && opcion >= 0) {
                    salir = Menu.main(opcion, sc);
                }

                if (opcion != 6) {
                    sc.nextLine();
                }

            } catch (java.util.InputMismatchException e) {
                Tools.limpiarConsola();
                System.out.println("Debe ingresar un valor válido!!");
            } finally {
                if (salir == false) {
                    System.out.println("Presione ENTER para continuar");
                    sc.nextLine();
                }
            }

        }

        sc.close();
    }

}
