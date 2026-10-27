package ar.edu.unlp.info.oo1.jobScheduler;

import java.util.List;

public class JobHighestPriority implements JobPolicy {

    public JobDescription next(List<JobDescription> jobs) {
        return jobs.stream()
                .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                .orElse(null);
    }
}
