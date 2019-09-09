package com.vs.mock.service.impl;

import com.vs.mock.service.AdditionService;
import org.springframework.stereotype.Component;

@Component
public class AdditionServiceImpl<T> implements AdditionService<T> {

    @Override
    public  int add(T one, T two) {
        System.out.println("**--- AdditionServiceImpl add executed ---**");
        return ((Integer) one + (Integer) two);
    }
}
