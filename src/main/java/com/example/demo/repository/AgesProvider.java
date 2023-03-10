package com.example.demo.repository;

import com.example.demo.controller.PiCalculatorController;
import com.example.demo.service.PiCalculatorMethodology;
import com.example.demo.service.impl.PiCalculatorCurrentMethod;
import com.example.demo.service.impl.PiCalculatorMethodBCE;
import com.example.demo.service.impl.PiCalculatorMethodCE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AgesProvider {
    private static Logger log = LoggerFactory.getLogger(AgesProvider.class);
    public Map<String, PiCalculatorMethodology>  getAllAgesRecordedByDecimals(int decimals){

        if (log.isInfoEnabled())log.info("{} - connection with mock db to get ages available",AgesProvider.class);
        Map<String, PiCalculatorMethodology> ages = new HashMap<>();
        ages.put("age1",new PiCalculatorMethodBCE(decimals));
        ages.put("age2",new PiCalculatorMethodCE(decimals));
        ages.put("age3",new PiCalculatorCurrentMethod(decimals));

        return ages;
    }
}
