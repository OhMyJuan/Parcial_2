package tools;

public class Tools {
    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Si estás en Windows, utiliza "cls" para borrar la consola.
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // En otros sistemas, utiliza escape codes ANSI para borrar la consola.
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        titulo();
    }

    public static void titulo() {
        System.out.println("----|   ASISTENCIA DE XXXX  |----");
        System.out.println(" ");
    }
}
