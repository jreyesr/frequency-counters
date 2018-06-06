/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frequencycounters;

import main.WordInfo;

/**
 *
 * @author Reyes Ruiz
 */
public interface FrequencyCounter {

    /**
     * Add a word to the counter with a frequency of 1 if it doesn't exist,
     * increment its frequency by 1 if it does exist.
     *
     * word doesn't have to be lowercase, but it should be converted to
     * lowercase by the implementation.
     *
     * @param word The word to insert or update
     */
    public void addOrUpdate(String word);

    /**
     * Check if a word exists in the counter.
     *
     * word doesn't have to be lowercase, but it should be converted to
     * lowercase by the implementation.
     *
     * @param word The word to check
     * @return true if the word already exists in the counter, false otherwise
     */
    public boolean exists(String word);

    /**
     * Get the count of a word in the counter.
     *
     * word doesn't have to be lowercase, but it should be converted to
     * lowercase by the implementation.
     *
     * @param word The word to check
     * @return The number of appearances of word in the counter, or 0 if the
     * word hasn't been inserted
     */
    public int getCount(String word);

    /**
     * Find (one of the) words with the highest frequency. In the case of a tie,
     * one of the words may be selected arbitrarily.
     *
     * @return A WordInfo object containing the most frequent word and its count
     */
    public WordInfo getMostFrequent();
}
