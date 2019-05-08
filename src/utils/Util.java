/**
 * Clase que contiene las funciones útiles para el programa
 * @autor Jairo A. Valencia
 * @date 02-may-2019
 * @version 1.0
 */

package utils;

import java.io.*;

public class Util {

    /**
     * Imprime en consola un texto
     * @param menu Texto como parámetro
     */
    public static void printMenu(String menu){
        System.out.print(menu);
    }

    /**
     * Reemplaza el comando en el menú de comando inválido
     * @param invalidCommand comando
     * @return menú para imprimir
     */
    public static String printInvalidMenu(String invalidCommand){
        String menu = Text.INVALID_COMMAND_ARGUMENTS_MENU;
        menu = menu.replaceAll(Constants.INVALID_COMMAND_STR, invalidCommand);
        return menu;
    }

    /**
     * Lee un archivo
     * @param path Ruta del archivo
     * @return Contenido del archivo
     */
    public static String readFile(String path){
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder content = new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                content.append(line);
            };

            bufferedReader.close();
            fileReader.close();

            return content.toString();

        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
            return null;
        }catch (Exception e){
            System.out.println("Error desconocido: " + e.getMessage());
            return null;
        }
    }

    /**
     * Crea y escribe en un archivo nuevo
     * @param fileName Nombre del archivo
     * @param content Contenido
     */
    public static void writeFile(String fileName, String content){
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("test_results/" + fileName));
            try {
                bufferedWriter.write(content);
            } catch (Exception e) {
                System.out.println("Error escribiendo en archivo. " + e.getMessage());
            } finally {
                bufferedWriter.close();
            }
        }catch (Exception e){
            System.out.println("Error creando archivo. " + e.getMessage());
        }
    }

    public static boolean isInteger(String expression){
        try{
            Integer.parseInt(expression);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
