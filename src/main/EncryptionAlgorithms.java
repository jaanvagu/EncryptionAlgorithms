/**
 * Clase principal que muestra los menús correspondientes a cada algoritmo y las opciones de ayuda
 * @autor Jairo A. Valencia
 * @date 01-may-2019
 * @version 1.0
 */

package main;

import crypto.Playfair;
import utils.Constants;
import utils.Text;
import utils.Util;

public class EncryptionAlgorithms {

    /**
     * Evalua los arguemntos recibidos y e invoca el menú correspondiente
     * @param args Argumentos recibidos por consola
     * @return Menú para imprimir
     */
    private static String evaluateInitialArguments(String[] args){
        //No argumentos
        if(Constants.NUMBER_0 == args.length){
            return Text.NO_ARGUMENTS_MENU;
        }
        //1 argumento
        else if(Constants.NUMBER_1 == args.length){
            if(Constants.HELP_ARGUMENT.equals(args[0]))
                return Text.HELP_MENU;
            else if(Constants.PLAYFAIR.equals(args[0]))
                return Text.PLAYFAIR_MENU;
            else if(Constants.ANALISIS_FRECUENCIA.equals(args[0]))
                return Text.ANALISIS_FREC_POLI_MENU;
            else
                return Util.printInvalidMenu(args[0]);
        }
        else if(Constants.PLAYFAIR == args[0]){
            return evaluatePlayfair(args);
        }
        else if(Constants.ANALISIS_FRECUENCIA == args[0]){
            return evaluateAnalisisFrecPoli(args);
        }
        //>1 argumento
        else{
            int lastPos = args.length - 1;
            return Util.printInvalidMenu(args[lastPos]);
        }
    }

    /**
     *
     * @param args
     * @return
     */
    private static String evaluatePlayfair(String[] args){
        System.out.println("Iniciando playfair...");
        String outFIleName ;
        if ("-c".equals(args[1])) {
            outFIleName = args[2] + ".cif";
            String crypto = Playfair.encode(Util.readFile(args[2]), Util.readFile(args[4]));
            Util.writeFile(outFIleName, crypto);
        }
        else {
            outFIleName = args[2] + ".dec";
            String dsc = Playfair.decode(Util.readFile(args[2]), Util.readFile(args[4]));
            Util.writeFile(outFIleName, dsc);
        }

        return "Proceso finalizado";
    }

    /**
     *
     * @param args
     * @return
     */
    private static String evaluateAnalisisFrecPoli(String[] args){
        //Util.readFile("test_data/MOBY_DICK_Original.txt");
        //Util.readFile("test_data/DON_QUIJOTE_Original.txt");

        Util.writeFile("prueba",Util.readFile("test_data/DON_QUIJOTE_Original.txt"));
        return "Evaluando Análisis frecuencia";
    }

    /**
     * Método principal que recibe los parámetros para ejecutar el programa de cifrado
     * @param args Argumentos y banderas
     */
    public static void main(String[] args) {

        //DON_QUIJOTE: 1.640.665
        //MOBY_DICK:     966.800

        //String[] arguments = {"help"};
        //String[] arguments = {"pf"};

        String[] arguments = {"pf", "-d", "test_data/DON_QUIJOTE_Original.txt.cif", "-k", "test_data/key.txt"};

        args = arguments;

        try {
            Util.printMenu(EncryptionAlgorithms.evaluateInitialArguments(args));
        }catch (Exception e){
            Util.printMenu(Text.GENERAL_ERROR);
        }
    }
}
