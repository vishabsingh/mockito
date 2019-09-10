package com.vs.mock.test.java8;

import com.vs.mock.java8.JobPosition;
import com.vs.mock.java8.JobService;
import com.vs.mock.java8.Person;
import com.vs.mock.java8.UnemploymentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Stream;

public class CustomAnswerWithArgumentMatcherLambdaUnitTest {

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Mock
    private JobService jobService;

    @Test
    public void whenPersonWithJobHistory_thenSearchReturnsValue() {
        Person peter = new Person();
        peter.setName("TOM");
        assertEquals("SE", unemploymentService.searchJob(peter, "").get().getTitle());
    }

    @Test
    public void test_ArgumentMatcherWithLambdaUnitTest(){
        Person tom = new Person();
        tom.setName("TOM");

        Person person = new Person();
        person.setName("TEST");

        JobPosition jobPosition = new JobPosition("TEACHER");
//        when(jobService.findCurrentJobPosition(
//            ArgumentMatchers.argThat(p -> p.getName().equals("TEST"))
//        )).thenReturn(Optional.of(jobPosition));
//        assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(tom));
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(jobService.listJobs(any(Person.class))).then(item ->
            Stream.of(new JobPosition("SE"))
                .filter(p -> ((Person)item.getArgumentAt(0,Person.class)).getName().equals("TOM")));

    }
}
