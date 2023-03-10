package com.example.demo.service.impl;

import com.example.demo.service.PiCalculatorMethodology;
import com.example.demo.utils.PiCalculatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PiCalculatorMethodBCE implements PiCalculatorMethodology {

    private int numberOfDigits;
    private float PI_EGYPTIANS_NUMBER = 3.1604f;
    private float PI_ARCHIMEDES_LOWEST = 3.140845f;
    private float PI_ARCHIMEDES_HIGHEST = 3.142857f;

    List<Integer> ageRangeForCurrentMethod = Arrays.asList(new Integer[] { 1, 2000});

    private static Logger log = LoggerFactory.getLogger(PiCalculatorMethodBCE.class);

    public PiCalculatorMethodBCE(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    @Override
    public float piNumberValueWithMethodDetermined() {

        List numberSelected = Stream.of(PI_EGYPTIANS_NUMBER,PI_ARCHIMEDES_LOWEST,PI_ARCHIMEDES_HIGHEST)
                .map(piCandidate -> PiCalculatorUtils.roundFloat(piCandidate,numberOfDigits))
                .collect(Collectors.toList());
        return chooseBestPiNumber(numberSelected);
    }

    @Override
    public boolean checkIfIsFit(String ageProvided) {
        if(log.isInfoEnabled()) log.info("{} - checking if it is fit",this.getClass());
        try{
            String ageProvidedModified = ageProvided.endsWith(" BCE") ?
                    ageProvided.replace(" BCE","") : null;
            boolean isAgeProvidedInTheRange = ageProvidedModified!=null &&  (Double.valueOf(ageProvidedModified) >= ageRangeForCurrentMethod.get(0) &&
                    Double.valueOf(ageProvidedModified) <= ageRangeForCurrentMethod.get(1)) ? true :false;
            if(isAgeProvidedInTheRange){
                return true;
            }
        }
        catch(NumberFormatException ex){
            log.error(ex.getMessage(),ex);
            return false;
            }

        return false;
    }

    private float chooseBestPiNumber(List<Float> numbers){

        if(log.isInfoEnabled()) log.info("{} - process to calculate with age provided by client",this.getClass());
        double piMinimumDifference = Math.abs(Math.PI - numbers.get(0).doubleValue()) ;
        float piNumberSelected = numbers.get(0);

        for (int i = 0 ; i < numbers.size() ; i++){
            double piSelectedDifference = Math.abs(Math.PI - (double)numbers.get(i));
            if(piSelectedDifference < piMinimumDifference){
                piMinimumDifference = piSelectedDifference;
                piNumberSelected = numbers.get(i);
            }
        }

        return piNumberSelected;
    }
}
