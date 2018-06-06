/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frequencycounters;

import java.util.HashMap;
import java.util.Map;
import main.WordInfo;

/**
 *
 * @author Reyes Ruiz
 */
public class HashMapFrequencyCounter implements FrequencyCounter {

    private int minLength;
    private Map<String, Integer> map = new HashMap<>();

    public HashMapFrequencyCounter(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void addOrUpdate(String word) {
        if (word.length() < minLength) {
            return;
        }
        if (!map.containsKey(word.toLowerCase())) {
            map.put(word.toLowerCase(), 1);
        } else {
            map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
        }
    }

    @Override
    public boolean exists(String word) {
        if (word.length() < minLength) {
            return false;
        }
        return map.containsKey(word.toLowerCase());
    }

    @Override
    public int getCount(String word) {
        if (word.length() < minLength) {
            return 0;
        }
        return map.getOrDefault(word.toLowerCase(), 0);
    }

    @Override
    public WordInfo getMostFrequent() {
        String maxWord = "";
        int maxCount = -1;
        for (Map.Entry<String, Integer> wordData : map.entrySet()) {
            if (wordData.getValue() > maxCount) {
                maxWord = wordData.getKey();
                maxCount = wordData.getValue();
            }
        }
        WordInfo max = new WordInfo(maxWord);
        max.setCount(maxCount);
        return max;
    }

}
