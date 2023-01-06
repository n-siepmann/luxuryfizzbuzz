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
public class DivisibleBy implements Predicate {

    private final int divisor;

    public DivisibleBy(int divisor) {
        this.divisor = divisor;
    }
    
    @Override
    public boolean test(Object t) {
        if (t instanceof Integer) {
            Integer input = (Integer) t;
            if (input % divisor == 0) {
                return true;
            }
        }
        return false;
    }
}
