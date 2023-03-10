package com.example.demo.service.impl;

import com.example.demo.service.PiCalculatorMethodology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PiCalculatorCurrentMethodTest {

    PiCalculatorMethodology piCalculator;

    @Test
    void piNumberValueWithMethodDetermined() {

        piCalculator = new PiCalculatorCurrentMethod(3);
        float test = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.142f, test);
    }

    @Test
    void piNumberValueWithMethodDeterminedfiveDecimals() {

        piCalculator = new PiCalculatorCurrentMethod(5);
        float test = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.14159f, test);
    }


    @Test
    void piNumberValueWithMethodDeterminedNineDecimals() {

        piCalculator = new PiCalculatorCurrentMethod(9);
        float test = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.141592700f, test);
    }


    @Test
    void piNumberValueWithMethodDeterminedTwelveDecimals() {

        piCalculator = new PiCalculatorCurrentMethod(12);
        float test = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.141592700000f, test);
    }

    @Test
    @DisplayName("must return false with correct date provided")
    public void checkIfIsFitTestNormalDate(){
        piCalculator = new PiCalculatorCurrentMethod(1);
        boolean test = piCalculator.checkIfIsFit("2021 CE");
        assertThat(test).isTrue();
    }

    @Test
    @DisplayName("must return false with another correct date provided")
    public void checkIfIsFitTestNormalDate2(){
        piCalculator = new PiCalculatorCurrentMethod(1);
        boolean test = piCalculator.checkIfIsFit("2021");
        assertThat(test).isTrue();
    }


    @Test
    @DisplayName("must return false with incorrect date provided")
    public void checkIfIsFitTestErrorDate(){
        piCalculator = new PiCalculatorCurrentMethod(1);
        boolean test = piCalculator.checkIfIsFit("1909");
        assertThat(test).isFalse();
    }

    @Test
    @DisplayName("must return false with out of range date provided")
    public void checkIfIsFitTestErrorDate2(){
        piCalculator = new PiCalculatorCurrentMethod(1);
        boolean test = piCalculator.checkIfIsFit("2023");
        assertThat(test).isFalse();
    }

    @Test
    @DisplayName("must return false with not format date provided")
    public void checkIfIsFitTestErrorDate3(){
        piCalculator = new PiCalculatorCurrentMethod(1);
        boolean test = piCalculator.checkIfIsFit("abcd");
        assertThat(test).isFalse();
    }

    @Test
    @DisplayName("must return false with not format date provided with CE")
    public void checkIfIsFitTestErrorDate4(){
        piCalculator = new PiCalculatorCurrentMethod(1);
        boolean test = piCalculator.checkIfIsFit("123 CE4");
        assertThat(test).isFalse();
    }
}