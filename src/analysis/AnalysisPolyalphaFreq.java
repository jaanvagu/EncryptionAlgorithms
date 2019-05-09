/**
 * Clase que implementa los métodos para realizar el análisis del texto
 * @autor Jairo A. Valencia
 * @date 07-may-2019
 * @version 1.0
 */

package analysis;

import utils.Constants;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class AnalysisPolyalphaFreq {

    private HashSet<String> languagesHash;

    public AnalysisPolyalphaFreq(){
        this.fillLanguages();
    }

    private void fillLanguages(){
        languagesHash = new HashSet<>();
        languagesHash.add(Constants.SPANISH_LANGUAGE);
        languagesHash.add(Constants.ENGLISH_LANGUAGE);
        languagesHash.add(Constants.FRENCH_LANGUAGE);
        languagesHash.add(Constants.GERMAN_LANGUAGE);
    }

    /**
     * Busca idioma en hash
     * @param language idioma
     * @return true o false
     */
    public boolean existLanguage(String language){
        return languagesHash.contains(language);
    }

    /**
     * Ejecuta el análisis de acuerdo a parámetros
     * @param language idioma
     * @param text texto
     * @param freq frecuencia
     * @return
     */
    public String executeAnalysis(String language, String text, String freq){

        text = text.trim().toUpperCase();
        int frequency = Integer.parseInt(freq);
        long startTime = System.currentTimeMillis();

        int iterator = 1;
        while(iterator <= frequency) {
            this.calculateFrequency(text, iterator++);
        }

        System.out.println("Cantidad de caracteres: " + text.length());
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecución: " + endTime + " milisegundos");
        return "Análisis terminado\n";
    }

    private void calculateFrequency(String text, int freq){
        Map<String, Integer> mapFrequencies = new HashMap<>();
        int iBegin = 0;
        int iEnd = freq;
        while(iBegin < (text.length()) && iEnd <= text.length()){

            String expression = text.substring(iBegin, iEnd);
            iBegin = iBegin + freq;
            iEnd   = iEnd + freq;

            int frecuency = 0;
            if(mapFrequencies.containsKey(expression)){
                frecuency = mapFrequencies.get(expression);
                mapFrequencies.replace(expression, ++frecuency);
            }else{
                mapFrequencies.put(expression, ++frecuency);
            }
        }

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
        System.out.println("FRECUENCIA | Tamaño n-grama: " + freq);
        System.out.println("----------");
        for (String key : keys) {
            System.out.printf( "%-1s %10s", key + ": ", sorted.get(key) + "\t\t");
            if(count%5 == 0)
                System.out.print("\n");
            count++;
        }
        System.out.println("\n");
    }
}
