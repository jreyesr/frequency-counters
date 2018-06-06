/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import main.ComparableByValue;

/**
 *
 * @author Reyes Ruiz
 * @param <T>
 */
public class BinarySearchTree<T extends ComparableByValue<T>> {

    private BSTNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public int numLevels() {
        return numLevels(root);
    }

    private int numLevels(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(numLevels(node.getLeft()), numLevels(node.getRight()));
    }

    public void insert(T val) {
        root = insert(val, root);
    }

    private BSTNode<T> insert(T val, BSTNode<T> node) {
        if (node == null) {
            return new BSTNode<>(val);
        }
        if (val.compareTo(node.getData()) == 0) {
            return node;
        } else if (val.compareTo(node.getData()) > 0) {
            node.setRight(insert(val, node.getRight()));
        } else {
            node.setLeft(insert(val, node.getLeft()));
        }
        return node;
    }

    public boolean contains(T val) {
        return find(val) != null;
    }

    public BSTNode<T> find(T val) {
        return find(val, root);
    }

    private BSTNode<T> find(T val, BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        if (val.compareTo(node.getData()) == 0) {
            return node;
        } else if (val.compareTo(node.getData()) > 0) {
            return find(val, node.getRight());
        } else {
            return find(val, node.getLeft());
        }
    }

    public T getMaxByValue() {
        return getMaxByValue(root);
    }

    private T getMaxByValue(BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        T base = node.getData(); // Guaranteed to not be null
        T left = getMaxByValue(node.getLeft()); // Can be null
        T right = getMaxByValue(node.getRight()); // Can be null
        T max = base;
        if (left != null && left.compareToValues(max) > 0) {
            // left exists and is greater than current max, update
            max = left;
        }
        if (right != null && right.compareToValues(max) > 0) {
            // right exists and is greater than current max, update
            max = right;
        }
        return max;
    }
}
