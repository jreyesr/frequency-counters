/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frequencycounters.FrequencyCounter;
import frequencycounters.HashMapFrequencyCounter;
import datastructures.BinarySearchTree;
import frequencycounters.BinarySearchTreeFrequencyCounter;
import frequencycounters.RedBlackTreeFrequencyCounter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Reyes Ruiz
 */
public class FrequencyCountersEfficiency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testFrequencyCounter(new RedBlackTreeFrequencyCounter(0), "tinyTaleModified.txt");
    }

    private static void testFrequencyCounter(FrequencyCounter counter, String file) {
        // Fill counter with data
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.split(" ")) {
                    // Skip empty words, multiple whitespaces
                    if (word.trim().length() == 0) {
                        continue;
                    }
                    counter.addOrUpdate(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find word with highest count
        System.out.println(counter.getMostFrequent());
    }

}
