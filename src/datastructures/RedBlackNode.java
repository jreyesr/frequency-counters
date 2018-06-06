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
public class RedBlackNode<T extends ComparableByValue<T>> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private final T data;
    private RedBlackNode<T> left, right;
    private int N; // # nodes in this subtree
    private boolean color; // color of link from parent to this node

    public RedBlackNode(T data, int N, boolean color) {
        this.data = data;
        this.N = N;
        this.color = color;
    }

    public T getData() {
        return data;
    }

    public RedBlackNode<T> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<T> left) {
        this.left = left;
    }

    public RedBlackNode<T> getRight() {
        return right;
    }

    public void setRight(RedBlackNode<T> right) {
        this.right = right;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

}
