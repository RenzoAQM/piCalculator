package com.example.demo.service.impl;

import com.example.demo.service.PiCalculatorMethodology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PiCalculatorMethodCETest {

    PiCalculatorMethodology piCalculator;

    @Test
    void piNumberValueWithMethodDetermined() {
        piCalculator = new PiCalculatorMethodCE(3);
        float piTest = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.141f, piTest);
    }

    @Test
    void piNumberValueWithMethodDeterminedfiveDecimals() {
        piCalculator = new PiCalculatorMethodCE(5);
        float piTest = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.14141f, piTest);
    }


    @Test
    void piNumberValueWithMethodDeterminednineDecimals() {
        piCalculator = new PiCalculatorMethodCE(9);
        float piTest = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.141412000f, piTest);
    }


    @Test
    void piNumberValueWithMethodDeterminedALotOfdecimals() {
        piCalculator = new PiCalculatorMethodCE(12);
        float piTest = piCalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.1414120000000f, piTest);
    }

    @Test
    @DisplayName("must return true with correct date provided")
    public void checkIfIsFitTestNormal(){
        piCalculator = new PiCalculatorMethodCE(1);
        boolean test = piCalculator.checkIfIsFit("1350 CE");
        assertThat(test).isTrue();
    }

    @Test
    @DisplayName("must return true with correct date provided")
    public void checkIfIsFitTestNormal2(){
        piCalculator = new PiCalculatorMethodCE(1);
        boolean test = piCalculator.checkIfIsFit("1350");
        assertThat(test).isTrue();
    }


    @Test
    @DisplayName("must return false with incorrect date provided")
    public void checkIfIsFitTestErrorDate(){
        piCalculator = new PiCalculatorMethodCE(1);
        boolean test = piCalculator.checkIfIsFit("1100 BCE");
        assertThat(test).isFalse();
    }

    @Test
    @DisplayName("must return false with out of range date provided")
    public void checkIfIsFitTestErrorDate2(){
        piCalculator = new PiCalculatorMethodCE(1);
        boolean test = piCalculator.checkIfIsFit("1100");
        assertThat(test).isFalse();
    }

    @Test
    @DisplayName("must return false with imaginary date provided")
    public void checkIfIsFitTestErrorDate3(){
        piCalculator = new PiCalculatorMethodCE(1);
        boolean test = piCalculator.checkIfIsFit("23456");
        assertThat(test).isFalse();
    }

    @Test
    @DisplayName("must return false with not date format provided")
    public void checkIfIsFitTestErrorDate4(){
        piCalculator = new PiCalculatorMethodCE(1);
        boolean test = piCalculator.checkIfIsFit("Fake");
        assertThat(test).isFalse();
    }
}