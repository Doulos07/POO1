package ar.edu.unlp.info.oo1.jobScheduler;

import java.util.List;

public interface JobPolicy {
    public JobDescription next(List<JobDescription> jobs);
}
