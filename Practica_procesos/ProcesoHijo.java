package Practica_procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesoHijo {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains("psp")) {
                    System.out.println(linea);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}