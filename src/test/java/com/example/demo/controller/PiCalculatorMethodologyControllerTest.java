package com.example.demo.controller;

import com.example.demo.data.ErrorMessage;
import com.example.demo.data.PiResultResponse;
import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import com.example.demo.factory.PiFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PiCalculatorMethodologyControllerTest {

    @Mock
    PiFactory piFactoryMock;

    @InjectMocks
    PiCalculatorController controllerTest;

    private MockMvc mvc;

    @BeforeEach
    void setUp() throws Exception {
        this.mvc = MockMvcBuilders.standaloneSetup(controllerTest).build();
    }

    @Test
    public void getResultConnectionTest() throws Exception {
        when(piFactoryMock.piCalculatorByAges(3,"test")).thenReturn(0.0f);

        mvc.perform(MockMvcRequestBuilders
                .get("/piCalculator/result/3/test")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getResultBadRequestConnectionTest() throws Exception {

        when(piFactoryMock.piCalculatorByAges(3,"longTimeAgo")).thenThrow(PiCalculatorMethodNotFoundException.class);
        NestedServletException thrown = Assertions.assertThrows( NestedServletException.class, () -> {
            mvc.perform(MockMvcRequestBuilders
                            .get("/piCalculator/result/3/longTimeAgo")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        });

  //      Assertions.assertTrue(
    //            thrown.getMessage().contains("Not method found for provided age"));

    }

    @Test
    public void getResultCorrectlyTest() throws Exception {
        when(piFactoryMock.piCalculatorByAges(3,"test")).thenReturn(3.14f);
        ResponseEntity<PiResultResponse> result = controllerTest.getPiResult(3,"test");
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertEquals(result.getBody().getPiNumberCalculated(), 3.14f);
    }

    @Test
    public void getResultWithExceptionTest() throws Exception {
        when(piFactoryMock.piCalculatorByAges(3,"longTimeAgo")).thenThrow(PiCalculatorMethodNotFoundException.class);
        PiCalculatorMethodNotFoundException thrown = Assertions.assertThrows( PiCalculatorMethodNotFoundException.class, () -> {
            ResponseEntity<PiResultResponse>  result = controllerTest.getPiResult(3,"longTimeAgo");
            Assertions.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
        });
    //    Assertions.assertEquals("Not method found for provided age", thrown.getMessage());
    }
}