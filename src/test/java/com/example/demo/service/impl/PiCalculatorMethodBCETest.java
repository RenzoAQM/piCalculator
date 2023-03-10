package com.example.demo.service.impl;

import com.example.demo.service.PiCalculatorMethodology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PiCalculatorMethodBCETest {

    PiCalculatorMethodology picalculator;

    @Test
    public void piNumberValueWithMethodDeterminedFewDecimals() {

        picalculator = new PiCalculatorMethodBCE(2);
        float testNumber = picalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.14f,testNumber);
    }

    @Test
    public void piNumberValueWithMethodDetermined() {

            picalculator = new PiCalculatorMethodBCE(3);
            float testNumber = picalculator.piNumberValueWithMethodDetermined();
            Assertions.assertEquals(3.141f,testNumber);
    }

    @Test
    public void piNumberValueWithMethodDeterminedMoreDecimals() {

        picalculator = new PiCalculatorMethodBCE(4);
        float testNumber = picalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.1408f,testNumber);
    }

    @Test
    public void piNumberValueWithMethodDeterminedManyDecimals() {

        picalculator = new PiCalculatorMethodBCE(9);
        float testNumber = picalculator.piNumberValueWithMethodDetermined();
        Assertions.assertEquals(3.1408450000f,testNumber);
    }

    // FIT  tests

    @Test
    public void checkIfIsFitTestNormal(){
        picalculator = new PiCalculatorMethodBCE(2);
        boolean test = picalculator.checkIfIsFit("123 BCE");
        assertThat(test).isTrue();
    }

    @Test
    public void checkIfIsFitTestNormalOtherCase(){
        picalculator = new PiCalculatorMethodBCE(2);
        boolean test = picalculator.checkIfIsFit("12 BCE");
        assertThat(test).isTrue();
    }

    @Test
    public void checkIfIsFitTestBCETryToHack(){
        picalculator = new PiCalculatorMethodBCE(2);
        boolean test = picalculator.checkIfIsFit("anyletter BCE");
        assertThat(test).isFalse();
    }

    @Test
    public void checkIfIsFitTestBCETryToHackOtherOption(){
        picalculator = new PiCalculatorMethodBCE(2);
        boolean test = picalculator.checkIfIsFit("123 BCE 123");
        assertThat(test).isFalse();
    }

    @Test
    public void checkIfIsFitTestBCETryToPutDateNotValid(){
        picalculator = new PiCalculatorMethodBCE(2);
        boolean test = picalculator.checkIfIsFit("12223 BCE");
        assertThat(test).isFalse();
    }

}