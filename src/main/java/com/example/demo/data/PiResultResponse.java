package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.NonNull;

@JsonInclude
public class PiResultResponse {

    @NonNull
    float piNumberCalculated = 0.0f;

    public PiResultResponse(float piNumberCalculated) {
        this.piNumberCalculated = piNumberCalculated;
    }

    public float getPiNumberCalculated() {
        return piNumberCalculated;
    }

    public void setPiNumberCalculated(float piNumberCalculated) {
        this.piNumberCalculated = piNumberCalculated;
    }
}
