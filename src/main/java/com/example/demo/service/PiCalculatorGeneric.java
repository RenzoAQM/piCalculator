package com.example.demo.service;

import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;

public abstract class PiCalculatorGeneric {

    public abstract PiCalculatorMethodology piCalculatorMethodologySelector(int numberOfDigits, String ageProvided) throws PiCalculatorMethodNotFoundException;
}
