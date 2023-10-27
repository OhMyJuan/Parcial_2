package menu;
import java.util.Scanner;
import tools.Tools;

public class HorariosUbicaciones {
    public static void main() {
        int region;
        Scanner scanner_HU = new Scanner(System.in);

        do {
            Tools.limpiarConsola();

            System.out.println("UBICACIONES");
            System.out.println("    1. Ciudad de Panamá");
            System.out.println("    2. Panamá Oeste");
            System.out.println("    3. Colón");
            System.out.println("    0. Salir");

            region = scanner_HU.nextInt();
        } while (region < 0 || region > 3);

        if (region != 0) {
            menuHU(region);
        }
    }

    public static void menuHU(int region) {
        int selec = region - 1;

        Tools.limpiarConsola();
        System.out.println(regiones[selec]);
        System.out.println("\t" + direccion[selec]);
        System.out.println("\t" + horarios[selec]);
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
}
