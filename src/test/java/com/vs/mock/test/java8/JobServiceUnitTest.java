package com.vs.mock.test.java8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import  static org.mockito.Mockito.when;

import com.vs.mock.java8.JobPosition;
import com.vs.mock.java8.JobService;
import com.vs.mock.java8.Person;
import com.vs.mock.java8.UnemploymentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.stream.Stream;

public class JobServiceUnitTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_givernDefauktMethod_whenCallREalMethod(){
        Person person = new Person();
        when(jobService.findCurrentJobPosition(person)).thenReturn(Optional.empty());
        assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(person));
        //doCallRealMethod().when(jobService).assignJobPosition(Mockito.any(Person.class), Mockito.any(JobPosition.class));
    }

    @Test
    public void test_UnEmployement(){
        Person person = new Person();
        when(jobService.listJobs(any(Person.class))).thenReturn(Stream.empty());
        assertFalse(unemploymentService.searchJob(person,"").isPresent());
    }

}
