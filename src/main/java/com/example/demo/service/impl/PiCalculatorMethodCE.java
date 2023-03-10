package com.example.demo.service.impl;

import com.example.demo.service.PiCalculatorMethodology;
import com.example.demo.utils.PiCalculatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class PiCalculatorMethodCE implements PiCalculatorMethodology {

    private int numberOfDigits;

    private int ITERATION_BY_DEFAULT = 75;

    List<Integer> ageRangeForCurrentMethod = Arrays.asList(new Integer[] { 1300, 1910});

    private static Logger log = LoggerFactory.getLogger(PiCalculatorMethodCE.class);
    public PiCalculatorMethodCE(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    @Override
    public float piNumberValueWithMethodDetermined() {
        return PiCalculatorUtils.roundFloat(calculationPiNumber(),numberOfDigits);
    }

    @Override
    public boolean checkIfIsFit(String ageProvided) {
        try{
            if(log.isInfoEnabled()) log.info("{} -  checking if it is fit",this.getClass());
            return PiCalculatorUtils.checkIfAgeValueIsValidForCERange(ageProvided,ageRangeForCurrentMethod);
        }catch(NumberFormatException ex){
            log.error(ex.getMessage(), ex);
            return false;
        }
    }

    // Information: arctan(1) with correction method used
    private float calculationPiNumber(){

        if(log.isInfoEnabled()) log.info("{} - process to calculate with age provided by client",this.getClass());
        float calculation= 1f;
        for(int n = 2; n<ITERATION_BY_DEFAULT ; n++){
            calculation = calculation - (float)(Math.pow(-1,n)/(2*n-1));
        }
        float correctionNumber = (float)((Math.pow(ITERATION_BY_DEFAULT,2)+1) /
                (4*Math.pow(ITERATION_BY_DEFAULT,3) + 5*ITERATION_BY_DEFAULT));
        float firstSolution =  4*(calculation + correctionNumber);
        float secondSolution =  4*(calculation - correctionNumber);
        if(Math.PI-firstSolution < Math.PI-secondSolution){
            return firstSolution;
        }else{
            return secondSolution;
        }
    }

}
