package com.example.demo.service.impl;

import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import com.example.demo.repository.AgesProvider;
import com.example.demo.service.PiCalculatorMethodology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PiCalculatorAndAgeSelectorTest {

    @Mock
    AgesProvider providerMock;

    @InjectMocks
    PiCalculatorAndAgeSelector piCalculatorImpl;

    @Test
    public void getMethodChronologyMethodByAgeTestNotNull(){

        when(providerMock.getAllAgesRecordedByDecimals(2)).thenReturn(buildAgesMap());
        PiCalculatorMethodology test= piCalculatorImpl.getMethodChronologyMethodByAge(2,"ageRandom");
        assertThat(test).isNotNull();
        assertThat(test.checkIfIsFit("ageRandom")).isTrue();
        assertThat(test.getClass().getName()).isEqualTo(PiCalculatorFakeTwo.class.getName());
    }

    @Test
    public void getMethodChronologyMethodByAgeTestNotAgeFitted(){

        when(providerMock.getAllAgesRecordedByDecimals(2)).thenReturn(buildAgesMapWithNotFittedAge());
        PiCalculatorMethodology test= piCalculatorImpl.getMethodChronologyMethodByAge(2,"ageRandom");
        assertThat(test).isNull();
    }

    @Test
    public void piCalculatorMethodTestNotnull() throws PiCalculatorMethodNotFoundException {
        when(providerMock.getAllAgesRecordedByDecimals(2)).thenReturn(buildAgesMap());
        PiCalculatorMethodology test= piCalculatorImpl.piCalculatorMethodologySelector(2,"ageRandom");
        assertThat(test).isNotNull();
        assertThat(test.checkIfIsFit("ageRandom")).isTrue();
        assertThat(test.getClass().getName()).isEqualTo(PiCalculatorFakeTwo.class.getName());

    }

    @Test
    public void piCalculatorMethodTestNullAndExceptionThrown(){
        when(providerMock.getAllAgesRecordedByDecimals(2)).thenReturn(buildAgesMapWithNotFittedAge());
        PiCalculatorMethodNotFoundException thrown = Assertions.assertThrows( PiCalculatorMethodNotFoundException.class, () -> {
            PiCalculatorMethodology test= piCalculatorImpl.piCalculatorMethodologySelector(2,"ageRandom");
        });

    }

    protected Map<String, PiCalculatorMethodology> buildAgesMap(){

        Map<String, PiCalculatorMethodology> ages = new HashMap<>();
        ages.put("1",new PiCalculatorFakeOne());
        ages.put("2",new PiCalculatorFakeTwo());
        ages.put("3",new PiCalculatorFakeThree());

        return ages;
    }

    protected Map<String, PiCalculatorMethodology> buildAgesMapWithNotFittedAge(){

        Map<String, PiCalculatorMethodology> ages = new HashMap<>();
        ages.put("1",new PiCalculatorFakeOne());
        ages.put("2",new PiCalculatorFakeFour());
        ages.put("3",new PiCalculatorFakeThree());

        return ages;
    }

    class PiCalculatorFakeOne implements PiCalculatorMethodology{

        public PiCalculatorFakeOne(){};
        @Override
        public float piNumberValueWithMethodDetermined() {
            return 0;
        }
        @Override
        public boolean checkIfIsFit(String ageProvided) {
            return false;
        }
    }

    class PiCalculatorFakeTwo implements PiCalculatorMethodology{

        public PiCalculatorFakeTwo(){};
        @Override
        public float piNumberValueWithMethodDetermined() {
            return 0;
        }
        @Override
        public boolean checkIfIsFit(String ageProvided) {
            return true;
        }
    }

    class PiCalculatorFakeThree implements PiCalculatorMethodology{

        public PiCalculatorFakeThree(){};
        @Override
        public float piNumberValueWithMethodDetermined() {
            return 0;
        }
        @Override
        public boolean checkIfIsFit(String ageProvided) {
            return false;
        }
    }

    class PiCalculatorFakeFour implements PiCalculatorMethodology{

        public PiCalculatorFakeFour(){};
        @Override
        public float piNumberValueWithMethodDetermined() {
            return 0;
        }
        @Override
        public boolean checkIfIsFit(String ageProvided) {
            return false;
        }
    }

}