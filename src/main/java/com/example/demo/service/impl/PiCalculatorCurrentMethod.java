package com.example.demo.service.impl;

import com.example.demo.service.PiCalculatorMethodology;
import com.example.demo.utils.PiCalculatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


public class PiCalculatorCurrentMethod implements PiCalculatorMethodology {

    private int numberOfDigits;

    private int ITERATION_BY_DEFAULT = 10;

    List<Integer> ageRangeForCurrentMethod = Arrays.asList(new Integer[] { 1910, 2022});

    private static Logger log = LoggerFactory.getLogger(PiCalculatorCurrentMethod.class);
    public PiCalculatorCurrentMethod(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    // Method available since 1910 made by Indian Mathematician Srinivasa Ramanujan
    @Override
    public float piNumberValueWithMethodDetermined() {
        return PiCalculatorUtils.roundFloat(piCalculator(),numberOfDigits);
    }

    @Override
    public boolean checkIfIsFit(String ageProvided) {

        try{
            if(log.isInfoEnabled()) log.info("{} -  checking if it is fit",this.getClass());
            return PiCalculatorUtils.checkIfAgeValueIsValidForCERange(ageProvided,ageRangeForCurrentMethod);
        }catch(NumberFormatException ex){
            log.error(ex.getMessage(),ex);
            return false;
        }
    }

    private float piCalculator(){

        if(log.isInfoEnabled()) log.info("{} - In progress calculation for date requested",this.getClass());
        float resultValueProvisional = 0f;
        float resultValueFinal;
        for (int k=0; k<=ITERATION_BY_DEFAULT ; k++){
            resultValueProvisional = (float)(resultValueProvisional +
                    PiCalculatorUtils.factorialUsingStreams(4*k)*(1103+26390*k)/
                            (Math.pow(PiCalculatorUtils.factorialUsingStreams(k),4)*Math.pow(396,4*k)));
        }
        resultValueFinal = (float)(1/((2*Math.sqrt(2)/9801)*resultValueProvisional));

        return resultValueFinal;
    }
}
