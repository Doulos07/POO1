package ar.edu.unlp.info.oo1.jobScheduler;

import javax.print.attribute.standard.JobPriority;
import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected JobPolicy policy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
        this.policy = new JobFIFO();
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setPolicy(JobPolicy jobPolicy) {
        this.policy = jobPolicy;
    }

    public JobDescription next() {
        JobDescription nextJob = this.policy.next(jobs);
        this.unschedule(nextJob);
        return nextJob;
    }

}
