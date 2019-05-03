/**
 * Clase principal que muestra los men&uacute;s correspondientes a cada algoritmo y las opciones de ayuda
 * @autor Jairo A. Valencia
 * @date 01-may-2019
 * @version 1.0
 */

package main;

import utils.Constants;
import utils.Text;
import utils.Util;

public class EncryptionAlgorithms {


    /**
     * Método principal que recibe los parámetros para ejecutar el programa de cifrado
     * @param args Arguemntos tipo bandera
     */
    public static void main(String[] args) {

        if(Constants.NUMBER_0 == args.length){
            Util.printMenu(Text.INITIAL_MENU);
        }
    }
}
