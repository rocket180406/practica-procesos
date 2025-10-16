package Practica_procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ProcesoPadre {

    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";
    public static final String COMANDOS = "grep psp";
    public static final String MSG = "Estoy en PSP";

    public static void main(String[] args) {

        //Process p = Runtime.getRuntime().exec(java);
        try {
            Process p = Runtime.getRuntime().exec(COMANDOS);
            StringBuilder output = new StringBuilder();
            OutputStream out = p.getOutputStream();
            PrintWriter pw =new PrintWriter(new OutputStreamWriter(out));
            pw.println(MSG);
            pw.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            //Dejamos el programa bloqueado hasta que termine el otro.
            int exitVal = p.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                System.out.println(MSG_ERROR);
                System.exit(1);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(34);
        }
    }
}
/*package Practica_procesos;

import java.io.*;

public class ProcesoPadre {

    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";
    public static final String MSG = "Estoy en PSP";

    public static void main(String[] args) {
        try {
            // Lanza el proceso hijo (otro programa Java)
            // Nota: usa el nombre completo del paquete y asegúrate de estar en el directorio del proyecto compilado
            Process p = Runtime.getRuntime().exec("java Practica_procesos.ProcesoHijo");

            OutputStream out = p.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            // Enviar varias líneas al hijo
            pw.println("Me gusta PSP y java");
            pw.println("PSP se programa en java");
            pw.println("es un módulo de DAM");
            pw.println("y se programa de forma concurrente en PSP");
            pw.println("PSP es programación.");
            pw.close(); // Cerrar la entrada para indicar fin de datos

            // Leer la salida del hijo
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            reader.close();

            int exitVal = p.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
            } else {
                System.err.println(MSG_ERROR);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 */