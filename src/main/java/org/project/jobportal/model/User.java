package org.project.jobportal.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users") // avoid reserved keyword
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String resumeLink;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Application> applications;

    // Getters, Setters, Constructors
}
