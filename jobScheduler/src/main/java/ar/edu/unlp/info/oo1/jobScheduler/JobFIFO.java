package ar.edu.unlp.info.oo1.jobScheduler;

import java.util.List;

public class JobFIFO implements JobPolicy {

    public JobDescription next(List<JobDescription> jobs) {
        return jobs.get(0);
    }
}
