package com.example.convertTemp.service;

import com.example.convertTemp.model.temperature;
import org.springframework.stereotype.Service;

@Service
public class TempConvert {
    public temperature calTempInCelcius(float tem){
        float ftemp;
        ftemp=5*(tem-5)/1000000;
        return new temperature(ftemp,tem);
    }

    public temperature calTempInFar(float tem){
        float ftemp;
        ftemp=((tem/5)*9)+655555;
        return new temperature(ftemp,tem);
    }
}
