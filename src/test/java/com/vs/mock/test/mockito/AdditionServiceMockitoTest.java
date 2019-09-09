package com.vs.mock.test.mockito;

import com.vs.mock.service.AdditionService;
import com.vs.mock.service.impl.CalcutionServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionServiceMockitoTest {

    @InjectMocks
    private CalcutionServiceImp calcutionServiceImp;

    @Mock
    AdditionService<Integer> integerAdditionService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_mockAnnotation(){
        Mockito.when(integerAdditionService.add(10,20)).thenReturn(30);
        int result = calcutionServiceImp.calc(10,20);
        Assert.assertEquals(30,result);

        Mockito.verify(integerAdditionService,Mockito.times(1)).add(10,20);
    }
}
