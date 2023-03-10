package com.example.demo.factory.impl;

import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import com.example.demo.factory.PiFactory;
import com.example.demo.service.PiCalculatorGeneric;
import com.example.demo.service.PiCalculatorMethodology;
import com.example.demo.service.impl.PiCalculatorCurrentMethod;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PiFactoryImplTest {

    @Mock
    PiCalculatorGeneric calculatorGenericMock;

    @InjectMocks
    PiFactoryImpl factory;

    @Test
    public void piCalculatorByAgesTest() throws PiCalculatorMethodNotFoundException {
        PiCalculatorMethodology calculatorMock = mock(PiCalculatorCurrentMethod.class);
        when(calculatorMock.piNumberValueWithMethodDetermined()).thenReturn(3.14f);
        when(calculatorGenericMock.piCalculatorMethodologySelector(3,"age"))
                .thenReturn(calculatorMock);
        float test = factory.piCalculatorByAges(3,"age");
        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(3.14f);

    }

}