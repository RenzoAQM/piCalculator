package com.example.demo.repository;

import com.example.demo.service.PiCalculatorMethodology;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AgesProviderTest {

    AgesProvider provider;

    @Test
    @DisplayName("Should return map ages")
    void getAllAgesRecordedByDecimals() {

        provider = new AgesProvider();
        Map<String, PiCalculatorMethodology> test = provider.getAllAgesRecordedByDecimals(1);
        assertThat(test).isNotNull();
        assertThat(test.size()).isEqualTo(3);

    }
}