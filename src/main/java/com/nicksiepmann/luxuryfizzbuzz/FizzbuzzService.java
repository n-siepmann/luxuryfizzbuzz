/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz;

import java.util.ArrayList;
import java.util.function.Predicate;
import org.apache.commons.text.WordUtils;

/**
 *
 * @author Nick.Siepmann
 */
public class FizzbuzzService {

    String[] process(ArrayList<Predicate> predicateList) {
        String[] numberList = new String[100];
        for (int i = 1; i < 100; i++) {
            numberList[i] = interpret(i, predicateList);
        }
        return numberList;
    }

    private String interpret(int index, ArrayList<Predicate> predicateList) {
        final StringBuffer output = new StringBuffer();
        String[] syllables = new String[]{"fizz", "buzz", "foo", "bar", "baz", "qux", "xyzzy", "garply", "fred", "oogle", "shme"};
        predicateList.stream().filter(s -> s.test(index)).forEach(s -> output.append(syllables[predicateList.indexOf(s)]));
        if (output.isEmpty()) {
            output.append(index);
        }
        return WordUtils.capitalize(output.toString());
    }



}
