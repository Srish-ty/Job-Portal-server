package org.project.jobportal.controller;

import org.project.jobportal.model.Application;
import org.project.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public Application apply(@RequestBody Application application) {
        return applicationService.apply(application);
    }

    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }
}
