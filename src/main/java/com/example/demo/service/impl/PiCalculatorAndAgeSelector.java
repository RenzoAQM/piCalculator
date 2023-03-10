package com.example.demo.service.impl;

import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import com.example.demo.repository.AgesProvider;
import com.example.demo.service.PiCalculatorGeneric;
import com.example.demo.service.PiCalculatorMethodology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PiCalculatorAndAgeSelector extends PiCalculatorGeneric {

    @Autowired
    AgesProvider provider;

    private final String NOT_METHOD_FOUND_MESSAGE = "Not method found to calculate pi number, please insert a correct date";
    private static Logger log = LoggerFactory.getLogger(PiCalculatorAndAgeSelector.class);
    @Override
    public PiCalculatorMethodology piCalculatorMethodologySelector( int numberOfDigits, String ageProvided) throws PiCalculatorMethodNotFoundException {

        PiCalculatorMethodology result = getMethodChronologyMethodByAge(numberOfDigits,ageProvided);
        if(result == null){
            log.warn("{} - not method was found for client request",this.getClass());
            throw new PiCalculatorMethodNotFoundException(NOT_METHOD_FOUND_MESSAGE);
        }
        log.warn("{} - pi number for provided data was calculated successfully, process to response",this.getClass());
        return result;
    }
    protected PiCalculatorMethodology getMethodChronologyMethodByAge(int decimals, String ageProvided){
        Map<String, PiCalculatorMethodology> ages = provider.getAllAgesRecordedByDecimals(decimals);
        Optional<Map.Entry<String,PiCalculatorMethodology>> agesOpt = ages
                .entrySet()
                .stream()
                .filter(age -> age.getValue().checkIfIsFit(ageProvided))
                .findFirst();
        return agesOpt.isPresent() ? agesOpt.get().getValue() : null;
    }



}
