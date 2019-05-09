/**
 * Clase principal que muestra los menús correspondientes a cada algoritmo y las opciones de ayuda
 * @autor Jairo A. Valencia
 * @date 01-may-2019
 * @version 1.0
 */

package main;

import crypto.Playfair;
import analysis.AnalysisPolyalphaFreq;
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
        else if(Constants.PLAYFAIR.equals(args[0])){
            return evaluatePlayfair(args);
        }
        else if(Constants.ANALISIS_FRECUENCIA.equals(args[0])){
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
     * Verifica que los parámatros para realizar el análsis por frecuencia sean correctos e invoca la clase que
     * realiza el análisis
     * @param args
     * @return
     */
    private static String evaluateAnalisisFrecPoli(String[] args){
        if(Constants.NUMBER_6 == args.length) {
            boolean correctArguments = false;
            //Clase que procesa el análisis
            AnalysisPolyalphaFreq analysisPolyalphaFreq = new AnalysisPolyalphaFreq();
            //Valida que exista el lenguaje ingresado
            if (analysisPolyalphaFreq.existLanguage(args[1])) {
                //Valida bandera "in"
                if (Constants.IN_ARGUMENT.equals(args[2])) {
                    //Valida bandera "frec"
                    if (Constants.FREC_ARGUMENT.equals(args[4])) {
                        //Valida que el parámetro frec sea entero
                        if(Util.isInteger(args[5])){
                            correctArguments = true;
                            String text = Util.readFile(args[3]);
                            return analysisPolyalphaFreq.executeAnalysis(args[1], text, args[5]);
                        }
                    }
                }
            }
            if(correctArguments == false){
                return Text.INVALID_ARGUMENTS_AFP;
            }
        }else{
            int lastPos = args.length - 1;
            return Util.printInvalidMenu(args[lastPos]);
        }
        return null;
    }

    /**
     * Método principal que recibe los parámetros para ejecutar el programa de cifrado
     * @param args Argumentos y banderas
     */
    public static void main(String[] args) {

        //DON_QUIJOTE: 1.640.665
        //MOBY_DICK:     966.800


        String[] arguments = {"afp", "-e", "in", "test_data/DON_QUIJOTE_Original.txt", "frec", "1"};
        //String[] arguments = {"afp", "-e", "in", "test_data/MOBY_DICK_Original.txt", "frec", "1"};
        //String[] arguments = {"afp", "-e", "in", "test_data/tildes.txt", "frec", "1"};
        //String[] arguments = {"afp", "-e", "in", "test_data/prueba.txt", "frec", "1"};

        //args = arguments;

        try {
            Util.printMenu(EncryptionAlgorithms.evaluateInitialArguments(args));
        }catch (Exception e){
            Util.printMenu(Text.GENERAL_ERROR);
            e.printStackTrace();
        }
    }
}
