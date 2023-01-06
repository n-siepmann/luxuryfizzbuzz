/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nicksiepmann.luxuryfizzbuzz;

import com.nicksiepmann.luxuryfizzbuzz.Predicates.*;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nick.Siepmann
 */
public class FizzbuzzServiceTest {

    FizzbuzzService underTest;

    public FizzbuzzServiceTest() {
        this.underTest = new FizzbuzzService();
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void canProcess() {
        Predicate<Integer> fizz = i -> (i % 3 == 0);
        ArrayList<Predicate> predicateList = new ArrayList<>();
        predicateList.add(fizz);

        String[] processed = this.underTest.process(predicateList);

        assertEquals("Fizz", processed[3]);
        assertEquals("2", processed[2]);
        assertEquals("Fizz", processed[99]);

        Predicate<Integer> buzz = i -> (i % 5 == 0);
        predicateList.add(buzz);

        processed = this.underTest.process(predicateList);

        assertEquals("Fizz", processed[3]);
        assertEquals("Buzz", processed[5]);
        assertEquals("Fizzbuzz", processed[15]);

        Predicate<Integer> foo = new Prime();
        predicateList.add(foo);

        processed = this.underTest.process(predicateList);

        assertEquals("Fizzfoo", processed[3]);
        assertEquals("Buzzfoo", processed[5]);
        assertEquals("Fizzbuzz", processed[15]);

        Predicate<Integer> bar = new Square();
        predicateList.add(bar);

        processed = this.underTest.process(predicateList);

        assertEquals("Fizzfoo", processed[3]);
        assertEquals("Buzzfoo", processed[5]);
        assertEquals("Fizzbar", processed[9]);
        assertEquals("Fizzbuzz", processed[15]);
        assertEquals("Bar", processed[16]);

        Predicate<Integer> baz = new Cube();
        predicateList.add(baz);

        processed = this.underTest.process(predicateList);

        assertEquals("Fizzfoo", processed[3]);
        assertEquals("Buzzfoo", processed[5]);
        assertEquals("Baz", processed[8]);
        assertEquals("Fizzbar", processed[9]);
        assertEquals("Fizzbuzz", processed[15]);
        assertEquals("Bar", processed[16]);
        assertEquals("Fizzbaz", processed[27]);

        Predicate<Integer> qux = new Triangular();
        predicateList.add(qux);

        processed = this.underTest.process(predicateList);

        assertEquals("Qux", processed[1]);
        assertEquals("Fizzfooqux", processed[3]);
        assertEquals("Buzzfoo", processed[5]);
        assertEquals("Baz", processed[8]);
        assertEquals("Fizzbar", processed[9]);
        assertEquals("Fizzbuzzqux", processed[15]);
        assertEquals("Bar", processed[16]);
        assertEquals("Fizzbaz", processed[27]);

        Predicate<Integer> xyzzy = new DivisibleBy(8);
        predicateList.add(xyzzy);

        processed = this.underTest.process(predicateList);

        assertEquals("Qux", processed[1]);
        assertEquals("Fizzfooqux", processed[3]);
        assertEquals("Buzzfoo", processed[5]);
        assertEquals("Bazxyzzy", processed[8]);
        assertEquals("Fizzbar", processed[9]);
        assertEquals("Fizzbuzzqux", processed[15]);
        assertEquals("Barxyzzy", processed[16]);
        assertEquals("Fizzbaz", processed[27]);

        Predicate<Integer> garply = new SumOfTwoCubes();
        predicateList.add(garply);

        processed = this.underTest.process(predicateList);

        assertEquals("Qux", processed[1]);
        assertEquals("Fizzfooqux", processed[3]);
        assertEquals("Buzzfoo", processed[5]);
        assertEquals("Bazxyzzy", processed[8]);
        assertEquals("Fizzbar", processed[9]);
        assertEquals("Fizzbuzzqux", processed[15]);
        assertEquals("Barxyzzygarply", processed[16]);
        assertEquals("Fizzbaz", processed[27]);

        Predicate<Integer> fred = new Evil();
        predicateList.add(fred);

        processed = this.underTest.process(predicateList);

        assertEquals("Qux", processed[1]);
        assertEquals("Fizzfooquxfred", processed[3]);
        assertEquals("Buzzfoofred", processed[5]);
        assertEquals("Bazxyzzy", processed[8]);
        assertEquals("Fizzbarfred", processed[9]);
        assertEquals("Fizzbuzzquxfred", processed[15]);
        assertEquals("Barxyzzygarply", processed[16]);
        assertEquals("Fizzbazfred", processed[27]);

        Predicate<Integer> oogle = new PowerOfTwo();
        predicateList.add(oogle);

        processed = this.underTest.process(predicateList);

        assertEquals("Qux", processed[1]);
        assertEquals("Fizzfooquxfred", processed[3]);
        assertEquals("Buzzfoofred", processed[5]);
        assertEquals("Bazxyzzyoogle", processed[8]);
        assertEquals("Fizzbarfred", processed[9]);
        assertEquals("Fizzbuzzquxfred", processed[15]);
        assertEquals("Barxyzzygarplyoogle", processed[16]);
        assertEquals("Fizzbazfred", processed[27]);

        Predicate<Integer> shme = new Mersenne();
        predicateList.add(shme);

        processed = this.underTest.process(predicateList);

        assertEquals("Qux", processed[1]);
        assertEquals("Fizzfooquxfredshme", processed[3]);
        assertEquals("Buzzfoofred", processed[5]);
        assertEquals("Bazxyzzyoogle", processed[8]);
        assertEquals("Fizzbarfred", processed[9]);
        assertEquals("Fizzbuzzquxfred", processed[15]);
        assertEquals("Barxyzzygarplyoogle", processed[16]);
        assertEquals("Fizzbazfred", processed[27]);
    }

}
