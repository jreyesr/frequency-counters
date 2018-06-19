/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frequencycounters.FrequencyCounter;
import frequencycounters.HashMapFrequencyCounter;
import frequencycounters.BinarySearchTreeFrequencyCounter;
import frequencycounters.RedBlackTreeFrequencyCounter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Reyes Ruiz
 */
public class FrequencyCountersEfficiency {

    private static final int N_RUNS = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String files[] = {"tinyTale.txt", "tale.txt", "leipzig1M.txt"};
        for (String file : files) {
            testFile(file);
        }
    }

    private static void testFile(String file) {
        System.out.println("File: " + file);
        for (int i = 3; i <= 12; i += 1) {
            int N = i;

            List<TimingInfo> timesBST = new LinkedList<>();
            List<TimingInfo> timesRBT = new LinkedList<>();
            List<TimingInfo> timesHM = new LinkedList<>();

            for (int j = 0; j < N_RUNS; j++) {
                long a = System.currentTimeMillis();
                testFrequencyCounter(new BinarySearchTreeFrequencyCounter(N), file);
                long b = System.currentTimeMillis();
                timesBST.add(new TimingInfo("BinarySearchTree", b - a, N, file));

                a = System.currentTimeMillis();
                testFrequencyCounter(new RedBlackTreeFrequencyCounter(N), file);
                b = System.currentTimeMillis();
                timesRBT.add(new TimingInfo("RedBlackTree", b - a, N, file));

                a = System.currentTimeMillis();
                testFrequencyCounter(new HashMapFrequencyCounter(N), file);
                b = System.currentTimeMillis();
                timesHM.add(new TimingInfo("HashMap", b - a, N, file));
            }

            System.out.println("N=" + i);
            System.out.println(TimingInfo.buildAverage(timesBST));
            System.out.println(TimingInfo.buildAverage(timesRBT));
            System.out.println(TimingInfo.buildAverage(timesHM));
        }
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
    }

}
