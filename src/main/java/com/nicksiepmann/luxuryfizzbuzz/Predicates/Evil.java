/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz.Predicates;

import java.util.function.Predicate;

/**
 *
 * @author Nick.Siepmann
 * In number theory, an evil number is a non-negative integer that has an even number of 1s in its binary expansion.
 */
public class Evil implements Predicate {

    @Override
    public boolean test(Object t) {
        if (t instanceof Integer) {
            String input = Integer.toBinaryString((Integer) t);
            int countOfOnes;
            countOfOnes = input.chars().map(s -> Integer.valueOf(s)).sum();
            if (countOfOnes % 2 == 0) {
                return true;
            }
        }
        return false;
    }

}
