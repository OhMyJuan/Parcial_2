package menu;
import java.util.Scanner;
import tools.Tools;

public class HorariosUbicaciones {
    public static boolean main() {
        int mi_region;
        Scanner scanner_HU = new Scanner(System.in);
        boolean continuar = false;

        while (!continuar){
            Tools.limpiarConsola();

            System.out.println("UBICACIONES");
            System.out.println("    1. Ciudad de Panamá");
            System.out.println("    2. Panamá Oeste");
            System.out.println("    3. Colón");
            System.out.println("    0. Salir");
            System.out.print("Ingrese la opción: ");

            try {
                mi_region = scanner_HU.nextInt();

                if (mi_region == 0) {
                    continuar = true;
                } else {
                    continuar = menuHU(mi_region);
                }

            } catch (java.util.InputMismatchException e) {
                Tools.limpiarConsola();
                System.out.print("Debe ingresar un valor válido!!");
                scanner_HU.nextLine();
            }
        }

        return false;
    }

    public static boolean menuHU(int region) {
        if (region < 0 || region > 3) {
            Tools.limpiarConsola();
            return false;
        } else {
            int selec = region - 1;

            Tools.limpiarConsola();
            System.out.println(regiones[selec]);
            System.out.println("\t" + direccion[selec]);
            System.out.println("\t" + horarios[selec]);
            System.out.println("\t" + telefonos[selec]);
            return true;
        }
    }

    static String[] regiones = {
        "CIUDAD DE PANAMÁ",
        "PANAMÁ OESTE",
        "COLÓN"
    };

    static String[] direccion = {
        "Coco del Mar, Calle Esther Neira de Calvo, Panamá",
        "Plaza Nuevo Arraiján, Carretera Panamericana, Panamá Oeste",
        "Centro Comercial Cuatro Altos, Colón"
    };

    static String[] horarios = {
        "8:00 a.m. - 5:00 p.m.  De Lunes a Viernes\n\t8:00 a.m. - 2:00 p.m. Sábados",
        "8:00 a.m. - 5:00 p.m.  De Lunes a Viernes\n\t8:00 a.m. - 12:00 p.m. Sábados",
        "8:00 a.m. - 5:00 p.m.  De Lunes a Viernes",
    };

    static String[] telefonos = {
        "(+507) 200-0000",
        "(+507) 211-1111",
        "(+507) 233-3333"
    };
}
