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

    public boolean existLanguage(String language){
        return languagesHash.contains(language);
    }

    public String executeAnalysis(String language, String text, String freq){
        int frequency = Integer.parseInt(freq);
        Map<String, Integer> mapFrequencies = new HashMap<>();

        for(int i=0; i<text.length(); i++){
            String expression = String.valueOf(Character.toUpperCase(text.charAt(i)));
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
        for (String key : keys) {
            System.out.print(key + ": " + sorted.get(key) + "\t");
            if(count%5 == 0)
                System.out.print("\n");
            count++;
        }
        //System.out.println(mapFrequencies);
        //System.out.println(sorted);

        return "\nAnálisis terminado\n";
    }
}
