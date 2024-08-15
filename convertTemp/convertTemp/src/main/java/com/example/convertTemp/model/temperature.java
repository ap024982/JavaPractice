package com.example.convertTemp.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class temperature {


    float fTempInCelcius;
    float fTempInFar;

    public temperature(){}

    public temperature(float fTempInCelcius, float fTempInFar) {
        this.fTempInCelcius = fTempInCelcius;
        this.fTempInFar = fTempInFar;
    }

    public float getfTempInCelcius() {
        return fTempInCelcius;
    }

    public void setfTempInCelcius(float fTempInCelcius) {
        this.fTempInCelcius = fTempInCelcius;
    }

    public float getfTempInFar() {
        return fTempInFar;
    }

    public void setfTempInFar(float fTempInFar) {
        this.fTempInFar = fTempInFar;
    }
}
