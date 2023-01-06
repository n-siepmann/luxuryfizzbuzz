/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz;

import com.nicksiepmann.luxuryfizzbuzz.Predicates.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nick.Siepmann
 */
@Service
public class FizzbuzzService {

    String[] syllables;

    public FizzbuzzService() {
        this.syllables = new String[]{"fizz", "buzz", "foo", "bar", "baz", "qux", "xyzzy", "garply", "fred", "oogle", "shme"};
    }

    String[] process(List<Predicate> predicateList) {
        String[] numberList = new String[100];
        for (int i = 1; i < 100; i++) {
            numberList[i] = interpret(i, predicateList);
        }
        return numberList;
    }

    private String interpret(int index, List<Predicate> predicateList) {
        final StringBuffer output = new StringBuffer();
        predicateList.stream().filter(s -> s.test(index)).forEach(s -> output.append(syllables[predicateList.indexOf(s)]));
        if (output.isEmpty()) {
            output.append(index);
        }
        return WordUtils.capitalize(output.toString());
    }

    String[] getSyllables() {
        String[] formatted = (String[]) Arrays.stream(this.syllables).map(WordUtils::capitalize).toArray(String[]::new);
        return formatted;
    }

    List<Predicate> parse(List<PredicateDTO> predicateList) {
        return predicateList.stream().map(s
                -> switch (s.getName()) {
            case "Cube" -> {
                yield new Cube();
            }
            case "Divisible by " -> {
                yield new DivisibleBy(s.getDivisor());
            }
            case "Evil" -> {
                yield new Evil();
            }
            case "Mersenne" -> {
                yield new Mersenne();
            }
            case "Power of two" -> {
                yield new PowerOfTwo();
            }
            case "Prime" -> {
                yield new Prime();
            }
            case "Sum of two cubes" -> {
                yield new SumOfTwoCubes();
            }
            case "Square" -> {
                yield new Square();
            }
            case "Triangular" -> {
                yield new Triangular();
            }
            case "" -> {
                yield null;
            }
            default -> {
                throw new IllegalStateException("Unexpected value");
            }
        }
        ).filter(s -> s != null).toList();
    }

}
