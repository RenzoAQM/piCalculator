package com.example.demo.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.LongStream;

public class PiCalculatorUtils {

    public static float roundFloat(float number, int roundTo){

        String num = "#########.";
        for (int count = 0; count < roundTo; count++){
            num += "0";
        }
        DecimalFormat df = new DecimalFormat(num);
        String S = df.format(number);
        number = Float.parseFloat(S);

        return number;
    }

    public static long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    public static boolean checkIfAgeValueIsValidForCERange(String ageProvided, List<Integer> ageRange){
        String ageProvidedModified = ageProvided.endsWith(" CE") ?
                ageProvided.replace(" CE","") : ageProvided;
        boolean isAgeProvidedInTheRange = ageProvidedModified.length() == 4 ;
        String yearsSelected = isAgeProvidedInTheRange ? ageProvidedModified : null;
        if(yearsSelected != null &&
                (Double.valueOf(yearsSelected) >= ageRange.get(0) &&
                        Double.valueOf(yearsSelected) <= ageRange.get(1))){
            return true;
        }
        return false;
    }
}
