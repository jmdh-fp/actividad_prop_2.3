/*
Crea un programa que busque un texto dado en un fichero de texto, y que muestre para cada aparición
la línea y la columna. Se recomienda leer el fichero línea a línea y, dentro de cada línea,
buscar las apariciones del texto utilizando un método apropiado de la clase String.
Se puede consultar la documentación de dicha clase en la API de Java (http://docs. oracle.com/iavase/8/docs/api).
 */

package org.example;

import java.io.*;

public class Main {
    static final String TEXTO = "caña";
    static final String FICHERO = "D:\\descargas\\elquijote(1).txt";
    public static void main(String[] args) {
        int fila = 1, columna = -1;
        String linea ;
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(FICHERO))){
            while ((linea = bufferedReader.readLine()) != null){
                do {
                   columna = linea.indexOf(TEXTO, columna + 1);
                   if(columna != -1) {
                       System.out.println("Linea: " + fila + " Columna: " + (columna + 1));
                   }
                } while ( columna != -1 && columna <= linea.length() );
                fila++;
            }
        } catch (FileNotFoundException e){
            System.err.println("No se encuentra el fichero: " + new File(FICHERO).getAbsolutePath());

        } catch (IOException e){
            System.err.println("Se ha producido un error durante la lectura del fichero");
        }



    }
}