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
public interface ComparableByValue<T> extends Comparable<T>{

    public int compareToValues(T o);
}
