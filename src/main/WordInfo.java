/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Reyes Ruiz
 */
public class WordInfo implements ComparableByValue<WordInfo> {

    private final String word;
    private int count;

    public WordInfo(String word) {
        this.word = word;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count += 1;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(WordInfo o) {
        return this.word.compareTo(o.getWord());
    }

    @Override
    public int compareToValues(WordInfo o) {
        return Integer.compare(this.count, o.getCount());
    }

    @Override
    public String toString() {
        return "(" + word + ", " + count + ')';
    }

}
