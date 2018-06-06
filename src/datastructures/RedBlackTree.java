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
public class RedBlackTree<T extends ComparableByValue<T>> {

    private RedBlackNode<T> root;

    public void insert(T val) {
        root = insert(val, root);
        root.setColor(RedBlackNode.BLACK);
    }

    private RedBlackNode<T> insert(T val, RedBlackNode<T> node) {
        if (node == null) {
            return new RedBlackNode<>(val, 1, RedBlackNode.RED);
        }
        int cmp = val.compareTo(node.getData());
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            node.setRight(insert(val, node.getRight()));
        } else {
            node.setLeft(insert(val, node.getLeft()));
        }

        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    public boolean contains(T val) {
        return find(val) != null;
    }

    public RedBlackNode<T> find(T val) {
        return find(val, root);
    }

    private RedBlackNode<T> find(T val, RedBlackNode<T> node) {
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

    private T getMaxByValue(RedBlackNode<T> node) {
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

    private boolean isRed(RedBlackNode<T> x) {
        if (x == null) {
            return false;
        }
        return x.getColor() == RedBlackNode.RED;
    }

    public int size() {
        return size(root);
    }

    private int size(RedBlackNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    private RedBlackNode<T> rotateLeft(RedBlackNode<T> node) {
        RedBlackNode<T> x = node.getRight();

        node.setRight(x.getLeft());
        x.setLeft(node);

        x.setColor(node.getColor());
        node.setColor(RedBlackNode.RED);
        x.setN(node.getN());
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);

        return x;
    }

    private RedBlackNode<T> rotateRight(RedBlackNode<T> node) {
        RedBlackNode<T> x = node.getLeft();

        node.setLeft(x.getRight());
        x.setRight(node);

        x.setColor(node.getColor());
        node.setColor(RedBlackNode.RED);
        x.setN(node.getN());
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);

        return x;
    }

    private void flipColors(RedBlackNode<T> node) {
        node.setColor(RedBlackNode.RED);
        node.getLeft().setColor(RedBlackNode.BLACK);
        node.getRight().setColor(RedBlackNode.BLACK);
    }
}
