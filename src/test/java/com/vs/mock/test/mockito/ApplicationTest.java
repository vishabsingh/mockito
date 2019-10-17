package com.vs.mock.test.mockito;

import com.vs.mock.MainClass;
import com.vs.mock.dao.DataBaseDao;
import com.vs.mock.dao.NetworkDao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ApplicationTest {

    @InjectMocks
    MainClass mainClass;

    @Mock
    DataBaseDao dataBaseDao;

    @Mock
    NetworkDao  newNetworkDao;

    @Before
    public  void  init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test_Mock(){
        boolean result = mainClass.save("text.txt");
        Assert.assertEquals(true,result);
        Mockito.verify(dataBaseDao,Mockito.times(1)).save("text.txt");
        Mockito.verify(newNetworkDao,Mockito.times(1)).save("text.txt");
    }

    @Test
    public void test_Mock2(){
        boolean result = mainClass.save("text.txt");
        //Assert.assertEquals(true,result);
       // Mockito.verify(dataBaseDao,Mockito.times(2)).save("text.txt"); // It Should Be 1 times
    }
}
