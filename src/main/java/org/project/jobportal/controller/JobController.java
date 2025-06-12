package org.project.jobportal.controller;

import org.project.jobportal.model.Job;
import org.project.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.createJob(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job jobDetails) {
        return jobService.getJobById(id)
                // change only the fields that are being updated and not all the fields
                .map(job -> {
                    if (jobDetails.getTitle() != null) {
                        job.setTitle(jobDetails.getTitle());
                    }
                    if (jobDetails.getDescription() != null) {
                        job.setDescription(jobDetails.getDescription());
                    }
                    if (jobDetails.getCompany() != null) {
                        job.setCompany(jobDetails.getCompany());
                    }
                    if (jobDetails.getLocation() != null) {
                        job.setLocation(jobDetails.getLocation());
                    }
                    // Do not update postedAt here
                    return ResponseEntity.ok(jobService.createJob(job));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
