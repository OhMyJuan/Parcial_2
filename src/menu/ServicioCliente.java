package menu;

import java.util.Scanner;
import tools.Tools;

public class ServicioCliente {
    public static void main() {

        Scanner scanner_ServicioCliente = new Scanner(System.in);
        String pregunta;
        String respuesta;

        Tools.limpiarConsola();

        System.out.println("Agente de Servicio al Cliente:\n\t  Bienvenido al Servicio al Cliente. ¿En qué puedo ayudarte?");
        do {
            do {
                System.out.print("Tú:\t");
                pregunta = scanner_ServicioCliente.nextLine();
            } while (pregunta.length() == 0);

            respuesta = responderPreguntaDelCliente(pregunta);

            System.out.println("Agente de Servicio al Cliente:\n\t" + respuesta);
            System.out.print("\t¿Tienes alguna otra pregunta? (Sí/No):\nTú:\t");
        } while (scanner_ServicioCliente.nextLine().equalsIgnoreCase("si"));
    }

    public static String responderPreguntaDelCliente(String pregunta) {
        if (pregunta.contains("horarios")) {
            return "Para consultar detalladamente el horario de nuestras sucursales le recomendamos ingresar en la sección Horarios y Ubicaciones";
        } else if (pregunta.contains("ubicacion") || pregunta.contains("sucursal")) {
            return "Tenemos sucursales en la Ciudad de Panamá, Panamá Oeste y Colón\n\tMás información sobre esto en la sección Horarios y Ubicaciones";
        } else if (pregunta.contains("garantia") || pregunta.contains("devolucion") || pregunta.contains("devolver")) {
            return "Para información sobre garantías le recomendamos llamar a nuestos teléfonos";
        } else {
            return "Lo siento, no tengo la información que necesitas. Por favor, contáctanos a los números de telefonos en la sección de Horarios y Ubicaciones";
        }
    }
}
