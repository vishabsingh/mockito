package com.vs.mock.service.impl;

import com.vs.mock.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalcutionServiceImp {

    @Autowired
    private AdditionService<Integer> integerAdditionService;

    public int calc(int num1,int num2){
        return integerAdditionService.add(num1,num2);
    }

}
