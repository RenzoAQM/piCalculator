package com.example.demo.controller;


import com.example.demo.data.PiResultResponse;
import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import com.example.demo.factory.PiFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiCalculatorController {

    @Autowired
    PiFactory piFactory;

    private static Logger log = LoggerFactory.getLogger(PiCalculatorController.class);

    @GetMapping("/piCalculator/result/{digits}/{age}")
    ResponseEntity<PiResultResponse> getPiResult(@PathVariable @NonNull int digits,
                                                 @PathVariable @NonNull String age) throws PiCalculatorMethodNotFoundException {
        if(log.isInfoEnabled())log.info("{} - calling getPinResult() method with digits: {} and age: {}",PiCalculatorController.class,digits,age);
        float resultCalculator = piFactory.piCalculatorByAges(digits,age);
        if(log.isInfoEnabled())log.info("{} - successfully response provided for service with digits: {} and age: {}",PiCalculatorController.class,digits,age);
        return new ResponseEntity<>(new PiResultResponse(resultCalculator),
                    HttpStatus.OK);
    }
}
