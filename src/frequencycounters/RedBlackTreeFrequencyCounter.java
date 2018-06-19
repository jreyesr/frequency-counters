/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frequencycounters;

import datastructures.RedBlackNode;
import datastructures.RedBlackTree;
import main.WordInfo;

/**
 *
 * @author Reyes Ruiz
 */
public class RedBlackTreeFrequencyCounter implements FrequencyCounter {

    private final int minLength;
    private RedBlackTree<WordInfo> tree = new RedBlackTree<>();

    public RedBlackTreeFrequencyCounter(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void addOrUpdate(String word) {
        if (word.length() < minLength) {
            return;
        }
        RedBlackNode<WordInfo> node = tree.find(new WordInfo(word.toLowerCase()));
        if (node == null) {
            WordInfo newWord = new WordInfo(word.toLowerCase());
            newWord.incrementCount();
            tree.insert(newWord);
        } else {
            node.getData().incrementCount();
        }
    }

    @Override
    public boolean exists(String word) {
        if (word.length() < minLength) {
            return false;
        }
        return (tree.find(new WordInfo(word.toLowerCase())) != null);
    }

    @Override
    public int getCount(String word) {
        if (word.length() < minLength) {
            return 0;
        }
        RedBlackNode<WordInfo> node = tree.find(new WordInfo(word.toLowerCase()));
        if (node == null) {
            return 0;
        } else {
            return node.getData().getCount();
        }
    }

    @Override
    public WordInfo getMostFrequent() {
        return tree.getMaxByValue();
    }

}
