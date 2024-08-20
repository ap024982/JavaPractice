package com.example.convertTemp.controller;

import com.example.convertTemp.model.temperature;
import com.example.convertTemp.service.TempConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class convertTemperature {

    @Autowired
    TempConvert t;
    @GetMapping("/convertToFar/{temp}")
    public temperature ConvertTempToFar(@PathVariable Float temp){
        //return "Abc";
        return t.calTempInFar(temp);
    }

    @GetMapping("/convertToCel/{temp}")
    public temperature ConvertTempToCel(@PathVariable Float temp){
       // return "Abc";
        return t.calTempInCelcius(temp);
    }
}
