/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz.Predicates;

import java.util.function.Predicate;

/**
 *
 * @author Nick.Siepmann
 */
public class SumOfTwoCubes implements Predicate {

    @Override
    public boolean test(Object t) {
        Predicate<Integer> cube = new Cube();
        if (t instanceof Integer) {
            Integer input = (Integer) t;
            if (input == 1) {
                return false;
            }
            for (int i = 2; i < input; i++) {
                if (cube.test(i)) {
                    if (cube.test(input - i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
