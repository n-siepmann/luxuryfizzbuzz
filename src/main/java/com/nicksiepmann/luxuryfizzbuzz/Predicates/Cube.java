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
public class Cube implements Predicate {

    @Override
    public boolean test(Object t) {
        if (t instanceof Integer) {
            double input = ((Integer) t).doubleValue();
            if (input == 1) {
                return false;
            }
            if (cbrt(input) % 1 == 0) {
                return true;
            }
        }
        return false;
    }
}
