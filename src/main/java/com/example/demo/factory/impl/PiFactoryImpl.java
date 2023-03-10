package com.example.demo.factory.impl;

import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import com.example.demo.factory.PiFactory;
import com.example.demo.service.PiCalculatorGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiFactoryImpl implements PiFactory {

    @Autowired
    PiCalculatorGeneric calculatorGeneric;

    @Override
    public float piCalculatorByAges(int decimalsNumber, String age) throws PiCalculatorMethodNotFoundException {
        return calculatorGeneric
                .piCalculatorMethodologySelector(decimalsNumber,age)
                .piNumberValueWithMethodDetermined();
    }
}
