/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz.Predicates;

import static java.lang.Math.cbrt;
import java.util.function.Predicate;

/**
 *
 * @author Nick.Siepmann
 */
public class Triangular implements Predicate {

    @Override
    public boolean test(Object t) {
        if (t instanceof Integer) {
            Integer input = (Integer) t;
            int triangleSum = 0;
            for (int i = 1; i <= input; i++) {
                triangleSum += i;
                if (triangleSum == input){
                    return true;
                }
            }
        }
        return false;
    }
}
