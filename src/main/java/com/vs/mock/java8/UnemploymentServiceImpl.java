package com.vs.mock.java8;

import java.util.Optional;
import java.util.stream.Stream;

public class UnemploymentServiceImpl implements UnemploymentService {

    private final JobService jobService;

    public UnemploymentServiceImpl(JobService jobService){
        this.jobService = jobService;
    }

    @Override
    public boolean personIsEntitledToUnemploymentSupport(Person person) {
        Optional<JobPosition> jobPosition =  jobService.findCurrentJobPosition(person);
        return !jobPosition.isPresent();
    }

    @Override
    public Optional<JobPosition> searchJob(Person person, String searchString) {
        Stream<JobPosition> jobPositionStream = jobService.listJobs(person);
        Optional<JobPosition> result = jobPositionStream.filter(list -> list.getTitle().contains(searchString)).findFirst();
        System.out.println("Serach Job "+(result.isPresent() ? result.get() : result));
        return result;

    }
}
