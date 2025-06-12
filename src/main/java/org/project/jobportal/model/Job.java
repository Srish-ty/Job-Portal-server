package org.project.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.project.jobportal.model.Company;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters, Setters, Constructors
}
