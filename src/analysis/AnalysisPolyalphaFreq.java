/**
 * Clase que implementa los métodos para realizar el análisis del texto
 * @autor Jairo A. Valencia
 * @date 07-may-2019
 * @version 1.0
 */

package analysis;

import utils.Constants;
import utils.Util;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class AnalysisPolyalphaFreq {

    public static int countFrequencies = 0;

    public AnalysisPolyalphaFreq(){

    }

    /**
     * Ejecuta el análisis de acuerdo a parámetros
     * @param text texto
     * @param freq frecuencia
     * @return
     */
    public String executeAnalysis(String text, String freq){

        text = text.trim().toUpperCase();
        int frequency = Integer.parseInt(freq);
        long startTime = System.currentTimeMillis();

        int iterator = 1;
        while(iterator <= frequency) {
            this.calculateFrequency(text, iterator++);
        }

        System.out.println("Cantidad de archivos: " + Util.totalFiles);
        System.out.println("Sumatoria de frecuencias: " + AnalysisPolyalphaFreq.countFrequencies);
        System.out.println("Cantidad de caracteres:   " + text.length());
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecución: " + endTime + " milisegundos");
        return "Análisis terminado\n";
    }

    /**
     * Cálcula la frecuencia de aparición de un grama dados parámetros
     * @param text Texto
     * @param tng Tamanio ngrama
     */
    private void calculateFrequency(String text, int tng){
        Map<String, Integer> mapFrequencies = new HashMap<>();
        int iBegin = 0;
        int iEnd = tng;
        while(iBegin < (text.length()) && iEnd <= text.length()){
            //Se obtiene expresión de tamaño n
            String expression = text.substring(iBegin, iEnd);
            iBegin = iBegin + tng;
            iEnd   = iEnd + tng;
            //Se cuenta la frecuencia de aparición de cada expresión
            int frecuency = 0;
            if(mapFrequencies.containsKey(expression)){
                frecuency = mapFrequencies.get(expression);
                mapFrequencies.replace(expression, ++frecuency);
            }else{
                mapFrequencies.put(expression, ++frecuency);
            }
        }

        //Se crea map para ordenar el map de frecuencias de forma descendente
        Map<String, Integer> sorted = mapFrequencies
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        Set<String> keys = sorted.keySet();
        int count = 1;
        System.out.println("----------");
        System.out.println("FRECUENCIA | Tamaño n-grama: " + tng);
        System.out.println("----------");
        for (String key : keys) {
            int frecuency = sorted.get(key);
            System.out.printf( "%-1s %10s", key + ": ", frecuency + "\t\t");
            AnalysisPolyalphaFreq.countFrequencies = AnalysisPolyalphaFreq.countFrequencies + frecuency;
            if(count%5 == 0)
                System.out.print("\n");
            count++;
        }
        System.out.println("\n");
    }
}
