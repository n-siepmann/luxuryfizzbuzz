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
public class Prime implements Predicate {

    @Override
    public boolean test(Object t) {
        if (t instanceof Integer) {
            Integer input = (Integer) t;
            if (input == 1) {
                return false;
            }
            for (int i = 2; i < input; i++) {
                if (input % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
