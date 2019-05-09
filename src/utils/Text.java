/**
 * Clase que contiene los textos que se desplegaran en cada uno de los menús de ayuda y ejecución
 * @autor Jairo A. Valencia
 * @date 02-may-2019
 * @version 1.0
 */

package utils;

public class Text {

    /* Menú ayuda incial */
    public static final String NO_ARGUMENTS_MENU =
            "Sintaxis: java -jar EncryptionAlgorithms.jar <algoritmo> [argumentos...]\n\n" +
            "Consulte 'java -jar EncryptionAlgorithms.jar help' para ver los subcomandos disponibles\n" +
            "Consulte 'java -jar EncryptionAlgorithms.jar <algoritmo>' para leer sobre un subcomando específico.\n"
            + "";

    /* Menú de comandos inválidos */
    public static final String INVALID_COMMAND_ARGUMENTS_MENU =
            "Comando inválido '" + Constants.INVALID_COMMAND_STR + "'; " +
            "Consulte 'java -jar EncryptionAlgorithms.jar help' para ver los subcomandos disponibles\n";

    /* Menú ayuda */
    public static final String HELP_MENU =
        "" +
        "        |----------------------Algoritmo y Análisis de Cifrado--------------------|\n" +
        "        |                                                                         |\n" +
        "        |     Sintaxis: java -jar EncryptionAlgorithms.jar <algoritmo>            |\n" +
        "        |                                                                         |\n" +
        "        |     Algoritmos:                                                         |\n" +
        "        |     pf      Algoritmo Playfair                                          |\n" +
        "        |     afp     Análisis por frecuencia polialfabética                      |\n" +
        "        |                                                                         |\n" +
        "        |     Consulte 'java -jar EncryptionAlgorithms.jar <algoritmo>'           |\n" +
        "        |     para leer sobre un subcomando específico                            |\n" +
        "        |                                                                         |\n" +
        "        |                                                                         |\n" +
        "        |     Universidad Autónoma de Occidente                                   |\n" +
        "        |     Especialización en Seguridad Informática                            |\n" +
        "        |     Certificados y Firmas Digitales                                     |\n" +
        "        |     Siler Amador Donado                                                 |\n" +
        "        |     2019                                                                |\n" +
        "        |                                                                         |\n" +
        "        |     Autores: Edson Ruiz          edson921109@hotmail.com                |\n" +
        "        |              Jairo A. Valencia   jaanvagu@gmail.com                     |\n" +
        "        |                                                                         |\n" +
        "        |                                                                         |\n" +
        "        |     Código fuente y archivos de prueba:                                 |\n" +
        "        |     https://github.com/jaanvagu/EncryptionAlgorithms                    |\n" +
        "        |                                                                         |\n" +
        "        |-------------------------------------------------------------------------|\n"
        +"";

    /* Menú Playfair */
    public static final String PLAYFAIR_MENU =
        "" +
        "        |----------------------------------------Playfair-----------------------------------------------|\n" +
        "        |                                                                                               |\n" +
        "        |     Sintaxis:                                                                                 |\n" +
        "        |     java -jar EncryptionAlgorithms.jar pf [opción] in <ArchivoEntrada> key <ArchivoClave>     |\n" +
        "        |                                                                                               |\n" +
        "        |     Opciones:                                                                                 |\n" +
        "        |     -c     Cifrar                                                                             |\n" +
        "        |     -d     Descifrar                                                                          |\n" +
        "        |                                                                                               |\n" +
        "        |     ArchivoEntrada: Nombre del archivo                                                        |\n" +
        "        |     ArchivoClave:   Nombre del archivo que contiene la clave para cifrar y descifrar          |\n" +
        "        |                                                                                               |\n" +
        "        |     Nota: Los archivos deben estar codificados en UTF-8 sin BOM                               |\n" +
        "        |                                                                                               |\n" +
        "        |     Salida: Genera un archivo con la extensión .cif si la opción es cifrar                    |\n" +
        "        |             y un archivo .des si la opción es descifrar.                                      |\n" +
        "        |                                                                                               |\n" +
        "        |-----------------------------------------------------------------------------------------------|\n"
        +"";

    /* Menú Análisis frecuencia polialfabética */
    public static final String ANALISIS_FREC_POLI_MENU =
        "" +
        "        |-----------------------------Análsis por Frecuencia Polialfabética-----------------------------|\n" +
        "        |                                                                                               |\n" +
        "        |     Sintaxis:                                                                                 |\n" +
        "        |     java -jar EncryptionAlgorithms.jar afp in <ArchivoEntrada> tng <TamañoNgrama>             |\n" +
        "        |                                                                                               |\n" +
        "        |     ArchivoEntrada: Nombre del archivo                                                        |\n" +
        "        |     TamañoNgrama:   Cantidad de letras agrupadas para contar su frecuencia de aparición       |\n" +
        "        |                                                                                               |\n" +
        "        |     Nota: Los archivos deben estar codificados en UTF-8 sin BOM                               |\n" +
        "        |                                                                                               |\n" +
        "        |     Salida: Imprime en consola las frecuencias para cada conjunto de caracteres.              |\n" +
        "        |                                                                                               |\n" +
        "        |-----------------------------------------------------------------------------------------------|\n"
        +"";

    /* Error general */
    public static final String GENERAL_ERROR = "No se reconoce el comando." +
            "\nConsulte 'java -jar EncryptionAlgorithms.jar help' para ver los subcomandos disponibles.\n";

    /* Menú ayuda incial */
    public static final String INVALID_ARGUMENTS_AFP =
            "Sintaxis inválida para Análisis por frecuencia polialfabética.\n" +
            "Consulte 'java -jar EncryptionAlgorithms.jar afp' para leer sobre este subcomando.\n"
            + "";
}
