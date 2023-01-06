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
public class Mersenne implements Predicate {

    @Override
    public boolean test(Object t) {
        Predicate<Integer> prime = new Prime();
        Predicate<Integer> powerOfTwo = new PowerOfTwo();
        if (t instanceof Integer) {
            Integer input = (Integer) t;
            return prime.test(input) && powerOfTwo.test(input + 1);
        }
        return false;
    }

}
