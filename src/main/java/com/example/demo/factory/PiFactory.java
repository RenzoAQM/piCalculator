package com.example.demo.factory;

import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;

public interface PiFactory {

    float piCalculatorByAges(int decimalsNumber, String age) throws PiCalculatorMethodNotFoundException;

}
