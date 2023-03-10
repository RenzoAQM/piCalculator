package com.example.demo.exceptions.handler;

import com.example.demo.data.ErrorMessage;
import com.example.demo.exceptions.PiCalculatorMethodNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ControllerExceptionHandlerTest {

    @Test
    @DisplayName("Should not be null")
    void resourceNotFoundExceptionShouldNotBeNull() {
        assertThat(new ControllerExceptionHandler()).isNotNull();
    }

    @Test
    @DisplayName("Should not be null")
    void resourceNotFoundExceptionShouldReturnValue() {
        ControllerExceptionHandler exceptionHandler = new  ControllerExceptionHandler();
        PiCalculatorMethodNotFoundException ex = new PiCalculatorMethodNotFoundException("message test exception");
        WebRequest request = new ServletWebRequest(new MockHttpServletRequest());
        ResponseEntity<ErrorMessage> test = exceptionHandler.resourceNotFoundException(ex,request);

        assertThat(test.getBody()).isNotNull();
        assertThat(test.getBody().getMessage()).isEqualTo("message test exception");

    }
}