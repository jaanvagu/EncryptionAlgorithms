/*
  Clase que contiene los metodos necesarios para el funcionamiento del algoritmo Playfair
  @autor Edson Ruiz Ramirez
  @date 07-may-2019
  @version 1.0
 */

package crypto;

import java.awt.*;
import java.util.Scanner;

public class Playfair {
    private static char[][] charTable;
    private static Point[] positions;

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = prompt("Enter an encryption key (min length 5): ", sc, 5);
        String txt = prompt("Enter the message: ", sc, 1);
        //String key = "cuatro";
        //String txt = "solosequenadase";
        createTable(key);

        String enc = encode(prepareText(txt));
        System.out.println("Encode: \n" + enc);

        String dec = decode(enc);
        System.out.println("Decode: \n" + dec);
        //System.out.printf("%nEncoded message: %n%s%n", enc);
        //System.out.printf("%nDecoded message: %n%s%n", decode(enc));
    }*/

    private static String prompt(String promptText, Scanner sc, int minLen) {
        String s;
        do {
            System.out.print(promptText);
            s = sc.nextLine().trim();
        } while (s.length() < minLen);
        return s;
    }

    /**
     * Prepara el texto que se usara en el proceso
     * @param text Texto a preparar
     * @return Texto preparado
     */
    private static String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        text = text.replace("Ñ", "N");
        text = text.replace("J", "I");
        return text;
    }

    /**
     * Crea la matriz base para el proceso
     * @param key Clave que se usara para crear la matriz
     */
    private static void createTable(String key) {
        charTable = new char[5][5];
        positions = new Point[26];

        String s = prepareText(key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        int len = s.length();
        for (int i = 0, k = 0; i < len; i++) {
            char c = s.charAt(i);
            if (positions[c - 'A'] == null) {
                charTable[k / 5][k % 5] = c;
                positions[c - 'A'] = new Point(k % 5, k / 5);
                k++;
            }
        }
    }

    /**
     * Proceso que cifra el texto recibido
     * @param txt Texto a cifrar
     * @param key Clave
     * @return Texto cifrado
     */
    public static String encode(String txt, String key) {
        createTable(key);
        txt = prepareText(txt);
        StringBuilder sb = new StringBuilder(txt);

        for (int i = 0; i < sb.length(); i += 2) {

            if (i == sb.length() - 1)
                sb.append(sb.length() % 2 == 1 ? 'X' : "");

            else if (sb.charAt(i) == sb.charAt(i + 1))
                sb.insert(i + 1, 'X');
        }
        return codec(sb, 1);
    }

    /**
     * Proceso que descifra el criptograma recibido
     * @param s Criptograma a descifrar
     * @param key Clave
     * @return Texto descifrado
     */
    public static String decode(String s, String key) {
        createTable(key);
        return codec(new StringBuilder(s), 4);
    }

    /**
     * Cifra o descifra de acuerdo a la direccion recibida
     * @param text Texto claro
     * @param direction Direccion que indica si debe cifrar o descifrar
     * @return Texto codificado
     */
    private static String codec(StringBuilder text, int direction) {
        int len = text.length();
        for (int i = 0; i < len; i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int row1 = positions[a - 'A'].y;
            int row2 = positions[b - 'A'].y;
            int col1 = positions[a - 'A'].x;
            int col2 = positions[b - 'A'].x;

            if (row1 == row2) {
                col1 = (col1 + direction) % 5;
                col2 = (col2 + direction) % 5;

            } else if (col1 == col2) {
                row1 = (row1 + direction) % 5;
                row2 = (row2 + direction) % 5;

            } else {
                int tmp = col1;
                col1 = col2;
                col2 = tmp;
            }

            text.setCharAt(i, charTable[row1][col1]);
            text.setCharAt(i + 1, charTable[row2][col2]);
        }
        return text.toString();
    }
}
