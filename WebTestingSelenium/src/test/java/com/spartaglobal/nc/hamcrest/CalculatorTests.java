package com.spartaglobal.nc.hamcrest;

import static org.hamcrest.Matchers.*;

import com.spartaglobal.nc.Calculator;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorTests {
    @Test
    @DisplayName("Checking that the add method returns correct answer")
    public void testAdd() {
        Calculator calculator = new Calculator(6, 5);
        MatcherAssert.assertThat(calculator.add(), Matchers.closeTo(11, 0.0001));
        //Assertions.assertEquals(11, calculator.add());

        // or
        MatcherAssert.assertThat(calculator.add(), Matchers.equalTo(11.0));

        //or
        MatcherAssert.assertThat(calculator.add(), Matchers.is(11.0));
    }

    @Test
    @DisplayName("Check that the subtract method returns correct answer")
    public void testSubtract() {
        Calculator calculator = new Calculator(7, 4);
        MatcherAssert.assertThat(calculator.subtract(), Matchers.is(3.0));
        //Assertions.assertEquals(3, calculator.subtract());
    }

    @Test
    @DisplayName("Check that the divisibleBy method returns correct answer")
    public void testDivisibleBy() {
        Calculator calculator = new Calculator(10, 5);
        MatcherAssert.assertThat(calculator.divisibleBy(), Matchers.equalTo(true));
        //Assertions.assertTrue(calculator.divisibleBy());
    }

    @Test
    @DisplayName("")
    public void someMoreMatchers() {
        var subject = new Calculator(2, 4);
        MatcherAssert.assertThat(subject.toString(), containsString("Calculator"));
        MatcherAssert.assertThat(subject.toString(), not(containsString("Cat")));
        MatcherAssert.assertThat(subject.add(), greaterThanOrEqualTo(6.0));
        MatcherAssert.assertThat(subject, instanceOf(Calculator.class));
    }

    @Test
    @DisplayName("")
    public void listOfStringsTest() {
        ArrayList<String> fruit = new ArrayList<>(Arrays.asList(new String[]{"apple", "pear", "banana", "peach"}));
        MatcherAssert.assertThat(fruit, hasSize(4));
        //MatcherAssert.assertThat(fruit, hasItems("pear", "banana"));
        //MatcherAssert.assertThat(fruit, contains("pear", "banana"));
        MatcherAssert.assertThat(fruit, containsInAnyOrder("pear", "peach", "banana", "apple"));
    }

    @Test
    public void collectionsconstraints() {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[]{4, 2, 7, 5, 9}));
        MatcherAssert.assertThat(nums, everyItem(greaterThanOrEqualTo(2)));
    }
}
