/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz.Predicates;

import static java.lang.Math.sqrt;
import java.util.function.Predicate;

/**
 *
 * @author Nick.Siepmann
 */
public class PowerOfTwo implements Predicate<Integer> {

    @Override
    public boolean test(Integer t) {
        if (t instanceof Integer) {
            double input = ((Integer) t).doubleValue();
            do {
                input = input / 2;
                if (input == 2) {
                    return true;
                }
            } while (input > 1);
        }
        return false;
    }

}
