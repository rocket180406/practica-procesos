package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ProcesoPadre {

    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";

    public static final String[] COMANDOS = { "grep", "psp" };

    public static final String MSG = "Me gusta PSP y java\r\n" + //
            "PSP se programa en java\r\n" + //
            "es un módulo de DAM\r\n" + //
            "y se programa de forma concurrente en PSP\r\n" + //
            "PSP es programación.";

    public static final String MSG_EXITO = "Se ha procesado con éxito";

    public static void main(String[] args) {

        try {
            Process p = Runtime.getRuntime().exec(COMANDOS);
            StringBuilder output = new StringBuilder();
            OutputStream out = p.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            pw.println(MSG);
            pw.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitVal = p.waitFor();
            if (exitVal == 0) {
                System.out.println(MSG_EXITO);
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